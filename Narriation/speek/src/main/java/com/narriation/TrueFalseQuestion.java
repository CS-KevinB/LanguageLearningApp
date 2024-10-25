package com.narriation;

import java.util.Random;

/**
 * @author Kevin Buie
 *         Creates a true or false type of question
 */
public class TrueFalseQuestion implements Question {

    private Phrase phrase;

    /**
     * Creates a default true or false question
     * 
     * @param phrase
     */
    public TrueFalseQuestion(Phrase phrase) {
        this.phrase = phrase;
        this.generateRandomQuestion();
    }

    /**
     * Takes the word and returns it as a question to the user
     * 
     * @return returns the question
     */
    public String getQuestion() {

    }

    public void generateRandomQuestion() {
        Random r = new Random();
        boolean answer = r.nextBoolean();

        StringBuilder question = new StringBuilder();

        // if we should display a TRUE question,
        if (answer) {

        }

        // if we should display a FALSE question
    }

    /**
     * @return returns the answer to be checked
     */
    public String getAnswer() {

    }

    /**
     * takes the true or false answer inserted by the user and checks to see if it
     * is correct
     * 
     * @param answer requires the user answer in order to compare it to the actual
     *               answer
     * @return returns a boolean if the answer is correct
     */
    public boolean isCorrect(String answer) {
        return getAnswer().equals(answer);
    }

}
