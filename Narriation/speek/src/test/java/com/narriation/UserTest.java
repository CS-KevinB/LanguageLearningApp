package com.narriation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test; // TODO make sure this works

public class UserTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    @BeforeClass
    public void setup() {
        // any setup methods
    }

    @Test
    public void isTrue() {
        assertTrue(false);
    }

    @AfterClass
    public void tearDown() {
        // any tear down methods
    }
}
