package com.narriation;

import java.util.ArrayList;

import software.amazon.awssdk.services.polly.endpoints.internal.Value.Str;

/**
 * The phrase class contains lists of words for each phrase
 * and feedback
 * 
 * @author Risha Patel;
 */

public class Phrase {
    private String feedback;
    private ArrayList<Word> englishPhrase;
    private ArrayList<Word> translatedPhrase;

    /**
     * Constructor for phrase class
     * 
     * @param phrase           - list of words for the phrase
     * @param feedback         - feedback for the phrase
     * @param englishPhrase    - list of words for the english phrase
     * @param translatedPhrase - list of words for the translated phrase
     */

    public Phrase(String feedback, ArrayList<Word> englishPhrase, ArrayList<Word> translatedPhrase) {

        this.feedback = feedback;
        this.englishPhrase = englishPhrase;
        this.translatedPhrase = translatedPhrase;
    }

    /**
     * Getter method for english phrase
     * 
     * @return - list of words for the english phrase
     */
    public ArrayList<String> getEnglishPhrase() {
        return null;
    }

    /**
     * Getter method for translated phrase
     * 
     * @return - list of words for the translated phrase
     */
    public ArrayList<String> getTranslatedPhrase() {
        return null;
    }

    /**
     * Gets the Feedback
     * 
     * @return feedback
     */
    public String getFeedback() {
        return feedback;
    }
}
