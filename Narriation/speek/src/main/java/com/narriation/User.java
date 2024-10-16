package com.narriation;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

/**
 * The RegisteredUser class extends UserList and contains list of registered
 * users for
 * Language learning app
 * 
 * @author Risha Patel
 */

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
    private Date birthday;
    private Avatar avatar;
    private ArrayList<Language> languages;
    private ArrayList<User> friends;
    private int points;
    private UserProgress userProgress;
    private HashMap<Language, UserProgress> languageProgress; //Check

    public User(UUID id, String firstName, String lastName, String username, String password, String emailAddress,
            Date birthday, Avatar avatar, ArrayList<User> friends, int points, UserProgress userProgress) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
        this.birthday = birthday;
        this.avatar = avatar;
        this.languages = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.points = 0;
        this.userProgress = new UserProgress();
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addLanguage(Language language) {
        languages.add(language);
    }

    public void removeLanguage(Language language) {
        languages.remove(language);
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public void addPoints(int numOfPoints) {
        points += numOfPoints;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
         firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName; 
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String newUsername) {
        if(newUsername.equals("")){
            System.out.println("Please enter a valid username");
            return false;
        }
        for(User user : UserList.getInstance().getUsers()){
            if(user.getUsername().equals(newUsername)){
                System.out.println("This username is already in use");
                return false;
            }
        }
        this.username = newUsername;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword){
        if(newPassword.equals("")){
            System.out.println("Please enter a valid password");
            return;
        }
        this.password = newPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setEmailAddress(String newEmailAddress) {
        if(newEmailAddress.equals("")){
            System.out.println("Please enter a valid email address");
            return false;
        }
        for(User user : UserList.getInstance().getUsers()){
            if(user.getEmailAddress().equals(newEmailAddress)){
                System.out.println("This email address is already in use");
                return false;
            }
        }
        this.emailAddress = newEmailAddress;
        return true;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date newBirthday) {
        if(newBirthday == null){
            System.out.println("Please enter a valid birthday");
            return;
        }
        this.birthday = newBirthday;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void addFriends(User friend) {
        if(friend == null){
            System.out.println("You have no friends");
            return;
        }
        this.friends.add(friend);
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(){
        points++;
    }

    public UserProgress getUserProgress() {
        return userProgress;
    }

    public void updateProgress(Language language, UserProgress userProgress) {
        this.languageProgress.put(language, userProgress);
    } // Check

    public void setAvatar(CharacterOptions character, HatOptions hat) {
        if (avatar != null) {
            avatar.setCharacter(character);
            avatar.setHat(hat);
        }
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.username + "/n";
    }
}
