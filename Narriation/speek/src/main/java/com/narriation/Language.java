package com.narriation;

/**
 * @author kinsawills
 */
import java.util.ArrayList;
import java.util.UUID;

public class Language {
    private UUID id;
    private String nameOfLanguage;
    private ArrayList<Word> words;
    private ArrayList<Phrase> phrases;
    private ArrayList<Story> stories;

    public Language(UUID id, String nameOfLanguage, ArrayList<Word> words,
            ArrayList<Phrase> phrases) {
        this.id = id;
        this.nameOfLanguage = nameOfLanguage;
        this.words = words;
        this.phrases = phrases;
    }

    public String getLanguage() {
        return nameOfLanguage;
    }

    public UUID getUUID() {
        return id;
    }

    // Method to retrieve words based on a difficulty level (optional, for
    // exercises)
    public ArrayList<Word> getWordsByDifficulty(int difficulty) {
        ArrayList<Word> wordsByDifficulty = new ArrayList<>();
        for (Word word : words) {
            if (word.getDifficulty() == difficulty) {
                wordsByDifficulty.add(word);
            }
        }
        return wordsByDifficulty;
    }

    // Method to retrieve phrases based on a difficulty level
    public ArrayList<Phrase> getPhrasesByDifficulty(int difficulty) {
        ArrayList<Phrase> phrasesByDifficulty = new ArrayList<>();
        for (Phrase phrase : phrases) {
            if (phrase.getDifficulty() == difficulty) {
                phrasesByDifficulty.add(phrase);
            }
        }
        return phrasesByDifficulty;
    }

    public static void main(String[] args) {
        // Initialize words and phrases for Spanish
        ArrayList<Word> spanishWords = new ArrayList<>();
        ArrayList<Phrase> spanishPhrases = new ArrayList<>();

        spanishWords.add(new Word("Good morning", "Buenos días", 1));
        spanishPhrases.add(new Phrase("Good morning", "Buenos días", "Try again!", 1));

        // Create the Spanish language object
        Language spanish = new Language(UUID.randomUUID(), "Spanish", spanishWords, spanishPhrases);

        // Adding new words and phrases dynamically
        spanish.addWord(new Word("Good night", "Buenas noches", 1));
        spanish.addPhrase(new Phrase("Good night", "Buenas noches", "Try again!", 1));

        // Retrieve words and phrases by difficulty
        ArrayList<Phrase> easyPhrases = spanish.getPhrasesByDifficulty(1);
        for (Phrase phrase : easyPhrases) {
            System.out.println("Phrase: " + phrase.getEnglishPhrase() + " - " + phrase.getTranslatedPhrase());
        }
    }

    private void addWord(Word word) {
        if (word != null) {
            words.add(word);
            System.out.println("Word added: " + word.getEnglishWord());
        } else {
            System.out.println("Cannot add null word.");
        }
    }

    private void addPhrase(Phrase phrase) {
        if (phrase != null) {
            phrases.add(phrase);
            System.out.println("Phrase added: " + phrase.getEnglishPhrase());
        } else {
            System.out.println("Cannot add null phrase.");
        }
    }

}
