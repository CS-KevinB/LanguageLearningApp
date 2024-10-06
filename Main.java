import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

}
