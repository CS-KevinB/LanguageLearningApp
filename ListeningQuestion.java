/**
 * @author Kevin Buie
 * Creates a Listening Question for the user
 */
import java.util.UUID;
public class ListeningQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    public ListeningQuestion(Phrase phrase, UUID id){
        this.phrase = phrase;
        this.id = id;
    }

    public String getQuestion(){
        return String.join(" ", phrase.getEnglishPhrase());
    }

    public String getAnswer(){
        return String.join(" ", phrase.getTranslatedPhrase());
    }

    public boolean isCorrect(String answer){
        return String.join(" ", phrase.getTranslatedPhrase()).equalsIgnoreCase(answer);
    }
    
    public void playAudio(){
        
    }
}
