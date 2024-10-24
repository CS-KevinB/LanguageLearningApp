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
    private int difficulty;
    private int currentStory;
    private HashMap<Phrase, Integer> phraseProgress;
    private HashMap<Word, Integer> wordProgress;

    public UserProgress() {
        this.difficulty = 0;
        this.currentStory = 0;
        this.phraseProgress = new HashMap<>();
        this.wordProgress = new HashMap<>();
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getWordProgress(Word word) {
        return wordProgress.getOrDefault(word, 0);
    }

    public void setWordProgress(Word word) {
        wordProgress.put(word, wordProgress.get(word) + 1);
    }

    public void updateWordProgress(Word word) {

    }

    public int getPhraseProgress(Phrase phrase) {
        return phraseProgress.getOrDefault(phrase, 0);
    }

    public void setPhraseProgress(Phrase phrase) {
        phraseProgress.put(phrase, phraseProgress.get(phrase) + 1);
    }

    public Story getCurrentStory() {
        ArrayList<Story> stories = Facade.getInstance().getCurrentLanguage().getStories();
        return stories.get(currentStory);
    }

    public String toString() {
        return "This is " + Facade.getInstance().getCurrentUser().getFirstName() + "'s progress";
    }

}
