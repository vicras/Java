package com.company.text.factory;

import com.company.text.Text;
import org.junit.jupiter.api.Test;

class TextFactoryTest {
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

    String text2 = """
Here you can find activities to practise your reading skills. Reading will help you to improve your understanding of the language and build your vocabulary.

The self-study lessons in this section are written and organised according to the levels of the Common European Framework of Reference for languages (CEFR). There are different types of texts and interactive exercises that practise the reading skills you need to do well in your studies, , to get ahead at work and to communicate in English in your free time.
Take our free online English test to find out which level to choose. Select your level, from beginner (CEFR level A1) to advanced (CEFR level C1), and improve your reading skills at your own speed, whenever it's convenient for you.
            """;

    TextFactory tf = new TextFactory();
    @Test
    void getText() {
        Text text = tf.getText(this.text);
        text.swapSentences();
        String s = text.outputText();
        System.out.println(s);

    }

    @Test
    void testGetText() {
    }
}