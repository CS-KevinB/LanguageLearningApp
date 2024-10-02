import java.util.ArrayList;
import java.util.UUID;
/**
 * The Lesson class represents a lesson containing exercises and stories.
 * @author Risha Patel
 */

public class Lesson {
    private UUID id;                          
    private ArrayList<Exercise> exercises;    
    private ArrayList<Story> stories;         

    public Lesson(ArrayList<Exercise> exercises, ArrayList<Story> stories) {
        this.id = UUID.randomUUID(); 
        this.exercises = exercises;
        this.stories = stories;
    }

    public Exercise getExercise() {
        return null;  
    }

    public Story getStory() {
        return null; 
    }

    public Lesson getInstance() {
        return this;
    }
}
