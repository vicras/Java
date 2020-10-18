package com.company.text.lexems;

import com.company.text.iterator.TextIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence implements Component {
    List<Component> childes;
    Iterator<Component> iterator;
    int lastWordIndex = -1;

    public Sentence() {
        childes = new ArrayList<>();
    }

    private String getDelimiter(Component a, Component b) {
        if ((a instanceof Word) && (b instanceof Punctuation) || (a instanceof Punctuation) && (b instanceof Punctuation))
            return "";
        if ((a instanceof Word) && (b instanceof Word) || (a instanceof Punctuation) && (b instanceof Word))
            return " ";
        //throw new RuntimeException("something goes wrong");
        return "";
    }

    public Component getLastElement(){
        int i = childes.size() - 1;
        if(i<0) return null;
        return childes.get(i);
    }

    @Override
    public String outputText() {
        var ans = new StringBuilder();
        for (int i = 0; i < childes.size() - 1; i++) {
            ans.append(childes.get(i).outputText());
            ans.append(getDelimiter(childes.get(i), childes.get(i + 1)));
        }
        ans.append(childes.get(childes.size() - 1).outputText());
        return ans.toString();
    }

    @Override
    public void reloadIterator() {
        iterator = childes.iterator();
        childes.forEach(Component::reloadIterator);
    }

    @Override
    public Iterator<Component> iterator() {
        return new TextIterator(iterator);
    }

    @Override
    public boolean removeComponent(Component comp) {
        int index = childes.indexOf(comp);
        if (index > lastWordIndex) lastWordIndex--;
        boolean remove = childes.remove(comp);
        reloadIterator();
        return remove;
    }

    @Override
    public void addNewComponent(Component comp) {
        if (!(comp instanceof Word) && !(comp instanceof Punctuation)
                && !(comp instanceof EndSentencesSymbol)&& !(comp instanceof ServiceSymbols))
            throw new RuntimeException("word, punctuation, end and service symbols  are only components of sentence");
        if (comp instanceof Word) lastWordIndex = childes.size();
        childes.add(comp);
        reloadIterator();
    }


    public void swapFirstAndLastWord() {
        if (lastWordIndex == -1)
            throw new RuntimeException("last word doesn't exist");

        Component temp = childes.get(0);
        childes.set(0, childes.get(lastWordIndex));
        childes.set(lastWordIndex, temp);
    }

    public List<Component> getChildes() {
        return childes;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "childes=" + childes +
                ", lastWordIndex=" + lastWordIndex +
                '}';
    }
}
