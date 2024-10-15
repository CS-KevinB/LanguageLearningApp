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
    public String getQuestion(){
        return String.join(" ", phrase.getEnglishPhrase());
    }

    /**
     * joins the answer phrase together and separates the words with spaces
     * @return returns the answer
     */
    public String getAnswer(){
        return String.join(" ", phrase.getTranslatedPhrase());
    }

    /**
     * Checks to see if the user answer is correct
     * @param answer requires the user answer in order to compare it to the actual answer
     * @return returns a boolean if the answer is correct or not
     */
    public boolean isCorrect(String answer){
        return String.join(" ", phrase.getTranslatedPhrase()).equalsIgnoreCase(answer);
    }
}
