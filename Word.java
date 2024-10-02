public class Word {
    private String englishWord;
    private String translatedWord;
    private String pronunciation;
    private PartOfSpeech partOfSpeech;
    private Gender gender;

    public Word(String englishWord, String translatedWord, String pronunciation, PartOfSpeech partOfSpeech, Gender gender){
        
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
