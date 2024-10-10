package com.narriation;
/**
 * @author Kevin Buie
 * Creates a Multiple Choice Question for the user
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
        return correctAnswer.getTranslatedWord();
    }

    public String getAnswer(){
        return correctAnswer.toString();
    }

    public boolean isCorrect(String answer){
        return getAnswer().equals(answer);
    }
}
