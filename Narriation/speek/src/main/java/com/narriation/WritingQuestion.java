package com.narriation;

import java.util.Random;
import java.util.UUID;

/**
 * @author Kevin Buie
 *         Creates a writing question for the user
 */
public class WritingQuestion implements Question {
    private Phrase phrase;
    private String questionString;
    private String answerString;

    // temporary main
    public static void main(String[] args) {
        UUID id = UUID.fromString("3085ad7f-139c-4d3e-85e6-52cc0d028a29");
        Phrase phrase = Facade.getInstance().getLanguages().getLanguageByUUID(id).getPhrases().get(2);
        WritingQuestion writingQ = new WritingQuestion(phrase);
        System.out.println(writingQ);
        System.out.println(writingQ.isCorrect("leche"));
    }

    /**
     * Creates a default Writing Question with the parameters
     * 
     * @param phrase needs a phrase for the question
     * @param id     needs the id to pull the stored question
     */
    public WritingQuestion(Phrase phrase) {
        this.phrase = phrase;
        this.generateRandomQuestion();
    }

    public void generateRandomQuestion() {
        Random r = new Random();

        // english phrase
        int phraseLength = phrase.getEnglishPhrase().size();
        StringBuilder englishStr = new StringBuilder();
        int pointer = 0;

        while (pointer < phraseLength) {
            if (englishStr.length() > 0) {
                englishStr.append(" ");
            }
            englishStr.append(this.phrase.getEnglishPhrase().get(pointer).getEnglishWord());
            pointer++;
        }

        // translated phrase
        phraseLength = phrase.getTranslatedPhrase().size();
        int answerIndex = r.nextInt(phraseLength);

        StringBuilder translatedStr = new StringBuilder();
        pointer = 0;

        while (pointer < phraseLength) {
            if (translatedStr.length() > 0) {
                translatedStr.append(" ");
            }
            if (pointer == answerIndex) {
                translatedStr.append("__________");
            } else {
                translatedStr.append(this.phrase.getTranslatedPhrase().get(pointer).getTranslatedWord());
            }
            pointer++;
        }

        this.questionString = englishStr.toString() + " = " + translatedStr.toString();
        this.answerString = this.phrase.getTranslatedPhrase().get(answerIndex).getTranslatedWord();
    }

    /**
     * joins the english phrases together and separates them by spaces
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
     * joins the answer phrase together and separates the words with spaces
     *
     * @return returns the answer
     */
    public String getAnswer() {
        return answerString;
    }

    /**
     * Checks to see if the user answer is correct
     * 
     * @param answer requires the user answer in order to compare it to the actual
     *               answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String input) {
        return input.equals(answerString);
    }

    public String toString() {
        return "Question: " + this.questionString + " | Answer: " + this.answerString;
    }
}
