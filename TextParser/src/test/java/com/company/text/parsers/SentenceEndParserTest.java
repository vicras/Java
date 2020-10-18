package com.company.text.parsers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SentenceEndParserTest {

    SentenceEndParser parser = new SentenceEndParser(null);
    @Test
    void check() {
        var check = parser.check(List.of("<code> fjgldg <code/>",
                "\n"
                ,"" ));
        assertEquals(check, ParseCases.PARAGRAPH_END);
    }
}