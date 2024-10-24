package com.narriation;
import java.util.UUID;

/**
 * @author Kevin Buie
 * Creates a class that will be used to create questions for the user
 */
public class Question {
    private Phrase phrase;
    private UUID id;
    public Question(Phrase phrase, UUID id){
        this.phrase = phrase;
        this.id = id;
    }
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
     * @param answer requires the user answer in order to compare it to the actual answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String answer) {
        return getAnswer().equals(answer);
    }
    
    
    /**
     * translates the question and plays the audio
     */
    public void playAudio(){
        Narriator.playSound(getQuestion());
    }
}
