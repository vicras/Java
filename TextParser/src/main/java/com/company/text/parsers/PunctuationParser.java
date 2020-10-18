package com.company.text.parsers;

import com.company.text.lexems.Punctuation;
import com.company.text.composition.TextWorker;

import java.util.List;

public class PunctuationParser extends Parser {

    public PunctuationParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public PunctuationParser(TextWorker worker) {
        super(worker);
    }

    @Override
    public ParseCases check(List<String> text){
        String input = text.get(1);
        if(input.matches(RegexProvider.PUNCTUATION)){
            worker.appendSentence(new Punctuation(input));
            return ParseCases.PUNCTUATION;
        }
        return checkNext(text);
    }
}
