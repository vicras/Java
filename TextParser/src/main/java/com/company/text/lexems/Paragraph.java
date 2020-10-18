package com.company.text.lexems;

import com.company.text.iterator.TextIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Paragraph implements Component {

    List<Component> childes;
    Iterator<Component> iterator;

    public List<Component> getChildes() {
        return childes;
    }

    public Paragraph() {
        childes = new ArrayList<>();
    }

    @Override
    public String outputText() {
//        var ans = new StringBuilder();
//        for (int i=0; i< childes.size()-1;i++){
//            ans.append(childes.get(i));
//            ans.append(getDelimiter(childes.get(i), childes.get(i+1)));
//        }
//        ans.append(childes.get(childes.size()-1));


        return childes.stream().
                map(e -> {
                    if (e.getClass().equals(ServiceSymbols.class)) return e.outputText();
                    return e.outputText() + " ";
                })
                .collect(Collectors.joining());
    }

    @Override
    public void reloadIterator() {
        iterator = childes.iterator();
        childes.forEach(Component::reloadIterator);
    }

    private String getDelimiter(Component a, Component b) {
        if (a.getClass().equals(ServiceSymbols.class)) return "";
        return " ";
    }

    @Override
    public Iterator<Component> iterator() {
        return new TextIterator(iterator);
    }

    @Override
    public boolean removeComponent(Component comp) {
        boolean remove = childes.remove(comp);
        reloadIterator();
        return remove;
    }

    @Override
    public void addNewComponent(Component comp) {
        if (!(comp instanceof Sentence) && !(comp instanceof Code) && !(comp instanceof ServiceSymbols))
            throw new RuntimeException("code, sentence and service symbols are only components of paragraph");
        childes.add(comp);
        reloadIterator();
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "childes=" + childes +
                '}';
    }
}
