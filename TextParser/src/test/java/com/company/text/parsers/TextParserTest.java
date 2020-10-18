package com.company.text.parsers;

import org.junit.jupiter.api.Test;

import java.util.List;

class TextParserTest {

    String text = """
            hello world
            today rain, and weather is dull...
            
            <code>
            #include <oistream>
          
            int main(){
                cout << "Hello world";
            }
            <code/>
            The self-study lessons in this: section, are written and organised!!!
            according to the levels?! of the Common European. Framework of Res.
            """;

    @Test
    void parseText() {
        List<String> strings = TextParser.parseText(text);
        strings.forEach(e -> System.out.println(e));
    }
}