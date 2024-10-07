import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();
        DataWriter.saveUsers(users);       
    }

}
