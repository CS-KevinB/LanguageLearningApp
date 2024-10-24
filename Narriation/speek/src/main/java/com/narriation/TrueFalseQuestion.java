package com.narriation;
public class TrueFalseQuestion implements Question {
    
    private Word word;
    
    public TrueFalseQuestion(Word word){
        this.word = word;
    }
    
    public String getQuestion() {
        
    }
    
    public String getAnswer() {
        
    }

    public boolean isCorrect(String answer) {
        return getAnswer().equals(answer);
    }

}
