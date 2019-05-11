package hackathon.healthyearth;

import hackathon.healthyearth.data.ChallengeDAO;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> users = new HashMap<>();
    private ChallengeDAO challengeDAO;

    public UserController(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    public final Route showOverview = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.HOME);
    };

    public final Route showHome = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("challenges", challengeDAO.findAll());
        return ViewUtil.render(request, model, Template.HOME);
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
