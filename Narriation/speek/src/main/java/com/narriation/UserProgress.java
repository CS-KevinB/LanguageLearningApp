package com.narriation;
import java.util.Date;
import java.util.HashMap;
/**
 * Defines a class for user progress
 * 
 * @author christianruff
 */
public class UserProgress {
    private int currentLesson;
    private int currentExercise;
    private Story currentStory;
    private HashMap<Phrase, Integer> phraseSeenCounter;
    private HashMap<Phrase, Integer> phraseCorrectCounter;
    private HashMap<Phrase, Date> phraseLastSeen;



    /**
     * Constructs a new UserProgress object
     */
    public UserProgress() {
        this.currentLesson = 1;
        this.currentExercise = 1;
        this.phraseSeenCounter = new HashMap<Phrase, Integer>();
        this.phraseCorrectCounter = new HashMap<Phrase, Integer>();
        this.phraseLastSeen = new HashMap<Phrase, Date>();
    }

    /**
     * Constructs a new UserProgress object
     * 
     * @param currentLesson   Position of current lesson in array
     * @param currentExercise Position of current exercise in array
     */
    public UserProgress(int currentLesson, int currentExercise) {
        this.currentLesson = Math.max(currentLesson, 1);
        this.currentExercise = Math.max(currentExercise, 1);
    }

    /**
     * Returns if there is a next exercise
     * 
     * @return TRUE if there is a next exercise, FALSE otherwise
     */
    public boolean hasNextExercise(Lesson lessons) {
        return currentExercise < lessons.getExercises().size();
    }

    /**
     * Returns if there is a next lesson
     * 
     * @return TRUE if there is a next lesson, FALSE otherwise
     */
    public boolean hasNextLesson(Language language) {
        return currentLesson < language.getLessons().size();
    }

    /**
     * Returns the next lesson
     * 
     * @return The next lesson
     */
    public void nextLesson() {
        if (hasNextLesson()) {
            currentLesson++;
            currentExercise = 1;
        } else {
            System.out.println("Lesson completed!");
        }
    }

    /**
     * Returns the next exercise
     * 
     * @return The next exercise
     */
    public void nextExercise() {
        if (hasNextExercise()) {
            currentExercise++;
        } else if (hasNextLesson()) {
            currentLesson++;
            currentExercise = 1;
        } else {
            System.out.println("Exercise completed");
        }
    }

    public String getProgress() {
        return "Lesson: " + currentLesson + " | Exercise: " + currentExercise;

    }

    public int getCurrentLesson() {
        return currentLesson;
    }

    public int getCurrentExercise() {
        return currentExercise;
    }

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

    

}
