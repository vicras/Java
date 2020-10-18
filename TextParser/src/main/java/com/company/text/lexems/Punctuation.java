package com.company.text.lexems;

import com.company.text.iterator.EmptyTextIterator;

import java.util.Iterator;

public class Punctuation implements Component{
    String punctuation;

    public Punctuation(String punctuation) {
        this.punctuation = punctuation.trim();
    }

    public String getPunctuation() {
        return punctuation;
    }

    @Override
    public String toString() {
        return "Punctuation{" +
                "punctuation='" + punctuation + '\'' +
                '}';
    }

    @Override
    public String outputText() {
        return punctuation;
    }

    @Override
    public void reloadIterator() {

    }

    @Override
    public Iterator<Component> iterator() {
        return new EmptyTextIterator();
    }
}
