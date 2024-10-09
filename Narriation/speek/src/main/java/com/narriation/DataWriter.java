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

    public static boolean saveUsers(ArrayList<User> users) {
        UserList user = UserList.getInstance();
        ArrayList<User> userList = user.getUser();
        JSONArray jsonUsers = new JSONArray();

        for (User u : userList) {
            jsonUsers.add(getUserJSON(u));
        }

        try (FileWriter file = new FileWriter("user.json")) {

            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
        userDetails.put(USER_AVATAR, user.getAvatar().getImagePath());
        userDetails.put(USER_POINTS, user.getPoints());
        userDetails.put(USER_PROGRESS, user.getUserProgress().getProgress());
        userDetails.put(FRIENDS_ID, user.getFriends());
        return userDetails;
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("Risha", "Doe");
        users.add(user1);

        boolean addUser = DataWriter.saveUsers(users);
        if (addUser) {
            System.out.println("User added successfully");
        } else {
            System.out.println("Error adding user");
        }

    }

}
