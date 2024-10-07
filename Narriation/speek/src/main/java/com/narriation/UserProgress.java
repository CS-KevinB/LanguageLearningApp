package com.narriation;
/**
 * Defines a class for user progress
 * @author christianruff
 */
public class UserProgress {
    private Lesson currentLesson;
    private Exercise currentExercise;

    /**
     * Constructs a new UserProgress object
     */
    public UserProgress() {
        this.currentLesson = null;
        this.currentExercise = null;
    }
    
    /**
     * Returns if there is a next exercise
     * @return TRUE if there is a next exercise, FALSE otherwise
     */
    public boolean hasNextExercises() {
        return true;
    }

    /**
     * Returns if there is a next lesson
     * @return TRUE if there is a next lesson, FALSE otherwise
     */
    public boolean hasNextLesson() {
        return true;
    }

    /**
     * Returns the next lesson
     * @return The next lesson
     */
    public Lesson nextLesson() {
        return null;
    }

    /**
     * Returns the next exercise
     * @return The next exercise
     */
    public Exercise nextExercise() {
        return null;
    }
}
