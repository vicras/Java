package com.company.text.lexems;

import com.company.text.iterator.EmptyTextIterator;

import java.util.Iterator;

public class ServiceSymbols implements Component {

    String symbol;

    public ServiceSymbols(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String outputText() {
        return symbol;
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
        return "ServiceSymbols{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
