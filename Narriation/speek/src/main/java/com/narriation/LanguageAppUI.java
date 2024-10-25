package com.narriation;

import java.util.Scanner;

/**
 * Creates a UI for the language learning app
 */
public class LanguageAppUI {
    private static final String WELCOME_MESSAGE = "Welcome to the Language Learning App!";
    private String[] mainMenuOptions = { "Create Account", "Login", "Logout" };
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
                    break;
                case 2:
                    startLesson();
                    break;
                case 3:
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
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    /**
     * Gets the user command they enter
     * 
     * @param numCommands runs a loop with numCommands
     * @return returns whatever the user enters
     */
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command < numCommands)
            return command;

        return -1;
    }

    /**
     * Creates an account for the user
     */
    private void createAccount() {
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        String username = getField("Username");
        String password = getField("Password");
        String birthday = getField("Birthday");
        String email = getField("Email");

        if (facade.createAccount(firstName, lastName, username, password, email, birthday)) {
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
            System.out.println("Invalid username. Please try again.");
        }
    }

    /**
     * Logs out the user and displays a message
     */
    private void logout() {
        if (facade.logout()) {
            System.out.println("You have been logged out successfully.1");
        } else {
            System.out.println("Logout failed. Please try again.");
        }
    }

    public static void main(String[] args) {
        LanguageAppUI UI = new LanguageAppUI();
        UI.run();
    }

}
