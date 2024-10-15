package com.narriation;
import java.util.ArrayList;
import java.util.UUID;

import software.amazon.awssdk.services.polly.endpoints.internal.Value.Array;
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

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public ArrayList<Story> getStory() {
        return stories;
    }

}
