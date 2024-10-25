package com.narriation;

import java.util.Random;
import java.util.UUID;
import java.util.ArrayList;

/**
 * @author Kevin Buie
 *         Creates a true or false type of question
 */
public class TrueFalseQuestion implements Question {

    private Phrase phrase;
    private String questionStr;
    private boolean answer;

    public static void main(String[] args) {
        UUID id = UUID.fromString("3085ad7f-139c-4d3e-85e6-52cc0d028a29");
        Language currLanguage = Facade.getInstance().getLanguages().getLanguageByUUID(id);
        Facade.getInstance().setCurrentLangauge(currLanguage);

        Phrase phrase = currLanguage.getPhrases().get(2);
        TrueFalseQuestion tfQuestion = new TrueFalseQuestion(phrase);
        System.out.println(tfQuestion.getQuestion());
        String userInput = "true";
        System.out.println(
                "If the user writes \"" + userInput + "\", the answer would be " + tfQuestion.isCorrect(userInput));
    }

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
        return this.questionStr;
    }

    public void generateRandomQuestion() {
        Random r = new Random();
        boolean ansBool = r.nextBoolean();

        // build the question string

        String question = this.convertPhraseToString(this.phrase, false);
        String answer = "";

        // if we should display a TRUE question,
        if (ansBool) {
            answer = this.convertPhraseToString(this.phrase, true);
        } else {
            ArrayList<Phrase> phrases = Facade.getInstance().getCurrentLanguage().getPhrases(); // TODO
            int index = r.nextInt(phrases.size());

            System.out.println(ansBool); // TEST make sure this doesn't mess up our answer

            Phrase randPhrase;
            do {
                randPhrase = phrases.get(index);
            } while (randPhrase == this.phrase);
            answer = this.convertPhraseToString(randPhrase, true);
        }
        this.questionStr = question + " = " + answer + "?";

        // set answer
        this.answer = ansBool;
    }

    private String convertPhraseToString(Phrase phrase, boolean isEnglish) {
        ArrayList<Word> phraseArr;
        StringBuilder str = new StringBuilder();
        if (isEnglish) {
            phraseArr = phrase.getEnglishPhrase();
            int len = phraseArr.size();

            for (int i = 0; i < len; i++) {
                if (str.length() > 0)
                    str.append(" ");
                str.append(phraseArr.get(i).getEnglishWord());
            }
        } else {
            phraseArr = phrase.getTranslatedPhrase();
            int len = phraseArr.size();

            for (int i = 0; i < len; i++) {
                if (str.length() > 0)
                    str.append(" ");
                str.append(phraseArr.get(i).getTranslatedWord());
            }
        }
        return str.toString();
    }

    /**
     * @return returns the answer to be checked
     */
    public String getAnswer() {
        if (this.answer)
            return "true";
        else
            return "false";
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
