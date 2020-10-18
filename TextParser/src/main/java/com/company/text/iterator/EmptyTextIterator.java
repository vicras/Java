package com.company.text.iterator;

import com.company.text.lexems.Component;

import java.util.Iterator;

public class EmptyTextIterator implements Iterator<Component> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Component next() {
        return null;
    }
}
