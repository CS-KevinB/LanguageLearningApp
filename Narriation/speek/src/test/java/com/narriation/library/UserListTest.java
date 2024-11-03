package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.narriation.Avatar;
import com.narriation.DataLoader;
import com.narriation.Language;
import com.narriation.User;
import com.narriation.UserList;
import com.narriation.UserProgress;

public class UserListTest {
    private UserList userList;
    private ArrayList<User> users;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setup() {

        userList = UserList.getInstance();
        userList.getUsers().clear();

        user1 = new User(UUID.randomUUID(), "John", "Doe", "jDoe", "doe", "jdoe@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

        user2 = new User(UUID.randomUUID(), "Jane", "Smith", "jSmith", "smith", "jsmith@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

        user3 = new User(UUID.randomUUID(), "Jane", "Doe", "jhoneD", "123", "jane@gmail.com",
                new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

        userList.addUser(user1);
        userList.addUser(user2);
        // userList.addUser(user3);
    }

    @Test
    public void TestTesting() {
        assertTrue(true);
    }

    @Test
    public void testAddUser() {
        assertEquals(2, userList.getUsers().size());
        userList.addUser(user3);
        assertEquals(3, userList.getUsers().size());
        assertTrue(userList.getUsers().contains(user3));
    }

    @Test
    public void testGetNonExistentUserName() {
        User foudUser = userList.getUser("Mike");
        assertNull(foudUser);
    }

    @Test
    public void testGetUser() {
        User foundUser = userList.getUser(user1.getUsername());
        assertEquals(user1, foundUser);
    }

    @Test
    public void testGetUserProgress() {
        userList.addUser(user3);
        ArrayList<UserProgress> userProgress = userList.getUsersProgress();
        assertEquals(user3.getUserProgress().size(), userProgress.size());
    }

}
