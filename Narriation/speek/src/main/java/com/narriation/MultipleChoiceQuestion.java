package com.narriation;
/**
 * @author Kevin Buie
 * Creates a Multiple Choice Question for the user
 */
import java.util.ArrayList;
import java.util.UUID;
public class MultipleChoiceQuestion implements Question{
    

    private ArrayList<Word> words;
    private Word correctAnswer;
    private UUID id;

    /**
     * Creates a multiple choice question
     * @param words gives an array list of word options for the multiple choice answers
     * @param correctAnswer assigns the correct answer for the problem
     * @param id assigns the specific question an id so it can be reused
     */
    public MultipleChoiceQuestion(ArrayList<Word> words, Word correctAnswer, UUID id){
        this.words = words;
        this.correctAnswer = correctAnswer;
        this.id = id;
    }

    /**
     * takes what the correct answer is and returns the translated word for the question
     * @return returns the question
     * MAY NEED TO BE EDITED LATER
     */
    public String getQuestion(){
        return correctAnswer.getTranslatedWord();
    }

    /**
     * Returns the correct answer
     * @return returns the correct answer
     */
    public String getAnswer(){
        return correctAnswer.toString();
    }

    /**
     * Checks to see if the answer is correct
     * @param answer requires the user answer in order to compare it to the actual answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String answer){
        return getAnswer().equals(answer);
    }
}
