package com.company.text.lexems;

import com.company.text.Text;
import com.company.text.factory.TextFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TextTest {
    static String text2 = """
            hello world
            today rain, and weather is dull...
                        
            <code>
            #include <oistream>
                      
            int main(){
                cout << "Hello world";
            }
            <code/>
            The self-study lessons in this: section, are written and organised!!!
            according to the levels?! of the. Best in world. Common European. Framework of Res.
            """;

    static Text worker;

    @BeforeAll
    static void initTextWorker() {

        TextFactory tf = new TextFactory();
        worker = tf.getText(text2);

    }

    @Test
    void printWordsInOrder() {
        String s = worker.printWordsInOrder();
        System.out.println(s);

    }
}