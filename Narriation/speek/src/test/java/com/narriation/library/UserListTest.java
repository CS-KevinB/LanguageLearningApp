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
    private UserList userList;
    private ArrayList<User> users;
    private User user;
    private User friend;

    @Before
    public void setup() {

        userList = UserList.getInstance();
        users = userList.getUsers();
        users.clear();
        user = new User(UUID.randomUUID(), "John", "Doe", "jDoe", "do", "jdoe@gmail.com",
                new Date(), new Avatar("CharacterA", "HatA"), 0, new ArrayList<UserProgress>());

        friend = new User(UUID.randomUUID(), "Jane", "Smith", "jSmith", "smith", "jsmith@gmail.com",
                new Date(), new Avatar("CharacterB", "HatB"), 0, new ArrayList<UserProgress>());
    }

    @Test
    public void TestTesting() {
        assertTrue(true);
    }

    @Test
    public void testAddUser() {

        userList.addUser(user);
        assertTrue(users.contains(user));
    }

}
