package hackathon.healthyearth;

import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> users = new HashMap<>();

    public Route showOverview = (request, response) -> {
            AuthController.ensureLoggedIn(request, response);
            Map<String, Object> model = new HashMap<>();
            model.put("user", getUserByName(request.session().attribute("currentUser")));
            return ViewUtil.render(request, model, Template.OVERVIEW);
        };

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).passwordMatches(password);
    }

    public void addUser(String username, User user) {
        users.put(username, user);
    }

    public User getUserByName(String username) {
        return users.get(username);
    }
}
