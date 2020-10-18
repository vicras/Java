package com.company.text.parsers;

import com.company.text.lexems.Word;
import com.company.text.composition.TextWorker;

import java.util.List;

public class WordParser extends Parser {

    public WordParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public WordParser(TextWorker worker) {
        super(worker);
    }

    @Override
    public ParseCases check(List<String> text){
        String input = text.get(1);
        if(input.matches(RegexProvider.WORD_MATCHER)){
            worker.appendSentence(new Word(input));
            return ParseCases.WORD;
        }
        return checkNext(text);
    }
}
