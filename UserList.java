/**
 * @author kinsawills
 */
import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {

    }

    public static UserList getInstance() {

    }

    public boolean addUser(String firstName, String lastName, String username, String emailAddress, int[] birthday, Avatar avatar) {
        
    }

    public User getUser(String username) {
        for (User user : users) {
            if(user.getUsername().equals(username))
                return user;
        }
    }

    public boolean editUser(String firstName, String lastName, String username, String emailAddress, int[] birthday, Avatar avatar) {

    }

    public boolean saveUsers() {
        
    }
}
