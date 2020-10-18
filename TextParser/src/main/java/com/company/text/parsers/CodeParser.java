package com.company.text.parsers;

import com.company.text.lexems.Code;
import com.company.text.composition.TextWorker;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeParser extends Parser {

    public CodeParser(Parser next, TextWorker worker) {
        super(next, worker);
    }

    public CodeParser(TextWorker worker) {
        super(worker);
    }

    public ParseCases check(List<String> text){
        Pattern codeFinder = Pattern.compile(RegexProvider.CODE_MATCHER);
        String input = text.get(1);
        Matcher matcher = codeFinder.matcher(input);
        if(matcher.matches()){
            worker.appendParagraph(new Code(input));
            return ParseCases.CODE;
        }
        return checkNext(text);
    }


}
