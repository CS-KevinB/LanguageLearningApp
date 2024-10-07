package com.narriation;
/**
 * @author Kevin Buie
 * Creates a Matching Question for the user
 */
import java.util.UUID;
import java.util.ArrayList;
public class MatchingQuestion implements Question{
    
    private ArrayList<Word> words;
    private UUID id;

    public MatchingQuestion(ArrayList<Word> words, UUID id){
        this.words = words;
        this.id = id;
    }

    public String getQuestion(){
        return null;
    }

    public String getAnswer(){
        return null;
    }

    public boolean isCorrect(ArrayList<Word> words){
        return false;
    }
}
