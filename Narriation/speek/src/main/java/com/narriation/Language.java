package com.narriation;
/**
 * @author kinsawills
 */
import java.util.ArrayList;
import java.util.UUID;

public class Language {
    private UUID id;
    private String nameOfLanguage;
    private ArrayList<Lesson> lessons;
    private ArrayList<Word> words;
    private ArrayList<Phrase> phrases;

    public Language(UUID id, String nameOfLanguage, ArrayList<Lesson> lessons, ArrayList<Word> words, ArrayList<Phrase> phrases) {
        this.id = id;
        this.nameOfLanguage = nameOfLanguage;
        this.lessons = lessons;
        this.words = words;
        this.phrases = phrases;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }

    public String getLanguage () {
        return nameOfLanguage;
    }

    public UUID getUUID() {
        return id;
    }
}
