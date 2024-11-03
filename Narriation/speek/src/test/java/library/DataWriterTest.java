package library;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.junit.After;
import org.junit.Before;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
import org.junit.Test;

import com.narriation.DataLoader;
import com.narriation.DataWriter;
import com.narriation.User;
import com.narriation.UserList;

public class DataWriterTest {

    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @Test
    public void testTesting() {
        assertTrue(true);
    }

}
