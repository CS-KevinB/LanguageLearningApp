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
    private ArrayList<Question> questions;

    public Lesson(ArrayList<Exercise> exercises, ArrayList<Story> stories) {
        this.questions = new ArrayList<Question>();
    }

    public void populateWithQuestions(int numOfQuestions) {
        ArrayList<Phrase> allPhrases = Facade.getInstance().getLanguage().getPhrases();
        ArrayList<Phrase> lessonPhrases = new ArrayList<Phrase>();
        int userDifficulty = Facade.getInstance().getCurrentUser().getUserProgress().getDifficulty();

        // 1.
        int pointer = 0;
        for (int i = 0; i < allPhrases.size() && lessonPhrases.size() < NUMBER_OF_QUESTIONS; i++) {
            Phrase phrase = allPhrases.get(i);
            if (phrase.getDifficulty() == userDifficulty)
                lessonPhrases.add(phrase);
        }

        // 2. loop through the questions

    }

    // TODO test start lesson
    public void startLesson() {
        boolean quit = false;
        while (!quit) {
            ArrayList<Phrase> allPhrases = Facade.getInstance().getLanguage().getPhrases();
            ArrayList<Phrase> lessonPhrases = new ArrayList<Phrase>();
            int userDifficulty = Facade.getInstance().getCurrentUser().getUserProgress().getDifficulty();
            int pointer = 0;

            // 1. pull a list of (NUMBER_OF_QUESTIONS) phrases that are within the users
            // difficulty
            while (lessonPhrases.size() < NUMBER_OF_QUESTIONS && pointer < allPhrases.size()) {
                Phrase phrase = allPhrases.get(pointer);
                if (phrase.getDifficulty() == userDifficulty
                        && Facade.getInstance().getCurrentUser().getUserProgress().getPhraseProgress(phrase) < 2) {
                    lessonPhrases.add(phrase);
                }
            }

            // 2. generate (NUMBER_OF_QUESTIONS) questions

            System.out.println(lessonPhrases);
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
