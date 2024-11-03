package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;

import com.narriation.TrueFalseQuestion;
import com.narriation.PartOfSpeech;
import com.narriation.Phrase;
import com.narriation.Word;
import com.narriation.Language;
import com.narriation.Gender;

public class TrueFalseQuestionTest {
    private TrueFalseQuestion trueFalseQuestion;
    private Phrase phrase;
    private Language language;

    @Before
    public void setup() {
        UUID languageId = UUID.randomUUID();
        ArrayList<Phrase> phrases = new ArrayList<>();

        ArrayList<Word> englishPhrase = new ArrayList<>();
        ArrayList<Word> translatedPhrase = new ArrayList<>();

        englishPhrase.add(new Word("hello", "hola", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        translatedPhrase.add(new Word("hola", "hello", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));

        phrase = new Phrase("greeting", englishPhrase, translatedPhrase, 1);
        phrases.add(phrase);

        language = new Language(languageId, "Spanish", new ArrayList<>(), phrases, new ArrayList<>());

        trueFalseQuestion = new TrueFalseQuestion(phrase, language);
    }

    @Test
    public void testGenerateQuestion() {
        String question = trueFalseQuestion.getQuestion();
        System.out.println("Generated Question: " + question);
        assertTrue(question.contains("Does") && question.contains("translate to"));
    }

    @Test
    public void testGetAnswer() {
        String answer = trueFalseQuestion.getAnswer();
        assertEquals("true", answer); 
    }

    @Test
    public void testGetPhrase() {
        assertEquals(phrase, trueFalseQuestion.getPhrase());
    }

    @Test
    public void testIsCorrect() {
        assertTrue(trueFalseQuestion.isCorrect("true") || trueFalseQuestion.isCorrect("false"));
    }
}