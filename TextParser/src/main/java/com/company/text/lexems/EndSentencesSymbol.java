package com.company.text.lexems;

import com.company.text.iterator.TextIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EndSentencesSymbol implements Component {
    List<Component> childes;
    Iterator<Component> iterator;

    public EndSentencesSymbol() {
        childes = new ArrayList<>();
    }

    @Override
    public boolean removeComponent(Component comp) {
        boolean remove = childes.remove(comp);
        reloadIterator();
        return remove;
    }

    @Override
    public void addNewComponent(Component comp) {
        if (!(comp instanceof Punctuation))
            throw new RuntimeException("punctuation is only component of end sentence symbol");
        childes.add(comp);
        reloadIterator();
    }

    @Override
    public String outputText() {
        return childes.stream().map(Component::outputText).collect(Collectors.joining());
    }

    @Override
    public void reloadIterator() {
        iterator = childes.iterator();
    }

    @Override
    public Iterator<Component> iterator() {
        return new TextIterator(iterator);
    }

    @Override
    public String toString() {
        return "EndSentencesSymbol{" +
                "childes=" + childes +
                '}';
    }
}
