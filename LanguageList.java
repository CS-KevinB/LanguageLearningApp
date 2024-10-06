/**
 * @author kinsawills
 */
public class LanguageList {
    private static LanguageList languageList;
    private ArrayList<Language> languages;
    
    private LanguageList() {

    }

    public static LanguageList getInstance() {
        
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }
}
