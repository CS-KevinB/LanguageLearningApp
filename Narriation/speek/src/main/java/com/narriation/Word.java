package com.narriation;
/**
 * @author Kevin Buie
 * Creates a public word and stores things like the translation in order to create questions
 */
public class Word {
    private String englishWord;
    private String translatedWord;
    private String pronunciation;
    private PartOfSpeech partOfSpeech;
    private Gender gender;

    /**
     * Takes all the information and parts of a word and stores them for later use
     * @param englishWord Stores what the word is in english
     * @param translatedWord Stores what the word is in spanish
     * @param pronunciation Stores the pronunciation of the word
     * @param partOfSpeech Stores the part of speech of the word
     * @param gender Stores the gender of the word
     */
    public Word(String englishWord, String translatedWord, String pronunciation, PartOfSpeech partOfSpeech, Gender gender){
        this.englishWord = englishWord;
        this.translatedWord = translatedWord;
        this.pronunciation = pronunciation;
        this.partOfSpeech = partOfSpeech;
        this.gender = gender;
    }
    
    /**
     * Gets what the word is in english
     * @return returns the english word
     */
    public String getEnglishWord(){
        return englishWord;
    }

    public String getTranslatedWord(){
        return translatedWord;
    }

    /**
     * Gets the pronunciation of whatever word
     * @return returns how to say it
     */
    public String getPronunciation(){
        return pronunciation;
    }

    /**
     * Gets the part of speech that the word is (noun, pronoun, etc)
     * @return returns that part of speech
     */
    public PartOfSpeech getPartOfSpeech(){
        return partOfSpeech;
    }
}
