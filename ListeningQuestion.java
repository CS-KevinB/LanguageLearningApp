/**
 * @author Kevin Buie
 * Creates a Listening Question for the user
 */
import java.util.UUID;
public class ListeningQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    public ListeningQuestion(Phrase phrase, UUID id){

    }

    public String getQuestion(){
        return null;
    }

    public String getAnswer(){
        return null;
    }

    public boolean isCorrect(String answer){
        return false;
    }
    
    public void playAudio(){

    }
}
