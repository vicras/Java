package com.company.text.factory;

import com.company.text.Text;
import com.company.text.composition.TextWorker;
import com.company.text.lexems.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TextWorkerImplTest {
    static String text2 = """
            hello world
            today rain, and weather is dull...
            """;
                        
    static String r = """
            <code>
            #include <oistream>
                      
            int main(){
                cout << "Hello world";
            }
            <code/>
            The self-study lessons in this: section, are written and organised!!!
            according to the levels?! of the. Best in world. Common European. Framework of Res.
            """;

    static TextWorker worker;

    @BeforeAll
    static void initTextWorker() {

        TextFactory tf = new TextFactory();
        Text text = tf.getText(text2);
        worker = text.getWorker();
    }

    @org.junit.jupiter.api.Test
    void getSentences() {
        List<Sentence> sentences = worker.getSentences();
        assertNotNull(sentences);
    }

    @Test
    void getParagraphs() {
        List<Paragraph> paragraphs = worker.getParagraphs();
        assertNotNull(paragraphs);
    }

    @Test
    void getCodes() {
        List<Code> codes = worker.getCodes();
        assertNotNull(codes);
    }

    @Test
    void getWords(){
        List<Word> list = worker.getWords();
        assertNotNull(list);
    }

    @Test
    void getIterator(){
        List<Component>components = new ArrayList<>();
        Sentence sentence = new Sentence();
        Word word1 = new Word("word1");
        Punctuation punctuation1 = new Punctuation("punc1");
        Word word2 = new Word("word2");
        Punctuation punctuation2 = new Punctuation("punc2");
        Word word3 = new Word("word3");
        EndSentencesSymbol symbol = new EndSentencesSymbol();
        Punctuation punctuation21 = new Punctuation("endpunc1");
        Punctuation punctuation22 = new Punctuation("endpunc2");
        symbol.addNewComponent(punctuation21);
        symbol.addNewComponent(punctuation22);
        sentence.addNewComponent(word1);
        sentence.addNewComponent(punctuation1);
        sentence.addNewComponent(word2);
        sentence.addNewComponent(punctuation2);
        sentence.addNewComponent(word3);
        sentence.addNewComponent(symbol);

        Paragraph paragraph = new Paragraph();
        paragraph.addNewComponent(sentence);

        Iterator<Component> iterator1 = (paragraph.iterator());

        while(iterator1.hasNext()){

            System.out.println(iterator1.next());

        }
        paragraph.reloadIterator();
        iterator1 = (paragraph.iterator());

        while(iterator1.hasNext()){

            System.out.println(iterator1.next());

        }


    }

}