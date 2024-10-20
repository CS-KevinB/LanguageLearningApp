package com.narriation;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The FileReader class reads users and languages
 * 
 * @author Christian Ruff
 * @author Risha Patel
 */

public class DataLoader extends DataConstants {

    // temporary main
    public static void main(String args[]) {
        getUsers();
    }

    // LANGUAGES
    /**
     * @author Christian Ruff
     * @return
     */
    public static ArrayList<Language> getLanguages() {
        ArrayList<Language> languages = new ArrayList<>();
        try {
            FileReader reader = new FileReader(LANGUAGE_FILE_NAME);
            JSONArray languageJSON = (JSONArray) new JSONParser().parse(reader);

            // 1. create an ArrayList of words

            // 2. create an ArrayList of phrases

            // 3. create an ArrayList of questions (pulled from writing, listening, and
            // matching questions)

            // 4. construct exercises by pulling from ArrayList of questions

            // 5. construct stories

        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    // USERS
    /**
     * @author Christian Ruff
     * @return
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);
            HashMap<User, ArrayList<UUID>> friendsHash = new HashMap<User, ArrayList<UUID>>();

            // 1. construct user objects without friends
            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String username = (String) personJSON.get(USER_USERNAME);
                String password = (String) personJSON.get(USER_PASSWORD);
                String emailAddress = (String) personJSON.get(USER_EMAIL);
                int points = Math.toIntExact((long) personJSON.get(USER_POINTS));

                // convert special data types
                Date birthday = convertStringToDate((String) personJSON.get(USER_BIRTHDAY));
                Avatar avatar = convertJSONToAvatar((JSONObject) personJSON.get(USER_AVATAR));
                UserProgress userProgress = convertJSONToUserProgress((JSONObject) personJSON.get(USER_PROGRESS));

                // create user object
                User newUser = new User(id, firstName, lastName, username, password, emailAddress, birthday, avatar,
                        points, userProgress);
                System.out.println(newUser);

                // record the user's friends as a list of UUIDs
                friendsHash.put(newUser, convertFriendsToArrayList((JSONArray) personJSON.get(FRIENDS)));
                users.add(newUser);
            }

            // 2. iteratively link all friend objects (referencing UUIDs) to each user
            for (int i = 0; i < users.size(); i++) {
                System.out.println("Entered loop #" + i);
                User currentUser = users.get(i);
                ArrayList<UUID> friendsUUIDs = (ArrayList<UUID>) friendsHash.get(currentUser);

                // create user list of friends for each user
                if (friendsUUIDs == null) {
                    System.out.println("User #" + i + " has no friends.");
                } else {
                    // iterate through each friend
                    for (int j = 0; j < friendsUUIDs.size(); j++) {
                        User friend = findUserByUUID(users, friendsUUIDs.get(j));
                        if (friend != null) {
                            currentUser.addFriend(friend);
                            System.out.println(
                                    currentUser.getFirstName() + " is now friended with " + friend.getFirstName());
                        }
                    }
                }
            }

            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date convertStringToDate(String str) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDate.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static ArrayList<UUID> convertFriendsToArrayList(JSONArray json) {
        ArrayList<UUID> ret = new ArrayList<UUID>();
        if (json != null) {
            for (int i = 0; i < json.size(); i++) {
                ret.add(UUID.fromString((String) json.get(i)));
            }
        }
        return ret;
    }

    public static User findUserByUUID(ArrayList<User> users, UUID id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUUID().equals(id))
                return users.get(i);
        }
        return null;
    }

    public static Avatar convertJSONToAvatar(JSONObject json) {
        String character = (String) json.get(CHARACTER);
        String hat = (String) json.get(HAT);
        return new Avatar(character, hat);
    }

    public static UserProgress convertJSONToUserProgress(JSONObject json) {
        int currentLesson = Math.toIntExact((long) json.get(CURRENT_LESSON));
        int currentExercise = Math.toIntExact((long) json.get(CURRENT_EXERCISE));
        return new UserProgress(currentLesson, currentExercise);
    }

}
