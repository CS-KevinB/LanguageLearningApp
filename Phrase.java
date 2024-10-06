import java.util.*;
/**
 * The phrase class contains lists of words for each phrase
 * and feedback
 * @author Risha Patel;
 */

public class Phrase {
    private ArrayList<Word> phrase;
    private String feedback;
    private ArrayList<Word> englishPhrase;
    private ArrayList<Word> translatedPhrase;

    public Phrase(Phrase transletPhrase, String feedback){

        this.phrase = new ArrayList<>();
        this.feedback = feedback;
        this.englishPhrase = null;
        this.translatedPhrase = null;
    }

    public ArrayList<String> getEnglishPhrase(){
        return null;
    }

    public ArrayList<String> getTranslatedPhrase(){
        return null;
    }

    public String getFeedback() {
        return feedback;
    }
}
