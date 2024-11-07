package com.narriation.library;
import com.narriation.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;
import java.util.ArrayList;

import org.junit.Test;


public class LanguageListTest {
    public static LanguageList languages = LanguageList.getInstance();
    public UUID uuid = UUID.randomUUID();
    public Language language = new Language(this.uuid, "Klingon", new ArrayList<Word>(), new ArrayList<Phrase>(),
            new ArrayList<Story>());
    
    @Test
    public void testValidGetLanguages() {
        languages.add(language);
        assertTrue(languages.getLanguages().size() == 1);
    }

    @Test
    public void testNullGetLanguages() {
        Language language = null;
        languages.add(language);
        assertTrue(languages.getLanguages().size() < 1);
    }
    
    @Test
    public void testEmptyGetLanguages() {
        assertTrue(languages.getLanguages().size() == 0);
    }

    @Test
    public void testRandomGetLanguageByUUID() {
        UUID randomUUID = UUID.randomUUID();
        assertTrue(languages.getLanguageByUUID(randomUUID) == null);
    }

    @Test
    public void testCorrectGetLanguageByUUID() {
        languages.add(language);
        assertTrue(languages.getLanguageByUUID(this.uuid).equals(language));
    }
}
