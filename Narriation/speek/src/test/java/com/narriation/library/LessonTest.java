package com.narriation.library;

import static org.junit.Assert.*;
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

import java.util.ArrayList;
import java.util.UUID;

public class LessonTest {
    private UserProgress userProgress;
    private Language language;
    private Lesson lesson;

    @Before
    public void setUp() {
        // Create dummy language
        UUID languageId = UUID.randomUUID();
        ArrayList<Word> words = new ArrayList<>();
        ArrayList<Phrase> phrases = new ArrayList<>();
        ArrayList<Story> stories = new ArrayList<>();
        language = new Language(languageId, "Spanish", words, phrases, stories);

        // Create dummy user progress
        userProgress = new UserProgress(language);

        // Create a lesson
        lesson = new Lesson(userProgress, language);
    }

    @Test
    public void testGenerateQuestions() {
        // Assuming you have some phrases added to the language and user progress updated
        ArrayList<Question> questions = lesson.getQuestions();
        assertEquals(Lesson.NUMBER_OF_QUESTIONS, questions.size());
        // You can also add more specific assertions based on the type of questions generated
    }

    @Test
    public void testIncreaseScore() {
        lesson.increaseScore();
        assertEquals("1 / 0", lesson.getScore());
    }

    @Test
    public void testDecreaseScore() {
        lesson.increaseScore(); // Increase score first
        lesson.decreaseScore();
        assertEquals("0 / 0", lesson.getScore());
    }

    @Test
    public void testGetScore() {
        assertEquals("0 / 0", lesson.getScore());
        lesson.increaseScore();
        assertEquals("1 / 0", lesson.getScore());
    }

    // Add more tests as necessary based on the functionality of Lesson and UserProgress
}