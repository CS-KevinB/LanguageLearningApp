package com.narriation;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

public class TrueFalseQuestionTest {

    private TrueFalseQuestion question;
    private Phrase phrase;
    private ArrayList<Word> englishWords;
    private ArrayList<Word> translatedWords;
    private Language mockLanguage;

    @Before
    public void setUp() {
        // Create mock Word objects with Gender set to NEITHER
        Word word1 = new Word("Hello", "Hola", "həˈloʊ", PartOfSpeech.NOUN, Gender.NEITHER, 1);
        Word word2 = new Word("World", "Mundo", "wɜːrld", PartOfSpeech.NOUN, Gender.NEITHER, 1);
        
        // Create English and Translated phrases
        englishWords = new ArrayList<>();
        translatedWords = new ArrayList<>();
        
        englishWords.add(word1);
        englishWords.add(word2);
        
        translatedWords.add(word1); // Assuming translations are identical for testing
        translatedWords.add(word2);

        // Create a Phrase object with the mocked words
        phrase = new Phrase("This is a test feedback", englishWords, translatedWords, 1);
        
        // Create a mock Language object
        ArrayList<Phrase> phrases = new ArrayList<>();
        phrases.add(phrase);
        mockLanguage = new Language(UUID.randomUUID(), "Test Language", new ArrayList<>(), phrases, new ArrayList<>());

        // Create a TrueFalseQuestion with the phrase and mock Language
        question = new TrueFalseQuestion(phrase, mockLanguage);
    }

    @Test
    public void testGetTranslatedStr() {
        // Expected translation string
        String expectedTranslatedStr = "Hola Mundo"; // Adjust as per actual translations
        String actualTranslatedStr = question.getTranslatedStr();
        
        assertEquals(expectedTranslatedStr, actualTranslatedStr);
    }

    @Test
    public void testGetEnglishPhrase() {
        // Retrieve the English phrase directly from the Phrase object
        StringBuilder expectedEnglishStr = new StringBuilder();
        for (Word word : phrase.getEnglishPhrase()) {
            expectedEnglishStr.append(word.getEnglishWord()).append(" ");
        }
        String actualEnglishStr = expectedEnglishStr.toString().trim();
    
        assertEquals(actualEnglishStr, question.getTranslatedStr()); // Adjust based on your logic
    }

    @Test
    public void testGetDifficulty() {
        // Test the difficulty retrieval
        int expectedDifficulty = 1; // Difficulty set in Phrase
        int actualDifficulty = phrase.getDifficulty();

        assertEquals(expectedDifficulty, actualDifficulty);
    }

    @Test
    public void testToString() {
        // Test the string representation of the question
        String expectedString = "Is this phrase correct?"; // Adjust based on your implementation
        String actualString = question.toString(); // Assuming you have a toString method

        assertEquals(expectedString, actualString);
    }
}