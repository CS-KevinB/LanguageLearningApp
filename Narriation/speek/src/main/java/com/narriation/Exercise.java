package com.narriation;
/**
 * @author Kevin Buie
 * Creates the exercise class and has an
 * array list of questions
 */

import java.util.ArrayList;

public class Exercise {
    private ArrayList<Question> questions;

    /**
     * Creates a exercise based on if exercise is empty
     * @param exercise needs exercise in order to check if there is an array list of question or not
     * @param question takes in a question
     * CHECK THIS
     */
    public Exercise(Exercise exercise, Question question){
        if(exercise != null){
            this.questions = new ArrayList<>(exercise.getQuestion());
        } else {
            this.questions = new ArrayList<>();
        }
    }

    /**
     * Gets the array list of questions for the user
     * @return returns this array list in order to create an exercise
     */
    public ArrayList<Question> getQuestions(){
        return questions;
    }
}
