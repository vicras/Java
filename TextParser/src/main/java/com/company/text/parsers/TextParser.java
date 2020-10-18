package com.company.text.parsers;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextParser {
    static public List<String> parseText(String text) {
        Pattern pattern = Pattern.compile(
                        "(" + RegexProvider.CODE_MATCHER + ")|" +
                        "(" + RegexProvider.SENTENCE_END_SYMBOLS + ")|" +
                        "(" + RegexProvider.PARAGRAPH_END + ")|" +
                        "(" + RegexProvider.WORD_MATCHER + ")|" +
                        "(" + RegexProvider.PUNCTUATION + ")"
        );
        Matcher matcher = pattern.matcher(text);
        return matcher.results().map(MatchResult::group).collect(Collectors.toList());
    }
}
