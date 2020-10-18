package com.company.text.composition;

import com.company.text.lexems.*;
import com.company.text.iterator.TextIterator;

import java.util.List;

public interface TextWorker {

    void appendServiceSymbol(ServiceSymbols symbol);

    void appendText(Paragraph paragraph) ;

    void addParagraph();

    void appendParagraph(Sentence sentence) ;

    void appendParagraph(Code code);

    void addSentence();

    void appendSentence(Punctuation punctuation) ;

    void appendSentence(Word word) ;

    void appendSentence(ServiceSymbols symbols) ;

    void appendSentence(EndSentencesSymbol endSentence) ;

    void addEndSentence();

    void appendEndSentencePunctuation(Punctuation punctuation);

    List<Sentence> getSentences();

    List<Paragraph> getParagraphs();

    List<Code> getCodes();

    List<Word> getWords();

    String outputText();

    TextIterator getIterator();

    List<Component> getChildes();
}
