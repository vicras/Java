package com.company.text.parsers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NextLineParserTest {

    NextLineParser parser = new NextLineParser(null);
    @Test
    void check() {
        var check = parser.check(List.of("",
                        "\n"
                         ,"" ));
        assertEquals(check, ParseCases.NEW_LINE);
    }
}