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

    /**
     * Constructs a new UserProgress object
     */
    public UserProgress() {
        this.phraseSeenCounter = new HashMap<Phrase, Integer>();
        this.phraseCorrectCounter = new HashMap<Phrase, Integer>();
        this.phraseLastSeen = new HashMap<Phrase, Date>();
    }

    /**
     * Constructs a new UserProgress object
     * 
     * @param currentLesson   Position of current lesson in array
     * @param currentExercise Position of current exercise in array
     *                        REDO ALL OF THIS
     */
    public UserProgress(HashMap<Story, Boolean> currentStory, HashMap<Phrase, Integer> phraseSeenCounter,
            HashMap<Phrase, Integer> phraseCorrectCounter, HashMap<Phrase, Date> phraseLastSeen) {
        this.currentStory = currentStory;
        this.phraseSeenCounter = phraseSeenCounter;
        this.phraseCorrectCounter = phraseCorrectCounter;
        this.phraseLastSeen = phraseLastSeen;
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

    public HashMap<Phrase, Integer> getPhraseSeenCounter() {
        return phraseSeenCounter;
    }

    public void setPhraseSeenCounter(HashMap<Phrase, Integer> phraseSeenCounter) {
        this.phraseSeenCounter = phraseSeenCounter;
    }

    public HashMap<Phrase, Integer> getPhraseCorrectCounter() {
        return phraseCorrectCounter;
    }

    public void setPhraseCorrectCounter(HashMap<Phrase, Integer> phraseCorrectCounter) {
        this.phraseCorrectCounter = phraseCorrectCounter;
    }

    public HashMap<Phrase, Date> getPhraseLastSeen() {
        return phraseLastSeen;
    }

    public void setPhraseLastSeen(HashMap<Phrase, Date> phraseLastSeen) {
        this.phraseLastSeen = phraseLastSeen;
    }

    public void incrementPhraseSeenCounter(Phrase phrase) {
        // Initialize counter
        phraseSeenCounter.putIfAbsent(phrase, 0);
        // Increment counter
        phraseSeenCounter.put(phrase, phraseSeenCounter.get(phrase) + 1);
        // Update last seen date
        phraseLastSeen.put(phrase, new Date());
    }

}
