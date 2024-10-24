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
    public static final int NUMBER_OF_QUESTIONS = 5;
    private UserProgress userProgress;
    private ArrayList<Question> questions;
    private int score;

    public Lesson(UserProgress userProgress) {
        this.score = 0;
        this.questions = generateQuestions(userProgress, NUMBER_OF_QUESTIONS);
    }

    public static ArrayList<Question> generateQuestions(UserProgress userProgress, int numOfQuestions) {
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

        return selectedQuestions;
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public String getScore() {
        return score + " / " + NUMBER_OF_QUESTIONS;
    }
}
