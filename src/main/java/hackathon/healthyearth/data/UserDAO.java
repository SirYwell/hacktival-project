package hackathon.healthyearth.data;

import hackathon.healthyearth.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAO {
    private List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public boolean hasMatching(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.passwordMatches(password)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(String username, User user) {
        users.add(user);
    }

    public User getUserByName(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    public void insertAll(Collection<User> list) {
        users.addAll(list);
    }
}
