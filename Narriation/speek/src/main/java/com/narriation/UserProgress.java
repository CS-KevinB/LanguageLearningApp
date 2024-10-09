package com.narriation;
/**
 * Defines a class for user progress
 * @author christianruff
 */
public class UserProgress {
    private int currentLesson;
    private int currentExercise;

    /**
     * Constructs a new UserProgress object
     */
    public UserProgress() {
        this.currentLesson = 1;
        this.currentExercise = 1;
    }
    
    /**
     * Constructs a new UserProgress object
     * @param currentLesson Position of current lesson in array
     * @param currentExercise Position of current exercise in array
     */
    public UserProgress(int currentLesson, int currentExercise) {
        if (currentLesson > 0)
            this.currentLesson = currentLesson;
        else
            this.currentLesson = 1;
        if (currentExercise > 0)
            this.currentExercise = currentExercise;
        else
            this.currentExercise = 1;
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

    @Override
    public String toString() {
        return "Lesson = " + this.currentLesson + " | Exercise = " + this.currentExercise;
    }
}
