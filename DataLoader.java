import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

/**
 * The FileReader class reads users and languages 
 * @author Risha Patel
 */

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            //FileReader reader = new FileReader(USER_FILE_NAME);
            FileReader reader = new FileReader(USER_FILE_NAME);

            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) parser.parse(reader);
            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject jsonObject = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String firstName = (String)jsonObject.get(USER_FIRST_NAME);
                String lastName = (String) jsonObject.get(USER_LAST_NAME);
                String username = (String) jsonObject.get(USER_USERNAME);
                String email = (String) jsonObject.get(USER_EMAIL);
                String birthday = (String) jsonObject.get(USER_BIRTHDAY);
                Avatar avatar = (Avatar) jsonObject.get(USER_AVATAR);
                ArrayList<User> friends = (ArrayList<User>) jsonObject.get(FRIENDS_ID);
                int points = (int) jsonObject.get(USER_POINTS);
                UserProgress userProgress = (UserProgress) jsonObject.get(USER_PROGRESS);
                users.add(new User(id, firstName, lastName, username, email, birthday, avatar, friends, points, userProgress));
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Language> getLanguages() {
       
        ArrayList<Language> languages = new ArrayList<>();
        return languages;
    }
}

