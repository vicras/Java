package com.company.text.parsers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PunctuationParserTest {
    PunctuationParser parser = new PunctuationParser(null);
    @Test
    void check() {
        var check = parser.check(List.of("<code> fjgldg <code/>",
                ","
                ,"" ));
        assertEquals(check, ParseCases.PUNCTUATION);
    }
}