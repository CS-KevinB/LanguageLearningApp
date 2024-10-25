package com.narriation;

import java.util.ArrayList;

/**
 * @author Kevin Buie
 *         Creates a Listening Question for the user
 */
public class ListeningQuestion implements Question {
    private Phrase phrase;
    private String question;

    /**
     * Creates a public listening question for the user
     * 
     * @param phrase needs a phrase in order to set up the question
     * @param id     needs the stored id in order to pull the specific stored
     *               variables
     */
    public ListeningQuestion(Phrase phrase) {
        this.phrase = phrase;
    }

    public void generateQuestion() {

    }

    /**
     * Gets the question and joins the words together separated by spaces to make a
     * sentence
     * 
     * @return returns the new question to the user to be answered
     */
    public String getQuestion() {
        StringBuilder questionBuilder = new StringBuilder();

        for (Word word : phrase.getEnglishPhrase()) {
            if (questionBuilder.length() > 0) {
                questionBuilder.append(" ");
            }
            questionBuilder.append(word.getTranslatedWord());
        }

        return questionBuilder.toString();
    }

    /**
     * Joins the answer phrase together and separates the words with spaces
     * 
     * @return returns the answer
     */
    public String getAnswer() {
        StringBuilder answerBuilder = new StringBuilder();

        for (Word word : phrase.getTranslatedPhrase()) {
            if (answerBuilder.length() > 0) {
                answerBuilder.append(" ");
            }
            answerBuilder.append(word.toString());
        }

        return answerBuilder.toString();
    }

    /**
     * Checks to see if the user answer is correct
     * 
     * @param answer requires the user answer in order to compare it to the actual
     *               answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String answer) {
        boolean ret = getAnswer().equals(answer);
        if (ret)
            Facade.getInstance().getCurrentUser().getUserProgress().countCorrectPhrase(this.phrase);
        else
            Facade.getInstance().getCurrentUser().getUserProgress().countIncorrectPhrase(this.phrase);
        return ret;
    }

    /**
     * Plays the audio for the listening question
     */
    public void playAudio() {
        Narriator.playSound(getQuestion());
    }
}
