package com.company.text.parsers;

import com.company.text.lexems.Punctuation;
import com.company.text.composition.TextWorker;

import java.util.List;

public class SentenceEndParser extends Parser {

    public SentenceEndParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public SentenceEndParser(TextWorker worker) {
        super(worker);
    }

    @Override
    public ParseCases check(List<String> text){
        String input = text.get(1);
        if(input.matches(RegexProvider.SENTENCE_END_SYMBOLS) && text.get(2).matches(RegexProvider.SENTENCE_END_SYMBOLS)){
            worker.appendEndSentencePunctuation(new Punctuation(input));
            return ParseCases.SENTENCE_END_SYMBOL;
        }
        if(input.matches(RegexProvider.SENTENCE_END_SYMBOLS) && !text.get(2).matches(RegexProvider.SENTENCE_END_SYMBOLS)){
            worker.appendEndSentencePunctuation(new Punctuation(input));
            return ParseCases.SENTENCE_END;
        }
        return checkNext(text);
    }
}
