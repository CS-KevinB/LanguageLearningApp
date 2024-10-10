package com.narriation;

import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The RegisteredUser class extends UserList and contains list of registered
 * users for
 * Language learning app
 * 
 * @author Risha Patel
 */

public class User {
    private UUID id;
    private static String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String emailAddress;
    private Date birthday;
    private Avatar avatar;
    private ArrayList<Language> languages;
    private ArrayList<User> friends;
    private int points;
    private UserProgress userProgress;

    public User(UUID id, String firstName, String lastName, String userName, String password, String emailAddress,
            Date birthday, Avatar avatar, ArrayList<User> friends, int points, UserProgress userProgress) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.birthday = birthday;
        this.avatar = avatar;
        this.languages = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.points = 0;
        this.userProgress = new UserProgress();
    }

    public User(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
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
        return userName;
    }

    public boolean setUsername(String newUsername) {
        for(User user : UserList.getInstance().getUsers()){
            if(user.getUsername().equals(newUsername)){
                System.out.println("This username is already in use");
                return false;
            }
        }
        this.userName = newUsername;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public boolean setEmailAddress(String newEmailAddress) {
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
        this.birthday = newBirthday;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public ArrayList<User> getFriends() {
        return friends;
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

    public void setAvatar(CharacterOptions character, HatOptions hat) {
        if (avatar != null) {
            avatar.setCharacter(character);
            avatar.setHat(hat);
        }
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.userName + "/n";
    }
}
