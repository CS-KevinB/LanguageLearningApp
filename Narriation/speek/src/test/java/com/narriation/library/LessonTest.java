package com.narriation.library;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.narriation.Gender;
import com.narriation.Language;
import com.narriation.Lesson;
import com.narriation.PartOfSpeech;
import com.narriation.Phrase;
import com.narriation.Question;
import com.narriation.Story;
import com.narriation.UserProgress;
import com.narriation.Word;

public class LessonTest {
    private UserProgress userProgress;
    private Language language;
    private Lesson lesson;

    @Before
    public void setUp() {
        UUID languageId = UUID.randomUUID();
        ArrayList<Word> words = new ArrayList<>();
        ArrayList<Phrase> phrases = new ArrayList<>();
        ArrayList<Story> stories = new ArrayList<>();
        language = new Language(languageId, "Spanish", words, phrases, stories);
        userProgress = new UserProgress(language);

        // creating test words
        Word word = new Word("a", "b", "c", PartOfSpeech.ADJECTIVE, Gender.NEITHER, 0);
        ArrayList<Word> wordList = new ArrayList<Word>();

        Phrase phrA = new Phrase(UUID.randomUUID(), wordList, wordList, 1);
        Phrase phrB = new Phrase(UUID.randomUUID(), wordList, wordList, 1);
        Phrase phrC = new Phrase(UUID.randomUUID(), wordList, wordList, 1);
        Phrase phrD = new Phrase(UUID.randomUUID(), wordList, wordList, 1);
        Phrase phrE = new Phrase(UUID.randomUUID(), wordList, wordList, 1);

        phrases.add(phrA);
        phrases.add(phrB);
        phrases.add(phrC);
        phrases.add(phrD);
        phrases.add(phrE);

        this.language.addPhrases(phrases);

        lesson = new Lesson(userProgress, language);
    }

    @Test
    public void testGenerateQuestions() {
        ArrayList<Question> questions = lesson.getQuestions();
        assertEquals(Lesson.NUMBER_OF_QUESTIONS, questions.size());
    }

    @Test
    public void testIncreaseScore() {
        lesson.increaseScore();
        assertEquals("1 / 0", lesson.getScore());
    }

    @Test
    public void testDecreaseScore() {
        lesson.increaseScore(); 
        lesson.decreaseScore();
        assertEquals("0 / 0", lesson.getScore());
    }

    @Test
    public void testGetScore() {
        assertEquals("0 / 0", lesson.getScore());
        lesson.increaseScore();
        assertEquals("1 / 0", lesson.getScore());
    }

}