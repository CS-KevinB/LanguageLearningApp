package com.narriation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DataWriter class saves list of registered users
 * 
 * @author Risha Patel
 */

public class DataWriter extends DataConstants {

    private static final Object USER_PROGRESS = null;

    /**
     * Saves the users to a json file
     * 
     * @param users requires the list of users in order to save
     * @return returns a boolean if the save was successful
     */
    @SuppressWarnings("unchecked")
    public static boolean saveUsers(ArrayList<User> users) {
        UserList user = UserList.getInstance();
        ArrayList<User> userList = user.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (User u : userList) {
            jsonUsers.add(getUserJSON(u));
        }

        try (FileWriter file = new FileWriter("Narriation/speek/json/user-test.json")) {

            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Saves the user to a json file
     * 
     * @param user requires the specific user now in order to add to the json file
     * @return returns a JSON Object
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        userDetails.put(USER_ID, user.getUUID().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_EMAIL, user.getEmailAddress());
        userDetails.put(USER_BIRTHDAY, user.getBirthday().toString());
        userDetails.put(USER_POINTS, user.getPoints());

        // Avatar information
        JSONObject avatarJSON = new JSONObject();
        avatarJSON.put(CHARACTER, user.getAvatar().getCharacter());
        avatarJSON.put(HAT, user.getAvatar().getHat());
        userDetails.put(USER_AVATAR, avatarJSON);

        // Friends list
        JSONArray friendsArray = new JSONArray();
        for (User friend : user.getFriends()) {
            friendsArray.add(friend.getUUID().toString());
        }
        userDetails.put(FRIENDS, friendsArray);

        // User Progress

    }

    public static void main(String[] args) {
        UserList users = UserList.getInstance();
        boolean userAdded = users.saveUsers();
        if (userAdded) {
            System.out.println("Users saved successfully!");
        } else {
            System.out.println("Failed to save users");
        }
    }

}
