package com.narriation;

import java.util.ArrayList;
import java.util.UUID;

import software.amazon.awssdk.services.polly.endpoints.internal.Value.Str;

/**
 * The phrase class contains lists of words for each phrase
 * and feedback
 * 
 * @author Risha Patel;
 */

public class Phrase {
    private UUID id;
    private ArrayList<Word> englishPhrase;
    private ArrayList<Word> translatedPhrase;
    private int difficulty;

    /**
     * Constructor for phrase class
     * 
     * @param englishPhrase    - list of words for the english phrase
     * @param translatedPhrase - list of words for the translated phrase
     */

    public Phrase(String feedback, ArrayList<Word> englishPhrase, ArrayList<Word> translatedPhrase, int difficulty) {
        this.id = UUID.randomUUID();
        this.englishPhrase = englishPhrase;
        this.translatedPhrase = translatedPhrase;
        this.difficulty = difficulty;
    }

    /**
     * Constructor for data loader
     * 
     * @author Christian Ruff
     * @param id
     * @param englishPhrase
     * @param translatedPhrase
     * @param difficulty
     */
    public Phrase(UUID id, ArrayList<Word> englishPhrase, ArrayList<Word> translatedPhrase,
            int difficulty) {
        this.id = UUID.randomUUID();
        this.englishPhrase = englishPhrase;
        this.translatedPhrase = translatedPhrase;
        this.difficulty = difficulty;
    }

    /**
     * Getter method for english phrase
     * 
     * @return - list of words for the english phrase
     */
    public ArrayList<Word> getEnglishPhrase() {
        return englishPhrase;
    }

    /**
     * Getter method for translated phrase
     * 
     * @return - list of words for the translated phrase
     */
    public ArrayList<Word> getTranslatedPhrase() {
        return translatedPhrase;
    }

    // TODO: TEST THIS!!!
    public void phraseSeen() {
        UserProgress userProgress = Facade.getInstance().getCurrentUser().getUserProgress();
        userProgress.incrementPhraseSeenCounter(this);
    }

    /**
     * Creates a string representation of the phrase
     * @return returns the phrase as a string
     */
    public String toString() {
        return "ID: " + this.id + "\n  ENGLISH: " + this.englishPhrase + "\n  TRNSLTD: " + this.translatedPhrase
                + "\n\n";
    }

    /**
     * Gets the difficulty of the phrase or word
     * @return returns the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
}
