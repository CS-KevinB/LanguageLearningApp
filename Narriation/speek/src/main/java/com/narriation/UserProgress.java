package com.narriation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a class for user progress
 * 
 * @author christianruff
 */
public class UserProgress {
    private Language language;
    private int difficulty;
    private int currentStory;
    private HashMap<Phrase, Integer> phraseProgress;
    private HashMap<Word, Integer> wordProgress;

    /**
     * Creates a default user progress
     */
    public UserProgress(Language language) {
        this.language = language;
        this.difficulty = 0;
        this.currentStory = 0;
        this.phraseProgress = new HashMap<Phrase, Integer>();
        this.wordProgress = new HashMap<Word, Integer>();
    }

    /**
     * Creates a user progress with the parameters
     * 
     * @param difficulty     takes in the difficulty of the user
     * @param currentStory   takes in the current story of the user
     * @param phraseProgress takes in the phrase progress of the user
     * @param wordProgress   takes in the word progress of the user
     */
    public UserProgress(Language language, int difficulty, int currentStory, HashMap<Phrase, Integer> phraseProgress,
            HashMap<Word, Integer> wordProgress) {
        this.language = language;
        this.difficulty = difficulty;
        this.currentStory = currentStory;
        this.phraseProgress = phraseProgress;
        this.wordProgress = wordProgress;
    }

    public Language getLanguage() {
        return this.language;
    }

    /**
     * Gets the difficulty of the user
     * 
     * @return returns the difficulty
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Gets the word progress of the user
     * 
     * @param word takes in the word to get the progress for
     * @return returns the progress
     */
    public HashMap<Word, Integer> getWordProgress() {
        return wordProgress;
    }

    // public void setWordProgress(Word word) {
    // this.wordProgress.put(word, wordProgress.get(word) + 1);
    // }

    /**
     * Updates the word progress of the user
     * 
     * @param word takes in the word to update the progress for
     */
    public void updateWordProgress(Word word) {

    }

    /**
     * Gets the phrase progress of the user
     * 
     * @return returns the progress
     */
    public HashMap<Phrase, Integer> getPhraseProgress() {
        return phraseProgress;
    }

    /**
     * Counts the correct phrase of the user
     * 
     * @param phrase takes in the phrase to count the progress for
     */
    public void countCorrectPhrase(Phrase phrase) {
        int currentCount = this.phraseProgress.getOrDefault(phrase, 0);
        phraseProgress.put(phrase, currentCount + 1);

    }

    /**
     * Counts the incorrect phrase of the user
     * 
     * @param phrase takes in the phrase to count the progress for
     */
    public void countIncorrectPhrase(Phrase phrase) {
        int currentCount = this.phraseProgress.getOrDefault(phrase, 0);
        phraseProgress.put(phrase, currentCount - 1);
    }

    /**
     * Gets the current story of the user
     * 
     * @return returns the current story
     */
    public Story getCurrentStory() {
        ArrayList<Story> stories = language.getStories();
        return stories.get(currentStory);
    }

    /**
     * Gets a string representation of the user progress
     * 
     * @return returns the string
     */
    public String toString() {
        return "Language: " + this.language + " | Difficulty: " + this.difficulty + " | Current Story: "
                + this.currentStory
                + " | Phrase Progress (Language:Score)" + this.phraseProgress
                + " | " + this.wordProgress;
    }

    /**
     * Gets the words that the user is struggling with
     * 
     * @return A string of words that the user is struggling with
     */
    public String displayHardWords() {
        String hardWords = "";
        ArrayList<Word> words = this.language.getWords();
        for (Word word : words) {
            if (this.getWordProgress(word) < 1) {
                hardWords += word + " " + this.getWordProgress(word) + "\n";
            }
        }
        return hardWords;
    }

    /**
     * Gets the phrases that the user is struggling with
     * 
     * @return A string of phrases that the user is struggling with
     */
    public String displayHardPhrases() {
        String hardPhrases = "";
        ArrayList<Phrase> phrases = this.language.getPhrases();
        for (Phrase phrase : phrases) {
            if (this.getPhraseProgress(phrase) < 1) {
                hardPhrases += phrase + " " + this.getPhraseProgress(phrase) + "\n";
            }
        }
        return hardPhrases;
    }

}
