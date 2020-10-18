package com.company.text;

import com.company.text.composition.TextWorker;
import com.company.text.composition.TextWorkerImpl;
import com.company.text.lexems.Sentence;
import com.company.text.lexems.Word;

import java.util.Comparator;
import java.util.List;

public class Text {

    TextWorker worker;

    public Text() {
        worker = new TextWorkerImpl();
    }

    public String outputText() {
        return worker.outputText();
    }

    public TextWorker getWorker() {
        return worker;
    }

    public void swapSentences() {
        List<Sentence> sentences = worker.getSentences();
        worker.getSentences().forEach(Sentence::swapFirstAndLastWord);
    }

    public String printWordsInOrder() {
        return worker.getWords().stream().sorted(Comparator.comparing(Word::getWord)).collect(new WordCollector());
    }
}

