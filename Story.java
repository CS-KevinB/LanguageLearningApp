import java.util.ArrayList;

/**
 * Story class will have list of stories
 * @author Risha Patel
 */

public class Story {

    private String title;
    private ArrayList<Word> englishStory;
    private ArrayList<Word> spanishStory; 

    public Story(String title){
        this.title = title;
        this.englishStory = new ArrayList<>();
        this.spanishStory = new ArrayList<>();

    }

    public void remvoveWords(){
        englishStory.remove(word);
        spanishStory.remove(word);
    }

    public boolean isCorrect(String story){
        return this.title.equalsIgnoreCase(story);
    }




    
}
