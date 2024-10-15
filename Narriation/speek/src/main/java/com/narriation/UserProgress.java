package com.narriation;

/**
 * Defines a class for user progress
 * 
 * @author christianruff
 */
public class UserProgress {
    private int currentLesson;
    private int currentExercise;
    private Story currentStory;

    /**
     * Constructs a new UserProgress object
     */
    public UserProgress() {
        this.currentLesson = 1;
        this.currentExercise = 1;
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
    public boolean hasNextExercise() {
        return true;
    }

    /**
     * Returns if there is a next lesson
     * 
     * @return TRUE if there is a next lesson, FALSE otherwise
     */
    public boolean hasNextLesson() {
        return true;
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
}
