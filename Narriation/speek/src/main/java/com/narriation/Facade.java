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
    private static Scanner keyboard = new Scanner(System.in);
    private User currentUser;
    private Language currentLanguage;
    private UserList users;
    private LanguageList languages;
    private ArrayList<Phrase> phrases;

    /**
     * Creates a facade
     */
    Facade() {
        phrases = new ArrayList<>();
        languages = LanguageList.getInstance();
        users = UserList.getInstance();
    }

    /**
     * Gets the instance of the facade
     * 
     * @return returns the instance of the facade
     */
    public static Facade getInstance() {
        if (facade == null)
            facade = new Facade();
        return facade;
    }

    /**
     * Sets the phrases for the user
     * 
     * @param phrases requires the array list of phrases in order to set
     */
    public void setPhrases(ArrayList<Phrase> phrases) {
        this.phrases = phrases;
    }

    /**
     * Logs in the user
     * 
     * @param username requires the username in order to log in
     * @param password requires the password in order to log in
     * @return returns a boolean if the login was successful
     */
    public boolean login(String username, String password) {
        if (users.getUser(username) == null)
            return false;
        if (!users.getUser(username).getPassword().equals(password))
            return false;
        currentUser = users.getUser(username);
        return true;
    }

    /**
     * Creates a user
     * 
     * @param id           requires the id in order to create the user
     * @param firstName    requires the first name
     * @param lastName     requires the last name
     * @param username     requires a username
     * @param password     requires a password
     * @param emailAddress requires an email address
     * @param birthday     requires a birthday
     * @param avatar       requires an avatar
     * @param friends      requires an array list of friends
     * @param points       requires the points
     * @param userProgress requires the user progress
     * @return returns a boolean if the user was created
     */
    public boolean createUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        return users.addUser(id, firstName, lastName, username, password,
                emailAddress, birthday, avatar, friends, points, userProgress);
    }

    /**
     * Creates an account
     * 
     * @param username requires the username
     * @param password requires the password
     * @param email    requires the email
     * @return returns a boolean if the account was created
     */
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

    /**
     * Gets the current user
     * 
     * @return returns the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Logs out the user
     * 
     * @return returns a boolean if the logout was successful
     */
    public boolean logout() {
        boolean saved = users.saveUsers();
        if (saved) {
            currentUser = null;
        }
        return saved;
    }

    /**
     * Updates the avatar
     * 
     * @param character requires the new character option
     * @param hat       requires the new hat option
     */
    public void updateAvatar(CharacterOptions character, HatOptions hat) {
        currentUser.setAvatar(character, hat);
    }

    /**
     * Updates the user
     * 
     * @param id           requires the id in order to update the user
     * @param firstName    requires the first name
     * @param lastName     requires the last name
     * @param username     requires a username
     * @param password     requires a password
     * @param emailAddress requires an email address
     * @param birthday     requires a birthday
     * @param avatar       requires an avatar
     * @param friends      requires an array list of friends
     * @param points       requires the points
     * @param userProgress requires the user progress
     * @return returns a boolean if the user was updated
     */
    public boolean updateUser(UUID id, String firstName, String lastName, String username,
            String password, String emailAddress, Date birthday, Avatar avatar,
            ArrayList<User> friends, int points, UserProgress userProgress) {
        return users.editUser(id, firstName, lastName, username, password,
                emailAddress, birthday, avatar, friends, points, userProgress);
    }

    /**
     * Updates the credentials
     * 
     * @param username requires the new username
     * @param password requires the new password
     */
    public void updateCredentials(String username, String password) {
        currentUser.setUsername(username);
        currentUser.setPassword(password);
    }

    /**
     * Displays a question
     * 
     * @param phrase requires the phrase in order to display
     */
    public void displayQuestion(Phrase phrase) {
        displayMCQ(phrase);
        // displayFillInTheBlank(phrase);
    }

    /**
     * Displays a multiple choice question
     * 
     * @param correctPhrase requires the correct phrase in order to display
     */
    public void displayMCQ(Phrase correctPhrase) {
        ArrayList<String> options = new ArrayList<>();
        Random random = new Random();

        String correctAnswer = phraseToString(correctPhrase.getTranslatedPhrase());
        options.add(correctAnswer);

        while (options.size() < 4 && !phrases.isEmpty()) {
            Phrase getRandomPhrase = phrases.get(random.nextInt(phrases.size()));
            String translatedString = phraseToString(getRandomPhrase.getTranslatedPhrase());

            if (!options.contains(translatedString)) {
                options.add(translatedString);
            }

            Collections.shuffle(options);

            System.out.println("Translate the phrase: " + phraseToString(correctPhrase.getEnglishPhrase()));
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            Scanner sc = new Scanner(System.in);
            int userChoice = sc.nextInt();

            if (userChoice > options.size() || userChoice < 1) {
                System.out.println("Invalid choice. Please try again.");
            } else if (options.get(userChoice - 1).equals(phraseToString(correctPhrase.getTranslatedPhrase()))) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctPhrase.getTranslatedPhrase());
            }
            correctPhrase.phraseSeen();

        }

    }

    /**
     * Converts the phrase to a string
     * 
     * @param phrase requires the phrase in order to convert
     * @return returns the phrase as a string
     */
    private String phraseToString(ArrayList<Word> phrase) {

        StringBuilder phraseToString = new StringBuilder();
        for (Word word : phrase) {
            phraseToString.append(word.getTranslatedWord()).append(" ");

        }
        return phraseToString.toString().trim();

    }

    public void displayFillInTheBlank(Phrase phrase) {
        Random random = new Random();

    }

    // public Exercise startExercise() {
    // TODO: PHRASES?
    // }

    public boolean startStory() {
        currentUser.getUserProgress().getCurrentStory();
        return false;
    }

    /**
     * Sets the current language
     * 
     * @param language requires the language in order to set
     * @return returns a boolean if the language was set
     */
    public boolean setCurrentLangauge(Language language) {
        if (language != null) {
            currentLanguage = language;
            return true;
        }
        return false;
    }

    // public void sendNotification(NotificationType notificationType) {

    // }

    /**
     * Gets the current language
     * 
     * @return returns the current language
     */
    public Language getCurrentLanguage() {
        return languages.getLanguageByUUID(currentLanguage.getUUID());
    }

    /**
     * Starts the lesson
     */
    public void startLesson() {
        if (this.currentUser != null && this.currentLanguage != null) {
            Lesson lesson = new Lesson(this.currentUser.getUserProgress(), this.currentLanguage);
            ArrayList<Question> questions = lesson.getQuestions();

            for (Question question : questions) {
                System.out.println(question.getQuestion());
                String input = keyboard.nextLine();
                if (question.isCorrect(input)) {
                    System.out.println("Correct! Great work! Your score is now " + lesson.getScore());
                } else {
                    System.out.println("Oh no, that was incorrect. Keep going!");
                }
            }

            System.out.println("Lesson complete! Your final score is " + lesson.getScore());
        }
    }

    /**
     * Gets the language
     * 
     * @return returns the language
     */
    public LanguageList getLanguages() {
        return this.languages;
    }

    public UserList getUsers() {
        return this.users;
    }
}