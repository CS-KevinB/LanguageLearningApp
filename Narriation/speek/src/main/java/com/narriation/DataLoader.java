package com.narriation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The FileReader class reads users and languages 
 * @author Christian Ruff
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

                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String username = (String) personJSON.get(USER_USERNAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String birthday = (String) personJSON.get(USER_BIRTHDAY);
                Avatar avatar = convertJSONToAvatar((JSONObject) personJSON.get(USER_AVATAR));
                UserProgress userProgress = convertJSONToUserProgress((JSONObject) personJSON.get(USER_PROGRESS));
                int points = Math.toIntExact((long) personJSON.get(USER_POINTS));

                // ArrayList<User> friends = (ArrayList<User>) personJSON.get(FRIENDS_ID);
                // UserProgress userProgress = (UserProgress) personJSON.get(USER_PROGRESS);

                // REMOVE LATER
                System.out.println(id);
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(username);
                System.out.println(email);
                System.out.println(birthday);
                System.out.println(avatar);
                System.out.println(userProgress);
                System.out.println(points);
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

    public static UserProgress convertJSONToUserProgress(JSONObject json) {
        int currentLesson = Math.toIntExact( (long) json.get(CURRENT_LESSON) );
        int currentExercise = Math.toIntExact( (long) json.get(CURRENT_EXERCISE) );
        return new UserProgress(currentLesson, currentExercise);
    }

    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();
        return languages;
    }
}

