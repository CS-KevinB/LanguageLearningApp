package com.narriation;

/**
 * @author kinsawills
 */
import java.util.ArrayList;
import java.util.UUID;

public class LanguageList {
    private static LanguageList languageList;
    private ArrayList<Language> languages;

    private LanguageList() {
        languages = DataLoader.getLanguages();
    }

    public static LanguageList getInstance() {
        if (languageList == null)
            languageList = new LanguageList();
        return languageList;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public Language getLanguageByUUID(UUID id) {
        for (Language language : languages) {
            if (language.getUUID().equals(id))
                return language;
        }
        return null;
    }
}
