package com.company.text.composition;

import com.company.text.lexems.*;
import com.company.text.iterator.TextIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TextWorkerImpl implements TextWorker {

    List<Component> childList;
    String delimiter = "\n";

    Paragraph paraLast;
    Sentence sentLast;
    EndSentencesSymbol endSentLast;

    public TextWorkerImpl() {
        childList = new ArrayList<>();
        paraLast = new Paragraph();
        childList.add(paraLast);
    }

    public void appendServiceSymbol(ServiceSymbols symbol) {
        if (sentLast == null) appendParagraph(symbol);
        else appendSentence(symbol);
    }

    public void appendText(Paragraph paragraph) {
        paraLast = paragraph;
        childList.add(paragraph);
        newParagraphChecker(paragraph);
    }

    public void addParagraph() {
        appendText(new Paragraph());
    }

    public void appendParagraph(Sentence sentence) {
        paraLast.addNewComponent(sentence);
        sentLast = sentence;
        newSentenceChecker(sentence);
    }

    public void appendParagraph(Code code) {
        paraLast.addNewComponent(code);
        endSentLast = null;
    }

    public void appendParagraph(ServiceSymbols symbols) {
        paraLast.addNewComponent(symbols);
    }

    public void addSentence() {
        appendParagraph(new Sentence());
    }

    public void appendSentence(Punctuation punctuation) {
        if (sentLast == null) throw new RuntimeException("can't add punctuation, sentence doesn't exist");
        sentenceAppendChecker(sentLast);
        sentLast.addNewComponent(punctuation);
    }

    public void appendSentence(Word word) {
        if (sentLast == null) addSentence();
        try {
            sentenceAppendChecker(sentLast);
        } catch (Exception e) {
            addSentence();
        }
        sentLast.addNewComponent(word);
    }

    public void appendSentence(ServiceSymbols symbols) {
        if (sentLast == null) addSentence();
        sentenceAppendChecker(sentLast);
        sentLast.addNewComponent(symbols);
    }

    public void appendSentence(EndSentencesSymbol endSentence) {
        if (sentLast == null) throw new RuntimeException("can't add end symbol, sentence doesn't exist");
        sentenceAppendChecker(sentLast);
        sentLast.addNewComponent(endSentence);
        endSentLast = endSentence;
    }

    public void addEndSentence() {
        appendSentence(new EndSentencesSymbol());
    }

    public void appendEndSentencePunctuation(Punctuation punctuation) {
        if (endSentLast == null) addEndSentence();
        endSentLast.addNewComponent(punctuation);
    }

    @Override
    public List<Sentence> getSentences() {
        Iterator<Component> iter = getIterator();
        List<Sentence> ans = new ArrayList<>();

        while (iter.hasNext()) {
            var t = iter.next();
            if (t.getClass().equals(Sentence.class))
                ans.add((Sentence) t);
        }
        return ans;
    }

    @Override
    public List<Paragraph> getParagraphs() {
        Iterator<Component> iter = getIterator();
        List<Paragraph> ans = new ArrayList<>();

        while (iter.hasNext()) {
            var t = iter.next();
            if (t.getClass().equals(Paragraph.class))
                ans.add((Paragraph) t);
        }
        return ans;
    }

    @Override
    public List<Code> getCodes() {
        Iterator<Component> iter = getIterator();
        List<Code> ans = new ArrayList<>();

        while (iter.hasNext()) {
            var t = iter.next();
            if (t.getClass().equals(Code.class))
                ans.add((Code) t);
        }
        return ans;
    }

    @Override
    public List<Word> getWords() {

        Iterator<Component> iter = getIterator();
        List<Word> ans = new ArrayList<>();

        while (iter.hasNext()) {
            var t = iter.next();
            if (t.getClass().equals(Word.class))
                ans.add((Word) t);
        }
        return ans;

    }


    @Override
    public String outputText() {
        return childList.stream().map(Component::outputText).collect(Collectors.joining(delimiter));
    }

    @Override
    public TextIterator getIterator() {
        childList.forEach(Component::reloadIterator);
        return new TextIterator(childList.iterator());
    }

    @Override
    public List<Component> getChildes() {
        return childList;
    }


    private void sentenceAppendChecker(Sentence sentence) {
        if (sentence.getLastElement() != null && sentence.getLastElement().getClass().equals(EndSentencesSymbol.class))
            throw new RuntimeException("Sentence can not be appended");
    }

    private void newParagraphChecker(Paragraph paragraph) {

        List<Component> childes;
        if (paragraph == null || (childes = paragraph.getChildes()).isEmpty()) {
            sentLast = null;
            endSentLast = null;
            return;
        }

        childes.forEach(e -> {
            if (e.getClass().equals(Sentence.class))
                sentLast = (Sentence) e;
        });
        newSentenceChecker(sentLast);
    }


    private void newSentenceChecker(Sentence sentence) {

        List<Component> childes;
        if (sentence == null || (childes = sentence.getChildes()).isEmpty()) {
            endSentLast = null;
            return;
        }
        childes.forEach(e -> {
            if (e.getClass().equals(EndSentencesSymbol.class))
                endSentLast = (EndSentencesSymbol) e;
        });
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

}
