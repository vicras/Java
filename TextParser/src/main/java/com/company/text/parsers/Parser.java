package com.company.text.parsers;

import com.company.text.composition.TextWorker;

import java.util.List;

public abstract class Parser {
    Parser next;
    TextWorker worker;

    public void link(Parser next){
        this.next = next;
    }

    public Parser(Parser next, TextWorker worker) {
        this.next = next;
        this.worker = worker;
    }

    public Parser(TextWorker worker){
        this.worker = worker;
    }

    public abstract ParseCases check(List<String>  text);

    public ParseCases checkNext(List<String> text){
        if(next == null){
            throw new RuntimeException("Parsers can't parse this line");
        }

        return next.check(text);
    }

}
