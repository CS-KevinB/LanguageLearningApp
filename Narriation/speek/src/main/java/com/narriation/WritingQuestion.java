package com.narriation;
/**
 * @author Kevin Buie
 * Creates a writing question for the user
 */
import java.util.UUID;
public class WritingQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    /**
     * Creates a default Writing Question with the parameters
     * @param phrase needs a phrase for the question
     * @param id needs the id to pull the stored question
     */
    public WritingQuestion(Phrase phrase, UUID id){
        this.phrase = phrase;
        this.id = id;
    }
    
    /**
     * joins the english phrases together and separates them by spaces
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
}
