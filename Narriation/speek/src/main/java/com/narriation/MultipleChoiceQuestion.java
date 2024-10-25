package com.narriation;

/**
 * @author Kevin Buie
 * Creates a Multiple Choice Question for the user
 */
import java.util.ArrayList;

public class MultipleChoiceQuestion implements Question {

    private final int NUMBER_OF_CHOICES = 4;
    private Language language; // reference for pulling similar questions, pass "current language"
    private Phrase phrase;
    private Word correctAnswer;

    /**
     * Creates a multiple choice question
     * 
     * @param words         gives an array list of word options for the multiple
     *                      choice answers
     * @param correctAnswer assigns the correct answer for the problem
     * @param id            assigns the specific question an id so it can be reused
     */
    public MultipleChoiceQuestion(Phrase phrase, Language language) {
        this.phrase = phrase;
        this.language = language;
        generateRandomQuestion();
    }

    /**
     * takes what the correct answer is and returns the translated word for the
     * question
     * 
     * @return returns the question
     *         MAY NEED TO BE EDITED LATER
     */
    public String getQuestion() {
        return correctAnswer.getTranslatedWord();
    }

    public void generateRandomQuestion() {
        // set the question and answer strings

        // lastly, randomize

    }

    /**
     * Returns the correct answer
     * 
     * @return returns the correct answer
     */
    public String getAnswer() {
        return correctAnswer.toString();
    }

    /**
     * Checks to see if the answer is correct
     * 
     * @param answer requires the user answer in order to compare it to the actual
     *               answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String answer) {
        return getAnswer().equals(answer);
    }
}