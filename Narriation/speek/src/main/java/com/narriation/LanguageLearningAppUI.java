package com.narriation;

import java.util.Scanner;

public class LanguageLearningAppUI {

    private static final String WELCOME_MESSAGE = "Welcome to the Language Learning App!";
    private String[] mainMenuOptions = { "Create Account", "Login", "Logout" };
    private Scanner scanner;
    private Facade facade;

    LanguageLearningAppUI() {
        scanner = new Scanner(System.in);
        facade = new Facade();
    }

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
                    logout();
                    loggedIn = false;
                    break;
            }
        }
        System.out.println("Goodbye! Keep learning!");
    }

    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");
        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command < numCommands)
            return command;

        return -1;
    }

    private void createAccount() {
        String username = getField("Username");
        String password = getField("Password");
        String email = getField("Email");

        if (facade.createAccount(username, password, email)) {
            System.out.println("Account successfully created!");
        } else {
            System.out.println("Username already exists. Try a different username.");
        }
    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

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

    private void logout() {
        if (facade.logout()) {
            System.out.println("You have been logged out successfully.");
        } else {
            System.out.println("Logout failed. Please try again.");
        }
    }

    public static void main(String[] args) {
        LanguageLearningAppUI UI = new LanguageLearningAppUI();
        UI.run();
    }

}
