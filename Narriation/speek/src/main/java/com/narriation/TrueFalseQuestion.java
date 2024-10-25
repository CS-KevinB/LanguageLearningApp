package com.narriation;

import java.util.Random;
import java.util.UUID;
import java.util.ArrayList;

/**
 * @author Kevin Buie
 *         Creates a true or false type of question
 */
public class TrueFalseQuestion implements Question {

    private Language language; // reference for pulling similar questions, pass "current language"
    private Phrase phrase;
    private String englishStr;
    private String translatedStr;
    private boolean isMatch;

    /**
     * Creates a default true or false question
     * 
     * @param phrase
     */
    public TrueFalseQuestion(Phrase phrase, Language currentLanguage) {
        this.phrase = phrase;
        this.language = currentLanguage;
        this.generateQuestion();
    }

    public String getQuestion() {
        return englishStr + " = " + translatedStr + "?";
    }

    /**
     * Takes the word and returns it as a question to the user
     * 
     * @return returns the question
     */
    public String getEnglishStr() {
        return this.englishStr;
    }

    public String getTranslatedStr() {
        return this.translatedStr;
    }

    public void generateQuestion() {
        Random r = new Random();
        boolean ansBool = r.nextBoolean();

        // build the question string

        String question = this.convertPhraseToString(this.phrase, false);
        String isMatch = "";

        // if we should display a TRUE question,
        if (ansBool) {
            isMatch = this.convertPhraseToString(this.phrase, true);
        } else {
            ArrayList<Phrase> phrases = language.getPhrases();
            int index = r.nextInt(phrases.size());

            System.out.println(ansBool); // TEST make sure this doesn't mess up our answer

            Phrase randPhrase;
            do {
                randPhrase = phrases.get(index);
            } while (randPhrase == this.phrase);
            isMatch = this.convertPhraseToString(randPhrase, true);
        }
        this.englishStr = question + " = " + isMatch + "?";

        // set answer
        this.isMatch = ansBool;
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
        if (this.isMatch)
            return "true";
        else
            return "false";
    }

    /**
     * takes the true or false answer inserted by the user and checks to see if it
     * is correct
     * 
     * @param input requires the user answer in order to compare it to the actual
     *              answer
     * @return returns a boolean if the answer is correct
     */
    public boolean isCorrect(String input) {
        return getAnswer().equals(input);
    }

    /**
     * Gets the phrase that the question is based on
     * @return Returns the phrase
     */
    public Phrase getPhrase() {
        return this.phrase;
    }
}
