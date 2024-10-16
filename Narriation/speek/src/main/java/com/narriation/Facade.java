package com.narriation;

import java.util.ArrayList;
import java.sql.Date;
import java.util.UUID;

/**
 * @author kinsawills
 */
public class Facade {
    private static Facade facade;
    private User currentUser;
    private Language currentLanguage;
    private UserList users;
    private LanguageList languages;

    private Facade() {
        users = UserList.getInstance();
        languages = LanguageList.getInstance();
    }

    public Facade getInstance() {
        if (facade == null)
            facade = new Facade();
        return facade;
    }

    public boolean login(String username, String password) {
        if (users.getUser(username) == null)
            return false;
        if (!users.getUser(username).getPassword().equals(password))
            return false;
        currentUser = users.getUser(username);
        return true;
    }

    public boolean createUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        return users.addUser(id, firstName, lastName, username, password,
                emailAddress, birthday, avatar, friends, points, userProgress);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean logout() {
        return users.saveUsers();
    }

    public void updateAvatar(CharacterOptions character, HatOptions hat) {
        currentUser.setAvatar(character, hat);
    }

    public boolean updateUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        return users.editUser(id, firstName, lastName, username, password,
                emailAddress, birthday, avatar, friends, points, userProgress);
    }

    public void updateCredentials(String username, String password) {
        currentUser.setUsername(username);
        currentUser.setPassword(password);
    }

    public boolean startLesson() {
        currentUser.getUserProgress().getCurrentLesson();
        return false;
    }

    public boolean startExercise() {
        currentUser.getUserProgress().getCurrentExercise();
        return false;

    }

    public boolean startStory() {
        currentUser.getUserProgress().getCurrentStory();
        return false;
    }

    public boolean setCurrentLangauge(Language language) {
        if (language != null) {
            currentLanguage = language;
            return true;
        }
        return false;
    }

    public void sendNotification(NotificationType notificationType) {

    }

    public boolean createAccount(String username, String password, String email) {
        if (users.getUser(username) != null) {
            return false;
        }

        UUID id = UUID.randomUUID();
        String firstName = "";
        String lastName = "";
        Date birthday = new Date(0);
        Avatar avatar = new Avatar();
        ArrayList<User> friends = new ArrayList<>();
        int points = 0;
        UserProgress userProgress = new UserProgress();

        return users.addUser(id, firstName, lastName, username, password, email, birthday, avatar, friends, points,
                userProgress);
    }

    public void viewLanguage() {
        languages.getLanguageByUUID(currentLanguage.getUUID());
    }

}
