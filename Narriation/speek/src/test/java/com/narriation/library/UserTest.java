package com.narriation.library;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.narriation.User;
import com.narriation.UserList;

import org.junit.BeforeClass;
import org.junit.AfterClass;

public class UserTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    @BeforeClass
    public static void setup() {
        // any setup methods
    }

    @Test
    public void isTrue() {
        assertTrue(true);
    }

    @AfterClass
    public static void tearDown() {
        // any tear down methods
    }
}
