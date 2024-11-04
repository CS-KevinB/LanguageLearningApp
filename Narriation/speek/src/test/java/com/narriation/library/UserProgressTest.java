package com.narriation.library;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.narriation.DataLoader;
import com.narriation.Language;
import com.narriation.LanguageList;
import com.narriation.Phrase;
import com.narriation.UserProgress;


public class UserProgressTest {
    private ArrayList<Language> languages = DataLoader.getLanguages();
    private UserProgress userProgress = new UserProgress(languages.get(0));
    private HashMap<Phrase, Integer> phraseProgress = userProgress.getPhraseProgress();

    @BeforeClass
    public static void setUp() {
        
    }

    @Test
    public void testValidDisplayHardPhrases() {
        UserProgress userProgress = new UserProgress(LanguageList.getInstance().getLanguages().get(0));
        String phrases = userProgress.displayHardPhrases();
        assertTrue(phrases.length() > 0);
    }

    @Test
    public void testNullDisplayHardPhrases() {
        UserProgress userProgress = new UserProgress(LanguageList.getInstance().getLanguages().get(0));
        phraseProgress = null;
        assertNull(userProgress.displayHardPhrases());
    }

    @Test
    public void testEmptyDisplayHardPhrases() {
        UserProgress userProgress = new UserProgress(LanguageList.getInstance().getLanguages().get(0));
        phraseProgress = new HashMap<Phrase, Integer>();
        assertNotNull(userProgress.displayHardPhrases());
    }
}
