package com.narriation.library;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.UUID;

import com.narriation.Gender;
import com.narriation.Language;
import com.narriation.PartOfSpeech;
import com.narriation.Phrase;
import com.narriation.Story;
import com.narriation.Word;
import com.narriation.WritingQuestion;
import com.narriation.TrueFalseQuestion;

public class TrueFalseQuestionTest {
    private TrueFalseQuestion trueFalseQuestion;
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
        language = new Language(UUID.randomUUID(), "Spanish", new ArrayList<Word>(), new ArrayList<Phrase>(),
                new ArrayList<Story>());
        TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion(phrase, language);
    }

    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Test
    public void testGenerateQuestionFormat() {
        String question = trueFalseQuestion.getQuestion();
        assertTrue(question.contains("Enter True or False"));
        assertTrue(question.contains("Does \""));
        assertTrue(question.contains("\" translate to \""));
    }

}
