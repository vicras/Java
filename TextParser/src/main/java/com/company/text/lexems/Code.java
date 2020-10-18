package com.company.text.lexems;

import com.company.text.iterator.EmptyTextIterator;

import java.util.Iterator;

public class Code implements Component{
    String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }

    @Override
    public String outputText() {
        return code;
    }

    @Override
    public void reloadIterator() {

    }

    @Override
    public Iterator<Component> iterator() {
        return new EmptyTextIterator();
    }


}
