package com.narriation;

import java.sql.Date;
/**
 * @author kinsawills
 */
import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        users = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if (userList == null)
            userList = new UserList();
        return userList;
    }

    // addUser Method to test DataWriter
    public boolean addUser(String firstName, String lastName) {

        UUID id = UUID.randomUUID();
        String username = firstName.toLowerCase() + lastName.toLowerCase();
        String password = "123";
        String emailAddress = username + "@email.com";
        Date birthday = new Date(0);
        Avatar avatar = new Avatar();
        ArrayList<User> friends = new ArrayList<>();
        int points = 0;
        UserProgress userProgress = new UserProgress();

        for (User user : users) {
            if (user.getUsername().equals(username) || user.getEmailAddress().equals(emailAddress)) {
                return false;
            }
        }

        User newUser = new User(id, firstName, lastName, username, password, emailAddress,
                birthday, avatar, friends, points, userProgress);
        users.add(newUser);
        return saveUsers();
    }

    public boolean addUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    || user.getEmailAddress().equals(emailAddress))
                return false; // User already exists
        }

        // Add the new user to the list
        User newUser = new User(id, firstName, lastName, username, password, emailAddress,
                birthday, avatar, friends, points, userProgress);
        users.add(newUser);
        return saveUsers();

    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public boolean editUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        User user = new User(id, firstName, lastName, username, password,
                emailAddress, birthday, avatar, friends, points, userProgress);
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i))) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean saveUsers() {
        return DataWriter.saveUsers(users);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    // public static void main(String[] args) {
    // UserList userList = UserList.getInstance();
    // Avatar avatar = new Avatar();
    // UserProgress userProgress = new UserProgress();
    // @SuppressWarnings("deprecation")
    // Date birthday = new Date(2003, 05, 14);
    // ArrayList<User> friends = new ArrayList<>();
    // @SuppressWarnings("deprecation")
    // Date birthday2 = new Date(2000, 9, 11);

    // friends.add(User("081a004b-3306-4975-9520-2437276c600a", "Julie", "Adams",
    // "adamsj", "Jul!e@dam$", "JulieAdams@gmail.com", birthday2, avatar,
    // languages))

    // System.out.println(userList.addUser("a9fc5c37-053b-479e-9741-7f0bb0e525ae",
    // "Jane", "Doe", "JDOE46", "Columb!aSC", "JaneDoe@gmail.com", birthday, avatar,
    // "3085ad7f-139c-4d3e-85e6-52cc0d028a29",
    // "081a004b-3306-4975-9520-2437276c600a", 0, userProgress));

    // }
}
