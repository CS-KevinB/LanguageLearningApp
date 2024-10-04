public class Word {
    private String englishWord;
    private String translatedWord;
    private String pronunciation;
    private PartOfSpeech partOfSpeech;
    private Gender gender;

    public Word(String englishWord, String translatedWord, String pronunciation, PartOfSpeech partOfSpeech, Gender gender){
        this.englishWord = englishWord;
        this.translatedWord = translatedWord;
        this.pronunciation = pronunciation;
        this.partOfSpeech = partOfSpeech;
        this.gender = gender;
    }
    
    public String getEnglishWord(){
        return englishWord;
    }

    public String getPronunciation(){
        return pronunciation;
    }

    public PartOfSpeech getPartOfSpeech(){
        return partOfSpeech;
    }
}
