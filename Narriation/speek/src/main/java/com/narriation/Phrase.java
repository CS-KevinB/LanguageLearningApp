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
    private String feedback;
    private ArrayList<Word> englishPhrase;
    private ArrayList<Word> translatedPhrase;
    private int difficulty;

    /**
     * Constructor for phrase class
     * 
     * @param feedback         - feedback for the phrase
     * @param englishPhrase    - list of words for the english phrase
     * @param translatedPhrase - list of words for the translated phrase
     */

    public Phrase(String feedback, ArrayList<Word> englishPhrase, ArrayList<Word> translatedPhrase, int difficulty) {
        this.id = UUID.randomUUID();
        this.feedback = feedback;
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

    /**
     * Gets the Feedback
     * 
     * @return feedback
     */
    public String getFeedback() {
        return feedback;
    }

    public void setFeedBack(String feedback) {
        this.feedback = feedback;
    }

    // TODO: TEST THIS!!!
    public void phraseSeen() {
        UserProgress userProgress = Facade.getInstance().getCurrentUser().getUserProgress();
        userProgress.incrementPhraseSeenCounter(this);
    }

    public String toString() {
        return "ID: " + this.id + "\n  ENGLISH: " + this.englishPhrase + "\n  TRNSLTD: " + this.translatedPhrase
                + "\n  FEEDBACK: " + this.feedback + "\n\n";
    }

    public int getDifficulty() {
        return difficulty;
    }
}
