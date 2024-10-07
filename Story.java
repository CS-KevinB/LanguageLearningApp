import java.util.ArrayList;
/**
 * Story class will have list of stories
 * @author Risha Patel
 */

public class Story {

    private String title;
    private ArrayList<Word> englishStory;
    private ArrayList<Word> spanishStory; 

    /**
     * Constructor for story class
     * @param title - title of the story
     * @param englishStory - list of words for the english story
     * @param spanishStory - list of words for the spanish story
     */
    public Story(String title){
        this.title = title;
        this.englishStory = new ArrayList<>();
        this.spanishStory = new ArrayList<>();
    }
    /**
     * Removes all the words from the story
    * @return - void
    */
    public void remvoveWords(){
        englishStory.clear();
        spanishStory.clear();
    }
    /**
     * To check if the story is correct
     * @return boolean
     */
    public boolean isCorrect(String story){
        return this.title.equalsIgnoreCase(story);
    }
}
