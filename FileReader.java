import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The FileReader class reads users and languages 
 * @author Risha Patel
 */

public class FileReader {

    public ArrayList<UserList> getUsers() {
        ArrayList<UserList> users = new ArrayList<>();
        return users;
    }

    public ArrayList<Language> getLanguages() {
       
        ArrayList<Language> languages = new ArrayList<>();
        return languages;
    }
}

