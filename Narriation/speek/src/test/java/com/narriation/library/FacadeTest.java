package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.narriation.Avatar;
import com.narriation.DataLoader;
import com.narriation.Facade;
import com.narriation.Language;
import com.narriation.LanguageList;
import com.narriation.Phrase;
import com.narriation.User;
import com.narriation.UserList;
import com.narriation.UserProgress;

public class FacadeTest {
    private ArrayList<Language> languages = DataLoader.getLanguages();
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private User user = new User(UUID.randomUUID(), "Jane", "Doe", "jane",
            "doe", "jane@gmail.com",
            new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

    @Before
    public void setup() {
        userList.clear();
        userList.addUser(user);
    }

    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Test
    public void testLoginValid() {
        Facade library = Facade.getInstance();
        library.login("jane", "doe");
        String firstName = library.getCurrentUser().getFirstName();
        assertEquals("Jane", firstName);
    }

    @Test
    public void testLoginInvalid() {
        Facade library = Facade.getInstance();
        boolean login = library.login("fake", "name");
        assertFalse(login);
    }

    @Test
    public void testAddAccountValid() {
        Facade facade = Facade.getInstance();
        String firstName = "First Name";
        String lastName = "Last Name";
        String userName = "Username";
        String password = "Password";
        String birthdayStr = "Birthday (yyyy-MM-dd)";
        String email = "Email";
        ArrayList<Language> languages = LanguageList.getInstance().getLanguages();
        Language language = languages.get(0);
        facade.createAccount(firstName, lastName, userName, password, birthdayStr, email, language);
        facade.logout();
        boolean loggedIn = facade.login("Username", "Password");
        assertTrue(loggedIn);
    }

    @Test
    public void testAddAccountTakenUsername() {
        Facade facade = Facade.getInstance();
        String firstName = "First Name";
        String lastName = "Last Name";
        String userName = "jane";
        String password = "Password";
        String birthdayStr = "Birthday (yyyy-MM-dd)";
        String email = "Email";
        ArrayList<Language> languages = LanguageList.getInstance().getLanguages();
        Language language = languages.get(0);
        User user = facade.createAccount(firstName, lastName, userName, password, birthdayStr, email, language);
        assertNull(user);
    }

    @Test
    public void testAddAccountTakenEmail() {
        Facade facade = Facade.getInstance();
        String firstName = "First Name";
        String lastName = "Last Name";
        String userName = "jane";
        String password = "Password";
        String birthdayStr = "Birthday (yyyy-MM-dd)";
        String email = "JaneDoe@gmail.com";
        ArrayList<Language> languages = LanguageList.getInstance().getLanguages();
        Language language = languages.get(0);
        User user = facade.createAccount(firstName, lastName, userName, password, birthdayStr, email, language);
        assertNull(user);
    }

    @Test
    public void testLogout() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        assertTrue(facade.logout());
    }

    @Test
    public void testUpdateUser() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        String firstName = "Jane";
        String lastName = "Doe";
        String username = "jane";
        String password = "doe";
        String emailAddress = "JaneDoe@gmail.com";
        String birthdayStr = "2003-05-14";
        ArrayList<Language> languages = LanguageList.getInstance().getLanguages();
        Language language = languages.get(0);
        facade.updateUser(facade.getCurrentUser().getUUID(), firstName, lastName, username, password, emailAddress,
                facade.getCurrentUser().getBirthday(), facade.getCurrentUser().getAvatar(), new ArrayList<User>(),
                0, facade.getCurrentUser().getUserProgress(language));
        assertEquals(firstName, facade.getCurrentUser().getFirstName());
        assertEquals(lastName, facade.getCurrentUser().getLastName());
        assertEquals(username, facade.getCurrentUser().getUsername());
        assertEquals(password, facade.getCurrentUser().getPassword());
        assertEquals(emailAddress, facade.getCurrentUser().getEmailAddress());
        assertEquals(birthdayStr, facade.getCurrentUser().getBirthday().toString());
        assertEquals(language, facade.getCurrentUser().getUserProgress(language).getLanguage());
    }

    @Test
    public void testUpdateCredentials() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        String username = "jane";
        String password = "doe";
        facade.updateCredentials(username, password);
        assertEquals(username, facade.getCurrentUser().getUsername());
        assertEquals(password, facade.getCurrentUser().getPassword());
    }

    @Test
    public void testSetValidLanguage() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        Language language = LanguageList.getInstance().getLanguages().get(0);
        assertTrue(facade.setCurrentLangauge(language));
    }

    @Test
    public void testSetInvalidLanguage() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        Language language = LanguageList.getInstance().getLanguages().get(1);
        assertFalse(facade.setCurrentLangauge(language));
    }

    @Test
    public void testSetNullLanguage() {
        Facade facade = Facade.getInstance();
        facade.login("jane", "doe");
        assertFalse(facade.setCurrentLangauge(null));
    }

}
