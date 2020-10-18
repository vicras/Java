package com.company.text.parsers;

import com.company.locale.LocaleProvider;

import java.util.Locale;

public class RegexProvider {
    static  LocaleProvider provider = LocaleProvider.instanceOf(Locale.getDefault());
    public static final String WORD_MATCHER = provider.getString("WORD_MATCHER") ;
    public static final String SENTENCE_END_SYMBOLS = provider.getString("SENTENCE_END_SYMBOLS");
    public static final String PUNCTUATION = provider.getString("PUNCTUATION");
    public static final String PARAGRAPH_END = provider.getString("PARAGRAPH_END");
    public static final String CODE_MATCHER = provider.getString("CODE_MATCHER");
}
//    public static final String WORD_MATCHER = "[\\w-]+";
//    public static final String SENTENCE_END_SYMBOLS = "!|\\?|\\.";
//    public static final String PUNCTUATION = "[—;\\[\\])(,:]";
//    public static final String PARAGRAPH_END = "\\n";
//    public static final String CODE_MATCHER = "<code>[\\[\\](){}\\n;:\"\\w\\s<>#&*]*<code/>";