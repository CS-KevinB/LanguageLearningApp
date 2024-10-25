package com.narriation;

import java.util.ArrayList;

/**
 * Story class will have list of stories
 * 
 * @author Risha Patel
 */

public class Story {

    private String title;
    private ArrayList<Word> englishStory;
    private ArrayList<Word> spanishStory;

    /**
     * Constructor for story class
     * 
     * @param title        - title of the story
     * @param englishStory - list of words for the english story
     * @param spanishStory - list of words for the spanish story
     */
    public Story(String title, ArrayList<Word> englishStory, ArrayList<Word> spanishStory) {
        this.title = title;
        this.englishStory = englishStory;
        this.spanishStory = spanishStory;
    }

    /**
     * Gets the story for the user
     * @return returns that story as a string
     */
    public String getStory() {
        StringBuilder storyBuilder = new StringBuilder();
        for (Word word : englishStory) {
            storyBuilder.append(word.getEnglishWord());
            storyBuilder.append(" ");
        }
        return storyBuilder.toString();
    }

    /**
     * Removes all the words from the story
     * 
     * @return - void
     */
    public void removeWords() {
        englishStory.clear();
        spanishStory.clear();
    }

    /**
     * To check if the story is correct
     * 
     * @return boolean
     */
    public boolean isCorrect(String story) {
        return this.title.equalsIgnoreCase(story);
    }

    /**
     * To string method in order to test the story
     */
    public String toString() {
        return "Title: " + this.title + "\n English Story: " + this.englishStory + "\n Spanish Story: "
                + this.spanishStory;
    }
}
