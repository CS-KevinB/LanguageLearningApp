package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.narriation.Facade;
import com.narriation.Language;
import com.narriation.LanguageList;
import com.narriation.User;

public class FacadeTest {
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

}
