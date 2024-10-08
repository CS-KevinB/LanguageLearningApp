package com.narriation;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataWriter class saves list of registered users
 * @author Risha Patel
 */

public class DataWriter extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
    UserList user = UserList.getInstance();
    ArrayList<User> userList = user.getUser();
    JSONArray jsonUsers = new JSONArray(); 

    for(int i = 0; i < userList.size(); i++){
        jsonUsers.add(getUserJSON(userList.get(i)));
    }

    try (DataWriter file = new DataWriter("user.json")) {

        file.write(jsonUsers.toJSONString);
        file.flush();

    } catch (IOException e) {
        e.printStackTrace();
    }

    
}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUsername().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_EMAIL, user.getEmailAddress());
        userDetails.put(USER_BIRTHDAY, user.getBirthday());
        userDetails.put(USER_AVATAR, user.getAvatar().getImage());
        userDetails.put(USER_POINTS, user.getPoints());
        userDetails.put(USER_PROGRESS, user.getUserProgress().getProgress());
        userDetails.put(FRIENDS_ID, user.getFriends());
        return userDetails;
	}

}
