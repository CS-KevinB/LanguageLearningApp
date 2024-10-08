package com.narriation;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * The RegisteredUser class extends UserList and contains list of registered users for
 * Language learning app
 * @author Risha Patel 
 */


public class User {
    private UUID id;
    private static String firstName;
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

    public static String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getBirthday() {
        return birthday;
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

    public UserProgress getUserProgress() {
        return userProgress;
    }

    public void setAvatar(CharacterOptions character, HatOptions hat) {
        if(avatar != null) {
            avatar.setCharacter(character);
            avatar.setHat(hat);
        }
    }
    
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.username + "/n";
    }    
    
}
