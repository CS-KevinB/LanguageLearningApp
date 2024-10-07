package com.narriation;
import java.io.IOException;
import java.util.ArrayList;

import netscape.javascript.JSObject;
/**
 * DataWriter class saves list of registered users
 * @author Risha Patel
 */

public class DataWriter extends DataConstants {

    public static boolean saveUsers(ArrayList<User> users) {
       JSONArray jsonUsers = new JSONArray(); 

    for(int i = 0; i < users.size(); i++){
        JSObject user = getUserJSON(users.get(i));
        jsonUsers.add(user);
    }

    try(DataWriter file = new DataWriter("user.json")){
        file.write(jsonUsers.toJSONString());
        file.flush();
        return true;

    } catch(IOException e){
        e.printStackTrace();
        return false;
    }
}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_BIRTHDAY, user.getBirthday());
        userDetails.put(USER_AVATAR, user.getAvatar().getImage());
        userDetails.put(USER_POINTS, user.getPoints());
        userDetails.put(USER_PROGRESS, user.getProgress().getProgress());
        userDetails.put(FRIENDS_ID, user.getFriends());
        return userDetails;
	}

}
