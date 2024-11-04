package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.narriation.DataWriter;
// import com.narriation.Facade;
// import com.narriation.Language;
// import com.narriation.LanguageList;
import com.narriation.User;
import com.narriation.UserList;
import com.narriation.UserProgress;
import com.narriation.Avatar;
//import com.narriation.DataLoader;

public class DataWriterTest {

    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Before
    public void setup() {
        UserList.getInstance().getUsers().clear();
        ;
        DataWriter.saveUsers(userList);
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers(userList);
    }

    @Test
    public void testWritingZeroUsers() {
        assertEquals(0, userList.size());
    }

    @Test
    public void testAddingSingleUser() {
        User user = new User(UUID.randomUUID(), "Jhon", "Doe", "jhonD", "123", "jhon@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        userList.add(user);
        DataWriter.saveUsers(userList);
        assertEquals(1, userList.size());
    }

    @Test
    public void testAddingMultipleUsers() {
        User user1 = new User(UUID.randomUUID(), "Jhon", "Doe", "jhonD", "123", "jhon@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        User user2 = new User(UUID.randomUUID(), "Risha", "Patel", "Rishap", "456", "Risha@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        User user3 = new User(UUID.randomUUID(), "Coddy", "Smith", "CodyS", "177", "coddy@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        DataWriter.saveUsers(userList);
        assertEquals(3, userList.size());
        assertEquals("jhonD", userList.get(0).getUsername());
    }

    @Test
    public void testSaveUserWithSpecialCharacters() {
        User user = new User(UUID.randomUUID(), "Jhon", "Doe", "jhonD", "123", "jhon@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        user.setFirstName("Jhon's");
        user.setLastName("Doe's");
        user.setUsername("jhonD's");
        user.setEmailAddress("jhon@gmail.com");
        userList.add(user);
        DataWriter.saveUsers(userList);
        assertEquals(1, userList.size());
        assertEquals("Jhon's", userList.get(0).getFirstName());
    }

    @Test
    public void testSaveUserWithEmptyUsername() {
        User user = new User(UUID.randomUUID(), "Jhon", "Doe", "", "123", "jhon@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
        userList.add(user);
        DataWriter.saveUsers(userList);
        assertEquals(0, userList.size());
    }

    @Test
    public void testSaveEmptyUserList() {
        ArrayList<User> emptyUserList = new ArrayList<>();
        DataWriter.saveUsers(emptyUserList);
        assertEquals(0, userList.size());
    }

    @Test
    public void testSaveUserWithInvalidEmailFormat() {
        ArrayList<User> userList = new ArrayList<>();
        User invalidEmailUser = new User(UUID.randomUUID(), "Invalid", "Email", "iemail", "password123",
                "invalidemail", new Date(), new Avatar(), 5, new ArrayList<>());
        userList.add(invalidEmailUser);

        boolean result = DataWriter.saveUsers(userList);
        assertFalse("Saved user with invalid email format", result);

    }

    @Test
    public void testSaveUsersWithNullFields() {
        User nullUser = new User(null, null, null, null, null, null, null, null, 0, null);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(nullUser);

        boolean result = DataWriter.saveUsers(userList);
        assertFalse("Saved user with null fields", result);
    }

}
