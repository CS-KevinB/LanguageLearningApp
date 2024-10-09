package com.narriation;

/**
 * @author kinsawills
 */
import java.util.ArrayList;

public class LanguageList {
    private static LanguageList languageList;
    private ArrayList<Language> languages;

    private LanguageList() {

    }

    public static LanguageList getInstance() {
        if (languageList == null)
            languageList = new LanguageList();
        return languageList;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }
}
