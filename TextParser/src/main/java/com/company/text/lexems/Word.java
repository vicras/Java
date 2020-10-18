package com.company.text.lexems;

import com.company.text.iterator.EmptyTextIterator;

import java.util.Iterator;

public class Word implements Component {
    private String word;

    public Word(String word) {
        this.word = word.trim();
    }

    public String getWord() {
        return word;
    }

    @Override
    public String outputText() {
        return word;
    }

    @Override
    public void reloadIterator() {

    }

    @Override
    public Iterator<Component> iterator() {
        return new EmptyTextIterator();
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
