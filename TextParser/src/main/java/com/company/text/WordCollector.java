package com.company.text;

import com.company.text.lexems.Word;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class WordCollector implements Collector<Word, WordCollector, String> {

    private final StringBuilder builder;
    private char prChar;
    private boolean isFirst = true;

    public WordCollector() {
        builder = new StringBuilder();
        prChar = ' ';
    }

    @Override
    public Supplier<WordCollector> supplier() {
        return WordCollector::new;
    }

    WordCollector append(WordCollector a) {
        builder.append(a.builder);
        return this;
    }

    public String toString() {
        return builder.toString();
    }

    @Override
    public BiConsumer<WordCollector, Word> accumulator() {
        return (builder, word) -> {
            if (prChar != (word.getWord().charAt(0))) {
                prChar = word.getWord().charAt(0);
                if (isFirst) {
                    isFirst = false;
                    builder.builder.append("\t");
                } else builder.builder.append(".\n\t");
            } else builder.builder.append(", ");
            builder.builder.append(word.getWord());
        };
    }

    @Override
    public BinaryOperator<WordCollector> combiner() {
        return WordCollector::append;
    }

    @Override
    public Function<WordCollector, String> finisher() {
        return WordCollector::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}
