package com.narriation.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.narriation.DataWriter;
import com.narriation.Facade;
import com.narriation.Language;
import com.narriation.LanguageList;
import com.narriation.User;
import com.narriation.UserList;
import com.narriation.DataLoader;

public class DataWriterTest {

    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @Test
    public void testTesting() {
        assertTrue(true);
    }

    @Before
    public void setup() {
        UserList.getInstance().getUsers();
        userList.clear();
        DataWriter.saveUsers(userList);
    }

    @Test
    public void testWritingZeroUsers() {
        assertEquals(0, userList.size());
    }

    @Test
    public void testWritingFiveUsers() {
        userList.add(new User("asmith", "Amy", "Smith", 19, "803-454-3344"));
        userList.add(new User("bsmith", "Amy", "Smith", 19, "803-454-3344"));
        userList.add(new User("csmith", "Amy", "Smith", 19, "803-454-3344"));
        userList.add(new User("dsmith", "Amy", "Smith", 19, "803-454-3344"));
        userList.add(new User("esmith", "Amy", "Smith", 19, "803-454-3344"));
        DataWriter.saveUsers(userList);
        assertEquals("esmith", DataLoader.getUsers().get(4).getUsername());
    }

    @Test
    public void testWritingEmptyUser() {
        userList.add(new User("", "", "", 0, ""));
        DataWriter.saveUsers(userList);
        assertEquals("", DataLoader.getUsers().get(0).getUsername());
    }

    @Test
    public void testWritingNullUser() {
        userList.add(new User(null, "", "", 0, ""));
        DataWriter.saveUsers(userList);
        assertEquals(null, DataLoader.getUsers().get(0).getUsername());
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers();
        userList.clear();
        DataWriter.saveUsers(userList);
    }

}
