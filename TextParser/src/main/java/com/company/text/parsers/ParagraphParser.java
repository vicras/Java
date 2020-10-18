package com.company.text.parsers;

import com.company.text.composition.TextWorker;

import java.util.List;

public class ParagraphParser extends Parser {

    public ParagraphParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public ParagraphParser(TextWorker worker) {
        super(worker);
    }

    @Override
    public ParseCases check(List<String> text){
        String input = text.get(1);
        if(input.matches(RegexProvider.PARAGRAPH_END) &&
                (text.get(0).matches(RegexProvider.SENTENCE_END_SYMBOLS)||text.get(0).matches(RegexProvider.CODE_MATCHER))){
            worker.addParagraph();
            return ParseCases.PARAGRAPH_END;
        }
        return checkNext(text);
    }
}
