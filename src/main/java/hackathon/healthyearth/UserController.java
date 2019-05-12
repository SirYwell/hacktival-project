package hackathon.healthyearth;

import hackathon.healthyearth.data.Challenge;
import hackathon.healthyearth.data.ChallengeDAO;
import hackathon.healthyearth.data.UserDAO;
import spark.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserController {
    private UserDAO userDAO;
    private ChallengeDAO challengeDAO;

    public UserController(UserDAO userDAO, ChallengeDAO challengeDAO) {
        this.userDAO = userDAO;
        this.challengeDAO = challengeDAO;
    }

    public Route showHome = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        User user = userDAO.getUserByName(request.session().attribute("currentUser"));
        if (user != null || (user = userDAO.getUserByName(request.queryParams("username"))) != null) {
            model.put("user", user);
            model.put("levelInfo", new LevelInfo(user.getTotalPoints()));
            model.put("challenges", user.getCurrentChallenges());
        }
        if (request.session().attribute("challengeFinished")) {
            model.put("challengeFinished", true);
        }
        return ViewUtil.render(request, model, Template.HOME);
    };

    public Route showLeaderboard = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        User user = userDAO.getUserByName(request.session().attribute("currentUser"));
        model.put("user", user);
        model.put("pointsLastWeek", user.getPointsSince(LocalDateTime.now().minusWeeks(1)));
        return ViewUtil.render(request, model, Template.LEADERBOARD);
    };

    public Route showWeeklyCheckIn = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", userDAO.getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.WEEKLY_CHECK_IN);
    };

    public Route showSettings = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();
        model.put("user", userDAO.getUserByName(request.session().attribute("currentUser")));
        return ViewUtil.render(request, model, Template.SETTINGS);
    };

    public final Route finishChallenge = (request, response) -> {
        AuthController.ensureLoggedIn(request, response);
        User user = userDAO.getUserByName(request.session().attribute("currentUser"));
        Optional<Challenge> challenge = challengeDAO.findById(Integer.parseInt(
                request.queryParams("finishedChallengeId")));
        user.finishChallenge(challenge.orElse(null));
        request.session().attribute("challengeFinished", true);
        return showHome.handle(request, response);
    };

    public void updateChallenges(User user) {
        if (!user.getLastLogin().isBefore(LocalDateTime.now().minusWeeks(1))) {
            return;
        }
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
