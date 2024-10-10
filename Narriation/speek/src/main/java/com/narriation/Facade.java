package com.narriation;
/**
 * @author kinsawills
 */
public class Facade {
    private User user;
    private Language currentLanguage;

    public Facade() {

    }

    public User login(String username, String password) {
        return null;
    }

    public User createUser() {
        return null;
    }

    public boolean logout() {
        return false;
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
