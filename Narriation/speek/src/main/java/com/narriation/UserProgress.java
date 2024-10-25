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
        this.phraseProgress = new HashMap<Phrase, Integer>();
        this.wordProgress = new HashMap<Word, Integer>();
    }

    public UserProgress(int difficulty, int currentStory, HashMap<Phrase, Integer> phraseProgress,
            HashMap<Word, Integer> wordProgress) {
        this.difficulty = difficulty;
        this.currentStory = currentStory;
        this.phraseProgress = phraseProgress;
        this.wordProgress = wordProgress;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getWordProgress(Word word) {
        return this.wordProgress.getOrDefault(word, 0);
    }

    // public void setWordProgress(Word word) {
    // this.wordProgress.put(word, wordProgress.get(word) + 1);
    // }

    public void updateWordProgress(Word word) {

    }

    public int getPhraseProgress(Phrase phrase) {
        return phraseProgress.getOrDefault(phrase, 0);
    }

    public void countCorrectPhrase(Phrase phrase) {
        int currentCount = this.phraseProgress.getOrDefault(phrase, 0);
        phraseProgress.put(phrase, currentCount + 1);

    }

    public void countIncorrectPhrase(Phrase phrase) {
        int currentCount = this.phraseProgress.getOrDefault(phrase, 0);
        phraseProgress.put(phrase, currentCount - 1);
    }

    public Story getCurrentStory() {
        ArrayList<Story> stories = Facade.getInstance().getCurrentLanguage().getStories();
        return stories.get(currentStory);
    }

    public String toString() {
        return "Difficulty: " + this.difficulty + " | Current Story: " + this.currentStory + " | " + this.phraseProgress
                + " | " + this.wordProgress;
    }

}
