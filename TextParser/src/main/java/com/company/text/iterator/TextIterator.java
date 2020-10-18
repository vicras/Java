package com.company.text.iterator;

import com.company.text.lexems.Component;

import java.util.*;

public class TextIterator implements Iterator<Component> {

    Stack<Iterator<Component>> iteratorStack;


    public TextIterator(Iterator<Component> iter) {
        iteratorStack = new Stack<>();
        iteratorStack.push(iter);
    }

    @Override
    public boolean hasNext() {
        if(iteratorStack.isEmpty()) return false;

        Iterator<Component> iter = iteratorStack.peek();

        if(iter.hasNext()){
            return true;
        }else{
            iteratorStack.pop();
            return hasNext();
        }
    }

    @Override
    public Component next() {
        if(hasNext()){
            Iterator<Component> iter = iteratorStack.peek();
            Component next = iter.next();
            iteratorStack.push(next.iterator());

            return next;
        }
        return null;
    }
}
