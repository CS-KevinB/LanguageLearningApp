package com.narriation;

import java.util.ArrayList;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Test for UserProgress - Create a new UserProgress object
        UserProgress userProgress = new UserProgress();

        Word word1 = new Word("Good morning!", "Buenos dias!", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1);
        Word word2 = new Word("Good night!", "Buenas noches!", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1);
        Word word3 = new Word("Hello!", "Hola!", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1);

        ArrayList<Word> englishPhrase = new ArrayList<>();
        englishPhrase.add(word1);
        ArrayList<Word> translatedPhrase = new ArrayList<>();
        translatedPhrase.add(new Word("Buenos dias!", "Good morning", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1));

        Phrase phrase = new Phrase("Try again!", englishPhrase, translatedPhrase, 1);

        ArrayList<Word> englishPhrase2 = new ArrayList<>();
        englishPhrase2.add(word2);
        ArrayList<Word> translatedPhrase2 = new ArrayList<>();
        translatedPhrase2.add(new Word("Buenas noches!", "Good night", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        Phrase phrase2 = new Phrase("Try again!", englishPhrase2, translatedPhrase2, 1);

        ArrayList<Word> englishPhrase3 = new ArrayList<>();
        englishPhrase3.add(word3);
        ArrayList<Word> translatedPhrase3 = new ArrayList<>();
        translatedPhrase3.add(new Word("Hola!", "Hello", " ", PartOfSpeech.NOUN, Gender.NEITHER, 1));
        Phrase phrase3 = new Phrase("Try again!", englishPhrase3, translatedPhrase3, 1);

        ArrayList<Phrase> phrases = new ArrayList<>();
        phrases.add(phrase);
        phrases.add(phrase2);
        phrases.add(phrase3);

        // Check phrase seen count - Test for UserProgress
        System.out.println("Initial phrase seen count: " + userProgress.getPhraseSeenCounter(phrase));
        userProgress.incrementPhraseSeenCounter(phrase);
        System.out.println("Incremented phrase seen count: " + userProgress.getPhraseSeenCounter(phrase));
        userProgress.incrementPhraseSeenCounter(phrase);
        System.out.println("Incremented phrase seen count: " + userProgress.getPhraseSeenCounter(phrase));

        // Check phrase correct count
        // userProgress.setPhraseCorrectCounter(phrase, 1);
        userProgress.incrementPhraseSeenCounter(phrase);
        System.out.println("Phrase correct count: " + userProgress.getPhraseCorrectCounter(phrase));

        Date lastSeen = userProgress.getPhraseLastSeen(phrase);
        System.out.println("Last seen date: " + lastSeen);

        // Test displayQuestion - MCQ
        System.out.println("Question 1");
        Facade.getInstance().setPhrases(phrases);
        Facade.getInstance().displayQuestion(phrase);

        System.out.println("Question 2");
        Facade.getInstance().displayQuestion(phrase2);
        System.out.println("Question 3");
        Facade.getInstance().displayQuestion(phrase3);
    }

}
