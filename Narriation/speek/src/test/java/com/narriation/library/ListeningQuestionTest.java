/**
 * @author Kevin Buie
 */
package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.narriation.ListeningQuestion;
import com.narriation.PartOfSpeech;
import com.narriation.Phrase;
import com.narriation.Word;
import com.narriation.Gender;

public class ListeningQuestionTest {
    private ListeningQuestion listeningQuestion;
    private Phrase phrase;

    @Before
    public void setup() {
        ArrayList<Word> englishPhrase = new ArrayList<>();
        ArrayList<Word> translatedPhrase = new ArrayList<>();

        englishPhrase.add(new Word("hello", "hola", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        englishPhrase.add(new Word("friend", "amigo", "ah-mee-go", PartOfSpeech.NOUN, Gender.MASCULINE, 1));

        translatedPhrase.add(new Word("hola", "hello", "oh-lah", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        translatedPhrase.add(new Word("amigo", "friend", "ah-mee-go", PartOfSpeech.NOUN, Gender.MASCULINE, 1));

        phrase = new Phrase("greeting", englishPhrase, translatedPhrase, 1);
        listeningQuestion = new ListeningQuestion(phrase);
    }

    @Test
    public void testGenerateQuestion() {
        String question = listeningQuestion.getQuestion();
        System.out.println("Generated Question: " + question);
        assertEquals("Type the phrase in Spanish: ", question);
    }

    @Test
    public void testGetAnswer() {
        String answer = listeningQuestion.getAnswer();
        assertEquals(listeningQuestion.getPhrase().getTranslatedPhrase().get(0).getTranslatedWord() + " " +
                     listeningQuestion.getPhrase().getTranslatedPhrase().get(1).getTranslatedWord(), answer);
    }

    @Test
    public void testGetPhrase() {
        assertEquals(phrase, listeningQuestion.getPhrase());
    }
}

