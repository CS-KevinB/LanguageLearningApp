/**
 * @author Kevin Buie
 * Creates a Listening Question for the user
 */
import java.util.UUID;
public class ListeningQuestion implements Question{
    private Phrase phrase;
    private UUID id;

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
    
    public void playAudio(){

    }
}
