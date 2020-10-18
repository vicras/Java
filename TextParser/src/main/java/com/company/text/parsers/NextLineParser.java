package com.company.text.parsers;

import com.company.text.lexems.ServiceSymbols;
import com.company.text.composition.TextWorker;

import java.util.List;

public class NextLineParser extends Parser {


    public NextLineParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public NextLineParser(TextWorker worker) {
        super(worker);
    }

    @Override
    public ParseCases check(List<String> text){
        String input = text.get(1);
        if(input.matches(RegexProvider.PARAGRAPH_END) &&
                !(text.get(0).matches(RegexProvider.SENTENCE_END_SYMBOLS)||text.get(0).matches(RegexProvider.CODE_MATCHER))){
            worker.appendServiceSymbol(new ServiceSymbols(input));
            return ParseCases.NEW_LINE;
        }
        return checkNext(text);
    }
}
