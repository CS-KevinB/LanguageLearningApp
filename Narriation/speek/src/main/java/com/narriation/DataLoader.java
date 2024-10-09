package com.narriation;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 * The FileReader class reads users and languages 
 * @author Risha Patel
 */

public class DataLoader extends DataConstants {

    // temporary main
    public static void main(String args[]) {
        getUsers();
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            //FileReader reader = new FileReader(USER_FILE_NAME);
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);

                // UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String username = (String) personJSON.get(USER_USERNAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String birthday = (String) personJSON.get(USER_BIRTHDAY);
                // Avatar avatar = (Avatar) personJSON.get(USER_AVATAR);
                // ArrayList<User> friends = (ArrayList<User>) personJSON.get(FRIENDS_ID);
                // int points = (int) personJSON.get(USER_POINTS);
                // UserProgress userProgress = (UserProgress) personJSON.get(USER_PROGRESS);
                JSONObject avatar = (JSONObject) personJSON.get(USER_AVATAR);

                // REMOVE LATER
                // System.out.println(id);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(username);
                System.out.println(email);
                System.out.println(birthday);
                // System.out.println(points);
                System.out.println(convertJSONToAvatar(avatar));
                // --------

                // users.add(new User(id, firstName, lastName, username, email, birthday, avatar, friends, points, userProgress));

            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Avatar convertJSONToAvatar(JSONObject json) {
        String character = (String) json.get(CHARACTER);
        String hat = (String) json.get(HAT);
        return new Avatar(character, hat);
    }

    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();
        return languages;
    }
}

