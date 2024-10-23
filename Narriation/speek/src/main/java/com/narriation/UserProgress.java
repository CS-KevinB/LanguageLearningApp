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
    private HashMap<Phrase, Integer> phraseSeenCounter;
    private HashMap<Phrase, Integer> phraseCorrectCounter;
    private HashMap<Phrase, Date> phraseLastSeen;

    public UserProgress() {
        this.phraseSeenCounter = new HashMap<>();
        this.phraseCorrectCounter = new HashMap<>();
        this.phraseLastSeen = new HashMap<>();
        this.currentStory = new HashMap<>();
    }

    public int getPhraseSeenCount(Phrase phrase) {
        return phraseSeenCounter.getOrDefault(phrase, 0);
    }

    public void setPhraseSeenCounter(HashMap<Phrase, Integer> phraseSeenCounter) {
        this.phraseSeenCounter = phraseSeenCounter;
    }

    public int getPhraseCorrectCounter(Phrase phrase) {
        return phraseCorrectCounter.getOrDefault(phrase, 0);
    }

    public void setPhraseCorrectCounter(HashMap<Phrase, Integer> phraseCorrectCounter) {
        this.phraseCorrectCounter = phraseCorrectCounter;
    }

    public Date getPhraseLastSeen(Phrase phrase) {
        return phraseLastSeen.get(phrase);
    }

    public void setPhraseLastSeen(Phrase phrase) {
        phraseLastSeen.put(phrase, new Date());
    }

    public void incrementPhraseSeenCounter(Phrase phrase) {
        // Initialize counter
        phraseSeenCounter.putIfAbsent(phrase, 0);
        // Increment counter
        phraseSeenCounter.put(phrase, phraseSeenCounter.get(phrase) + 1);
        // Update last seen date
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
