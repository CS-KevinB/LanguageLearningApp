package com.narriation;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class UserTest {
    private ArrayList<Language> languages = DataLoader.getLanguages();
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private User user = new User(UUID.randomUUID(), "Barack", "Obama", "barack",
            "ob@ma", "barack@gmail.com",
            new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

    private User friend = new User(UUID.randomUUID(), "Michelle", "Obama", "michelle",
            "0bama", "michelle@gmail.com",
            new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void isTrue() {
        assertTrue(true);
    }

    @Test
    public void testAddFriend() {
        if (!user.getFriends().contains(friend)) {
            user.addFriend(friend);
            assertTrue(user.getFriends().contains(friend));
        } else {
            assertTrue(false);
        }
    }

    @Test
    public void testAddNullFriend() {
        User friend = null;
        user.addFriend(friend);
        assertFalse(user.getFriends().contains(null));
    }

    @Test
    public void testAddDuplicateFriend() {
        int numOfFriends = user.getFriends().size();
        user.addFriend(friend);
        user.addFriend(friend);
        assertTrue(user.getFriends().size() == numOfFriends + 1);
    }

    @AfterClass
    public static void tearDown() {
        // any tear down methods
    }
}
