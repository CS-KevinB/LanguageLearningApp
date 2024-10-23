package com.narriation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
    private ArrayList<Phrase> phrases;

    Facade() {
        users = UserList.getInstance();
        phrases = new ArrayList<>();
        // languages = LanguageList.getInstance();
    }

    public static Facade getInstance() {
        if (facade == null)
            facade = new Facade();
        return facade;
    }

    public void setPhrases(ArrayList<Phrase> phrases) {
        this.phrases = phrases;
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

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean logout() {
        boolean saved = users.saveUsers();
        if (saved) {
            currentUser = null;
        }
        return saved;
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

    public void displayQuestion(Phrase phrase) {
        displayMCQ(phrase);
        // displayFillInTheBlank(phrase);
    }

    public void displayMCQ(Phrase correctPhrase) {
        ArrayList<String> options = new ArrayList<>();
        Random random = new Random();
        options.add(correctPhrase.getTranslatedPhrase().toString());

        while (options.size() < 4 && !phrases.isEmpty()) {
            Phrase getRandomPhrase = phrases.get(random.nextInt(phrases.size()));
            if (!options.contains(getRandomPhrase.getTranslatedPhrase().toString())) {
                options.add(getRandomPhrase.getTranslatedPhrase().toString());
            }

            Collections.shuffle(options);

            System.out.println("What is the translation of " + correctPhrase.getEnglishPhrase().toString()
                    + " in spanish? \n Choose from the following options:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            Scanner sc = new Scanner(System.in);
            int userChoice = sc.nextInt();
            if (userChoice > options.size() || userChoice < 1) {
                System.out.println("Invalid choice. Please try again.");
            } else if (options.get(userChoice - 1).equals(correctPhrase.getTranslatedPhrase().toString())) {
                System.out.println("Correct!");
                currentUser.getUserProgress().incrementPhraseSeenCounter(correctPhrase);
            } else {
                System.out.println("Incorrect. The correct answer is " + correctPhrase.getTranslatedPhrase());
            }
            correctPhrase.phraseSeen();

        }

    }

    public void displayFillInTheBlank(Phrase phrase) {

    }

    // public Exercise startExercise() {
    // TODO: PHRASES?
    // }

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

    // public void sendNotification(NotificationType notificationType) {

    // }

    public void viewLanguage() {
        languages.getLanguageByUUID(currentLanguage.getUUID());
    }

    public void startLesson() {
        if (currentUser != null && currentLanguage != null) {
            // Get user progress to start lesson
            UserProgress userProgress = currentUser.getUserProgress();

        }

    }
}