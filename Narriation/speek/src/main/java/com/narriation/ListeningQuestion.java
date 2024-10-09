package com.narriation;
import java.util.ArrayList;
/**
 * @author Kevin Buie
 * Creates a Listening Question for the user
 */
import java.util.UUID;
public class ListeningQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    public static void main(String[] args) {
        ArrayList<Word> englishPhrase = new ArrayList<>();
        englishPhrase.add(new Word("Hello", "Hola", "O-la", null, null));
        ArrayList<Word> translatedPhrase = new ArrayList<>();
        translatedPhrase.add(new Word("Hello", "Hola", "O-la", null, null));
        Phrase phrase = new Phrase("Goodbye", englishPhrase, translatedPhrase);
        ListeningQuestion question = new ListeningQuestion(phrase, null);
        question.playAudio();

    }

    /**
     * Creates a public listening question for the user
     * @param phrase needs a phrase in order to set up the question
     * @param id needs the stored id in order to pull the specific stored variables
     */
    public ListeningQuestion(Phrase phrase, UUID id){
        this.phrase = phrase;
        this.id = id;
    }

    /**
     * Gets the question and joins the words together separated by spaces to make a sentence
     * @return returns the new question to the user to be answered
     */
    public String getQuestion() {
        StringBuilder questionBuilder = new StringBuilder();
        
        for (Word word : phrase.getEnglishPhrase()) {
            if (questionBuilder.length() > 0) {
                questionBuilder.append(" ");  // Add a space between words
            }
            questionBuilder.append(word.getTranslatedWord());  // Use toString() to get the word's string representation
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
                answerBuilder.append(" ");  // Add a space between words
            }
            answerBuilder.append(word.toString());  // Use toString() to get the word's string representation
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
    
    
    
    public  void playAudio(){
        System.out.println(getQuestion());
        Narriator.playSound(getQuestion());
    }
}
