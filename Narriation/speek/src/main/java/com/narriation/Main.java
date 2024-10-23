package com.narriation;

import java.util.ArrayList;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Test for UserProgress - Create a new UserProgress object
        UserProgress userProgress = new UserProgress();
        Word word1 = new Word("Good morning!", "Buenos dias!", 1);
        Word word2 = new Word("Good night!", "Buenas noches!", 1);
        Word word3 = new Word("Hello!", "Hola!", 1);

        ArrayList<Word> englishPhrase = new ArrayList<>();
        englishPhrase.add(word1);
        englishPhrase.add(word2);

        ArrayList<Word> translatedPhrase = new ArrayList<>();
        translatedPhrase.add(new Word("Buenos dias!", "Good morning", 1));
        translatedPhrase.add(new Word("Buenas noches!", "Good night", 1));

        Phrase phrase = new Phrase("Try again!", englishPhrase, translatedPhrase, 1);

        // Check phrase seen count
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
    }

}
