package com.narriation.library;

import com.narriation.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.UUID;

<<<<<<< HEAD
public class MultipleChoiceQuestionTest {
    
}
=======
import org.junit.Before;
import org.junit.BeforeClass;
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

    @BeforeClass
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
>>>>>>> ffd3042a95c3e671df70a8e393ec4f4f4542ae98
