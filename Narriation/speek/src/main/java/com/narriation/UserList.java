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
        if(userList == null)
            userList = new UserList();
        return userList;
    }

    public boolean addUser(UUID id, String firstName, String lastName, String username,
     String password, String emailAddress, Date birthday, Avatar avatar, 
     ArrayList<User> friends, int points, UserProgress userProgress) {
        for (User user : users) {
            if(user.getUsername().equals(username)
             || user.getEmailAddress().equals(emailAddress))
                return false;
        }
        if(getUser(username) == null)
            return false;
        users.add(new User(id, firstName, lastName, username, password, emailAddress,
         birthday, avatar, friends, points, userProgress));
        return true;
    }

    public User getUser(String username) {
        for (User user : users) {
            if(user.getUsername().equals(username))
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
            if(user.equals(users.get(i))) {
                users.set(i, user);
                return true;
            }  
        }
        return false;
    }

    public boolean saveUsers() {
        return DataWriter.saveUsers(users);
    }
}
