package com.company.text.lexems;

public interface Component extends Iterable<Component>{
    String outputText();

    void reloadIterator();

    default public boolean removeComponent(Component comp) {
        throw new UnsupportedOperationException();
    }

    default public void addNewComponent(Component comp) {
        throw new UnsupportedOperationException();
    }
}
