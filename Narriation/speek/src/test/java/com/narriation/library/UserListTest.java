package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.narriation.Avatar;
import com.narriation.DataLoader;
import com.narriation.Language;
import com.narriation.User;
import com.narriation.UserList;
import com.narriation.UserProgress;

public class UserListTest {
    private ArrayList<Language> languages = DataLoader.getLanguages();
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();
    private User user = new User(UUID.randomUUID(), "Jhon", "Doe", "jDoe",
            "do", "jdoe@gmail.com",
            new Date(), new Avatar(), 0, new ArrayList<UserProgress>());
    private User friend = new User(UUID.randomUUID(), "Jhon", "smith", "jSmith",
            "smith", "jsmith@gmail.com",
            new Date(), new Avatar(), 0, new ArrayList<UserProgress>());

    @BeforeClass
    public static void setup() {
        UserList userList = UserList.getInstance();
        userList.getUsers().clear();
    }

    @Test
    public void TestTesting() {
        assertTrue(true);
    }

    @Test
    public void testAddUser() {
        if (!users.contains(user)) {
            userList.addUser(user);
            assertTrue(users.contains(user));
        } else {
            assertTrue(false);
        }
    }

}
