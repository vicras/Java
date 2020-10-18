package com.company.text.factory;

import com.company.text.Text;
import com.company.text.composition.TextWorker;
import com.company.text.parsers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TextFactory implements Factory {

    @Override
    public Text getText(String text) {
        List<String> strings = TextParser.parseText(text);
        var ans = new Text();
        var parser = initParsers(ans.getWorker());
        parser.check(List.of("",strings.get(0), strings.get(1)));

        for (int i = 1; i < strings.size()-1; i++) {
            parser.check(List.of(strings.get(i-1), strings.get(i), strings.get(i+1)));
        }

        parser.check(List.of(strings.get(strings.size()-2), strings.get(strings.size()-1), ""));

        return ans;
    }

    @Override
    public Text getText(Path path) throws IOException {
        var text = Files.lines(path).collect(Collectors.joining());
        return getText(text);
    }

    private Parser initParsers(TextWorker worker){
        CodeParser code = new CodeParser(worker);
        NextLineParser line = new NextLineParser(worker);
        ParagraphParser paragraph = new ParagraphParser(worker);
        PunctuationParser punctuation = new PunctuationParser(worker);
        SentenceEndParser sentence = new SentenceEndParser(worker);
        WordParser word = new WordParser(worker);

        word.link(punctuation);
        punctuation.link(line);
        line.link(sentence);
        sentence.link(code);
        code.link(paragraph);
        paragraph.link(null);

        return word;
    }
}
