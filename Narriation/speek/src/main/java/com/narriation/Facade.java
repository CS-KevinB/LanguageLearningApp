package com.narriation;

import java.util.ArrayList;
import java.sql.Date;
import java.util.UUID;

/**
 * @author kinsawills
 */
public class Facade {
    private User user;
    private Language currentLanguage;
    private UserList users;
    private LanguageList languages;

    public Facade() {
        users = UserList.getInstance();
        languages = LanguageList.getInstance();

    }

    public boolean login(String username, String password) {
        if (users.getUser(username) == null)
            return false;
        if (!users.getUser(username).getPassword().equals(password))
            return false;
        user = users.getUser(username);
        return true;

    }

    public User createUser(UUID id, String firstName, String lastName, String username,
    String password, String emailAddress, Date birthday, Avatar avatar,
    ArrayList<User> friends, int points, UserProgress userProgress) {
        return users.addUser(id, firstName, lastName, username, password,
        emailAddress, birthday, avatar, friends, points, userProgress);
    }

    public boolean logout() {
        return users.saveUsers();
    }

    public void updateAvatar(CharacterOptions character, HatOptions hat) {
        
    }

    public boolean updateUser(String username, String newUserName) {
        return false;
    }

    public boolean updateCredentials(String username, String password) {
        return false;
    }

    public boolean startLesson() {
        return false;
    }

    public boolean startExercise() {
        return false;

    }

    public boolean startStory() {
        return false;
    }

    public boolean setCurrentLangauge(Language language) {
        return false;
    }

    public void sendNotification(NotificationType notificationType) {
        
    }

}
