/**
 * @author Kevin Buie
 * Creates a writing question for the user
 */
import java.util.UUID;
public class WritingQuestion implements Question{
    private Phrase phrase;
    private UUID id;

    public WritingQuestion(Phrase phrase, UUID id){
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
}
