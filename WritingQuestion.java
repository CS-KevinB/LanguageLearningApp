/**
 * @author Kevin Buie
 * Creates a writing question for the user
 */
import java.util.UUID;
public class WritingQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    public WritingQuestion(Phrase phrase, UUID id){

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
}
