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
        ArrayList<Phrase> selectedPhrases = new ArrayList<Phrase>();
        int userDifficulty = Facade.getInstance().getCurrentUser().getUserProgress().getDifficulty();

        // 1. pull a list of (NUMBER_OF_QUESTIONS) phrases that are within the user's
        // difficulty
        for (int i = 0; i < allPhrases.size() && selectedPhrases.size() < NUMBER_OF_QUESTIONS; i++) {
            Phrase phrase = allPhrases.get(i);
            if (phrase.getDifficulty() == userDifficulty)
                selectedPhrases.add(phrase);
        }

        // 2. generate all four question types
        ArrayList<Question> selectedQuestions = new ArrayList<Question>();
        for (int j = 0; j < selectedPhrases.size(); j++) {
            switch (j % 4) {
                case 0:
                    selectedQuestions.add(new MultipleChoiceQuestion(selectedPhrases.get(j)));
                    break;
                case 1:
                    selectedQuestions.add(new ListeningQuestion(selectedPhrases.get(j)));
                    break;
                case 2:
                    selectedQuestions.add(new TrueFalseQuestion(selectedPhrases.get(j)));
                    break;
                case 3:
                    selectedQuestions.add(new WritingQuestion(selectedPhrases.get(j)));
            }
        }

        // 3. move the questions to the lesson instance variable
        this.questions = selectedQuestions;
    }

    // TODO test start lesson
    public void startLesson() {
        boolean quit = false;
        while (!quit) {
            ArrayList<Phrase> allPhrases = Facade.getInstance().getLanguage().getPhrases();
            ArrayList<Phrase> lessonPhrases = new ArrayList<Phrase>();
            int userDifficulty = Facade.getInstance().getCurrentUser().getUserProgress().getDifficulty();
            int pointer = 0;

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
