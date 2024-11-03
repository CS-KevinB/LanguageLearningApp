/**
 * @author Risha Patel
 */
package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import com.narriation.Gender;
import com.narriation.Language;
import com.narriation.PartOfSpeech;
import com.narriation.Phrase;
import com.narriation.Story;
import com.narriation.Word;
import com.narriation.MultipleChoiceQuestion;

public class MultipleChoiceQuestionTest {
    private MultipleChoiceQuestion multipleChoiceQuestion;
    private Phrase phrase;
    private Language language;

    @Before
    public void setup() {
        ArrayList<Word> englishPhrase = new ArrayList<>();
        ArrayList<Word> translatedPhrase = new ArrayList<>();

        englishPhrase.add(new Word("hello", "hola", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        englishPhrase.add(new Word("friend", "amigo", "ah-mee-go", PartOfSpeech.NOUN, Gender.MASCULINE, 1));

        translatedPhrase.add(new Word("hello", "hola", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        translatedPhrase.add(new Word("friend", "amigo", "ah-mee-go", PartOfSpeech.NOUN, Gender.MASCULINE, 1));

        phrase = new Phrase("greeting", englishPhrase, translatedPhrase, 1);
        ArrayList<Phrase> phrases = new ArrayList<>();
        phrases.add(phrase);
        language = new Language(UUID.randomUUID(), "Spanish", new ArrayList<Word>(), phrases, new ArrayList<Story>());
        multipleChoiceQuestion = new MultipleChoiceQuestion(phrase, language);
    }

    @Test
    public void testTesting() {
        assertTrue(true);
    }

}
