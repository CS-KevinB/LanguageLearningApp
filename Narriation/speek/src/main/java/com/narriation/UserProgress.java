package com.narriation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a class for user progress
 * 
 * @author christianruff
 */
public class UserProgress {
    private HashMap<Story, Boolean> currentStory;
    private HashMap<Phrase, Integer> phraseProgress;
    private HashMap<Word, Integer> wordProgress;
    private HashMap<Phrase, Date> phraseLastSeen;

    public UserProgress() {
        this.phraseProgress = new HashMap<>();
        this.wordProgress = new HashMap<>();
        this.phraseLastSeen = new HashMap<>();
        this.currentStory = new HashMap<>();
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

    public Date getPhraseLastSeen(Phrase phrase) {
        return phraseLastSeen.getOrDefault(phrase, null);
    }

    public void setPhraseLastSeen(Phrase phrase) {
        phraseLastSeen.put(phrase, new Date());
    }

    public Story getCurrentStory() {
        for (Map.Entry<Story, Boolean> entry : currentStory.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return null; // Return null if no current story is found
    }

    public String toString() {
        return "This is " + Facade.getInstance().getCurrentUser().getFirstName() + "'s progress";
    }

}
