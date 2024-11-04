package com.narriation.library;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.narriation.Language;
import com.narriation.Lesson;
import com.narriation.Phrase;
import com.narriation.Question;
import com.narriation.Story;
import com.narriation.UserProgress;
import com.narriation.Word;

import java.util.ArrayList;
import java.util.UUID;

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