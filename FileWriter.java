import java.io.IOException;
import java.util.ArrayList;
/**
 * FileWriter class saves list of registered users
 * @author Risha Patel
 */

public class FileWriter extends DataConstants {
    public void saveUser(ArrayList<User> users){
       User userList = User.getInstance();
       ArrayList<Use> UserList = new ArrayList<>();
       JSONArray jsonUsers = new JSONArray();    

    for(int i = 0; i < users.size(); i++){
        jsonUsers.add(users.get(i).toJSON());
    }

    try(FileWriter file = new FileWriter("users.json")){
    file.write(jsonUsers.toJSONString());
    file.flush();  
    } catch(IOException e){
    e.printStackTrace();
        }
	}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_AGE, user.getAge());
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        
        return userDetails;
	}

}
