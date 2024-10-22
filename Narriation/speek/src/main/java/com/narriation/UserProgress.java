package com.narriation;
import java.util.Date;
import java.util.HashMap;
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
     * REDO ALL OF THIS
     */
    public UserProgress(int currentLesson, int currentExercise) {
        // TODO:
    }

    public String getProgress() {
        // TODO: 

    }

    //EDIT THIS
    public Story getCurrentStory() {
        return currentStory;
    }

    @Override
    public String toString() {
        return getProgress();
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
        this.phraseSeenCounter.put(phrase, this.phraseSeenCounter.get(phrase) + 1);
    }


    

    

}
