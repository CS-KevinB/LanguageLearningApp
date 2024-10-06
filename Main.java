import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileReader file = new FileReader();
        ArrayList<User> users = file.getUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users);
        }
    }

}
