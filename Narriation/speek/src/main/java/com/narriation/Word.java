package com.narriation;

import java.util.UUID;

/**
 * @author Kevin Buie
 *         Creates a public word and stores things like the translation in order
 *         to create questions
 */
public class Word {
    private UUID id;
    private String englishWord;
    private String translatedWord;
    private String pronunciation;
    private PartOfSpeech partOfSpeech;
    private Gender gender;
    private int difficulty;

    /**
     * Takes all the information and parts of a word and stores them for later use
     * 
     * @param englishWord    Stores what the word is in english
     * @param translatedWord Stores what the word is in spanish
     * @param pronunciation  Stores the pronunciation of the word
     * @param partOfSpeech   Stores the part of speech of the word
     * @param gender         Stores the gender of the word
     */
    public Word(String englishWord, String translatedWord, String pronunciation, PartOfSpeech partOfSpeech,
            Gender gender, int difficulty) {
        this.id = UUID.randomUUID();
        this.englishWord = englishWord;
        this.translatedWord = translatedWord;
        this.pronunciation = " ";
        this.partOfSpeech = partOfSpeech.ADJECTIVE;
        this.gender = gender.NEITHER;
        this.difficulty = difficulty;
    }

    /**
     * Constructor for data loader
     * 
     * @author Christian Ruff
     * @param englishWord
     * @param translatedWord
     * @param pronunciation
     * @param partOfSpeech
     * @param gender
     * @param difficulty
     */
    public Word(UUID id, String englishWord, String translatedWord, String pronunciation, PartOfSpeech partOfSpeech,
            Gender gender, int difficulty) {
        this.id = id;
        this.englishWord = englishWord;
        this.translatedWord = translatedWord;
        this.pronunciation = pronunciation;
        this.partOfSpeech = partOfSpeech;
        this.gender = gender;
        this.difficulty = difficulty;
    }

    /**
     * Gets the UUID for the word
     * 
     * @return ID in data type, UUID
     */
    public UUID getUUID() {
        return this.id;
    }

    /**
     * Gets what the word is in english
     * 
     * @return returns the english word
     */
    public String getEnglishWord() {
        return englishWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    /**
     * Gets the pronunciation of whatever word
     * 
     * @return returns how to say it
     */
    public String getPronunciation() {
        return pronunciation;
    }

    /**
     * Gets the part of speech that the word is (noun, pronoun, etc)
     * 
     * @return returns that part of speech
     */
    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    /**
     * Returns a formatted string for the word
     * 
     * @return String formatted (EN word) (translated word) (pronounciation) (part
     *         of speech) (gender)
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EN: ").append(englishWord != null ? englishWord : "null");
        sb.append(" | XX: ").append(translatedWord != null ? translatedWord : "null");
        sb.append(" | Pronunciation: ").append(pronunciation != null ? pronunciation : "null");
        sb.append(" | Part of Speech: ").append(partOfSpeech != null ? partOfSpeech.toString() : "null");
        sb.append(" | Gender: ").append(gender != null ? gender.toString() : "null");
        sb.append("\n");

        return sb.toString();
    }

    public int getDifficulty() {
        return difficulty;
    }
}
