/**
 * @author kinsawills
 */
import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    private UserList() {
        userList = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if(userList == null)
            userList = new UserList();
        return userList;
    }

    public boolean addUser(String firstName, String lastName, String username, String emailAddress, int[] birthday, Avatar avatar) {
        
    }

    public User getUser(String username) {
        for (User user : users) {
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    public boolean editUser(String firstName, String lastName, String username, String emailAddress, int[] birthday, Avatar avatar) {

    }

    public boolean saveUsers() {
        
    }
}
