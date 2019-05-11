package hackathon.healthyearth;

import hackathon.healthyearth.data.Challenge;
import hackathon.healthyearth.data.ChallengeDAO;
import spark.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserController {
    private Map<String, User> users = new HashMap<>();
    private ChallengeDAO challengeDAO;
    public UserController(ChallengeDAO challengeDAO) {
        this.challengeDAO = challengeDAO;
    }

    public Route showHome = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.HOME);
    };

    public Route showLeaderboard = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.LEADERBOARD);
    };

    public Route showWeeklyCheckIn = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.WEEKLY_CHECK_IN);
    };

    public Route showSettings = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.SETTINGS);
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

    public void updateChallenges(User user) {
        //pick 4 random challenges from challenge pool
        LinkedList<Challenge> challengePool = new LinkedList<>(this.challengeDAO.findAll());
        Collections.shuffle(challengePool);
        List<Challenge> pickedChallenges = new ArrayList<>();
        while (pickedChallenges.size() < 4) {
            pickedChallenges.add(challengePool.pop());
        }
        user.setCurrentChallenges(pickedChallenges);
    }
}
