package com.narriation;

import java.util.Scanner;
import java.util.Date;
import org.json.simple.parser.ParseException;

/**
 * Creates a UI for the language learning app
 */
public class LanguageAppUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Language Learning App!";
    private String[] mainMenuOptions = { "Create Account", "Login", "Start Lesson", "Read a Story", "View Progress", "Print Progress",
            "Logout" };
    private Scanner scanner;
    private Facade facade;

    /**
     * Creates a default UI
     */
    LanguageAppUI() {
        scanner = new Scanner(System.in);
        facade = new Facade();
    }

    /**
     * Runs the welcome message and checks for the login status
     * Displays the main menu and checks for the user input
     */
    public void run() {
        System.out.println(WELCOME_MESSAGE);
        boolean loggedIn = true;
        while (loggedIn) {
            displayMainMenu();
            int userCommand = getUserCommand(mainMenuOptions.length);

            if (userCommand == -1) {
                System.out.println("Invalid command");
                continue;
            }
            if (userCommand > mainMenuOptions.length) {
                System.out.println("Invalid command");
            }
            if (userCommand == mainMenuOptions.length) {
                facade.logout();
                System.out.println("Logging out ...");
                break;
            }
            switch (userCommand) {
                case 0:
                    createAccount();
                    break;
                case 1:
                    login();

                    // Language language = this.facade.getLanguage();
                    // Phrase phrase = language.getPhrases().get(1);

                    // System.out.println("BEFORE: "
                    // +
                    // this.facade.getCurrentUser().getUserProgress(language).getPhraseProgress(phrase));

                    // T/F questions
                    // Listening questions
                    // Lesson
                    // Story

                    // System.out.println("AFTER: "
                    // +
                    // this.facade.getCurrentUser().getUserProgress(language).getPhraseProgress(phrase));

                    break;
                case 2:
                    startLesson();
                    break;
                case 3:
                    this.facade.startStory();
                    break;
                case 4:
                    System.out.println(this.facade.displayProgress());
                    break;
                case 5:
                    this.facade.printProgress();
                    System.out.println("A file has been created in the Narriation/speek/user-progress folder!");
                    break;
                case 6:
                    logout();
                    loggedIn = false;

                    break;
            }
        }
        System.out.println("Goodbye! Keep learning!");
    }

    /**
     * Starts the lesson from the facade
     */
    private void startLesson() {
        facade.startLesson();
    }

    /**
     * Displays the main menu
     */
    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        if (facade.getCurrentUser() == null) {
            for (int i = 0; i < 2; i++) {
                System.out.println((i + 1) + ". " + mainMenuOptions[i]);
            }
            System.out.println("\n");
        } else {
            for (int i = 2; i < mainMenuOptions.length; i++) {
                System.out.println((i - 1) + ". " + mainMenuOptions[i]);
            }
            System.out.println("\n");
        }
    }

    /**
     * Gets the user command they enter
     * 
     * @param numCommands runs a loop with numCommands
     * @return returns whatever the user enters
     */
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        String inputStr = scanner.nextLine();
        int input;

        // check if the value is a number
        try {
            input = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (facade.getCurrentUser() != null) {
            int command = input + 1;
            if (command >= 0 && command < numCommands)
                return command;
        } else {
            int command = input - 1;
            if (command >= 0 && command < numCommands)
                return command;
        }
        return -1;
    }

    /**
     * Creates an account for the user
     */
    private void createAccount() {
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        String userName = getField("Username");
        String password = getField("Password");
        String birthdayStr = getField("Birthday (yyyy-MM-dd)");
        String email = getField("Email");

        if (facade.createAccount(firstName, lastName, userName, password, birthdayStr, email)) {
            System.out.println("Account successfully created!");
        } else {
            System.out.println("Account already exists. Please try logging in.");
        }
    }

    /**
     * Gets a field from the user
     * 
     * @param prompt requires the prompt in order to get the field
     * @return returns the string of the field
     */
    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * Logs in the user with the username and password
     */
    private void login() {
        String username = getField("Username");
        String password = getField("password");

        if (facade.login(username, password)) {
            User currentUser = facade.getCurrentUser();
            System.out.println("Login successful! Welcome, " + username);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    /**
     * Logs out the user and displays a message
     */
    private void logout() {
        if (facade.logout()) {
            System.out.println("You have been logged out successfully");
        } else {
            System.out.println("Logout failed. Please try again.");
        }
    }

    public static void main(String[] args) {
        LanguageAppUI UI = new LanguageAppUI();
        UI.run();
    }

}
