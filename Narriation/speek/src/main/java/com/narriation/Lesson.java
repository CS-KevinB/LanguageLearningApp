package com.narriation;

import java.util.ArrayList;
import java.util.UUID;

import software.amazon.awssdk.services.polly.endpoints.internal.Value.Array;

/**
 * The Lesson class represents a lesson containing exercises and stories.
 * 
 * @author Risha Patel
 */
public class Lesson {
    public final int NUMBER_OF_QUESTIONS = 5;
    private UUID id;
    private ArrayList<Exercise> exercises;
    private ArrayList<Story> stories;

    public Lesson(ArrayList<Exercise> exercises, ArrayList<Story> stories) {
        this.id = UUID.randomUUID();
        this.exercises = exercises;
        this.stories = stories;
    }

    public void startLesson() {
        boolean quit = false;
        while (!quit) {
            ArrayList<Phrase> allPhrases = Facade.getInstance().getLanguage().getPhrases();
            ArrayList<Phrase> thisPhrases = new ArrayList<>();

            for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
                Phrase phrase = allPhrases.get(i);
            }

            System.out.println(allPhrases);
        }

        // 1. pull phrases that the user has not already seen from Language.getPhrases

        // 2. iterate through the phrases, and generate question objects from those
        // phrases

        // 3. display those questions in the UI one at a time, and allow the user to
        // input their answer
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public ArrayList<Story> getStory() {
        return stories;
    }

}
