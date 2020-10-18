package com.company.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleProvider {
    Locale locale;
    ResourceBundle bundle;

    static LocaleProvider provider = null;

    private LocaleProvider(Locale locale) {
        this.locale = locale;
        bundle = ResourceBundle.getBundle("LocaleBundle", locale);
    }

    public String getString(String key){
        return bundle.getString(key);
    }

    static public LocaleProvider instanceOf(Locale locale){
        if (provider == null) {
            provider = new LocaleProvider(locale);
        }
        return provider;
    }

}
