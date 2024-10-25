package com.narriation;

/**
 * @author kinsawills
 */
import java.util.ArrayList;
import java.util.UUID;

public class Language {
    private UUID id;
    private String nameOfLanguage;
    private ArrayList<Word> words;
    private ArrayList<Phrase> phrases;
    private ArrayList<Story> stories;

    public Language(UUID id, String nameOfLanguage, ArrayList<Word> words,
            ArrayList<Phrase> phrases, ArrayList<Story> stories) {
        this.id = id;
        this.nameOfLanguage = nameOfLanguage;
        this.words = words;
        this.phrases = phrases;
        this.stories = stories;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }

    public String getLanguage() {
        return nameOfLanguage;
    }

    public UUID getUUID() {
        return id;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

    public String toString() {
        return "ID: " + this.id + "\n  Language: " + this.nameOfLanguage + "\n  Words: " + this.words + "\n  Phrases: "
                + this.phrases + "\n  Stories: " + this.stories;
    }
}
