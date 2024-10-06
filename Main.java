import java.util.ArrayList;
public class Main {
    public ArrayList<User> users = FileReader.getUsers();
    for(int i = 0; i < users.size(); i++){
        System.out.println(users);
    }

}
