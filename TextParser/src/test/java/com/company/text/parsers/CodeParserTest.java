package com.company.text.parsers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CodeParserTest {

    @org.junit.jupiter.api.Test
    void check() {
        CodeParser parser = new CodeParser(null);
        var check = parser.check(List.of("",
                "<code>\n" +
                "#include <oistream>\n" +
                "int main(){\n" +
                "         cout << \"Hello world\";\n" +
                "}\n" +
                "<code/>" ,"" ));
        assertEquals(check, ParseCases.CODE);

    }
}