package com.narriation;
/**
 * @author Kevin Buie
 * Creates a Matching Question for the user
 */
import java.util.UUID;
import java.util.ArrayList;
public class MultipleChoice implements Question{
    
    private ArrayList<Word> words;
    private Word correctAnswer;
    private UUID id;

    public MultipleChoice(ArrayList<Word> words, Word correctAnswer, UUID id){
        this.words = words;
        this.correctAnswer = correctAnswer;
        this.id = id;
    }

    public String getQuestion(){
        return null;
    }

    public String getAnswer(){
        return null;
    }

    public boolean isCorrect(String answer){
        return false;
    }
}
