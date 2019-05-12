package hackathon.healthyearth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hackathon.healthyearth.data.Challenge;
import hackathon.healthyearth.data.ChallengeDAO;
import hackathon.healthyearth.data.Question;
import hackathon.healthyearth.data.QuestionDAO;
import hackathon.healthyearth.data.UserDAO;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class HealthyEarth {
    public static void main(String[] args) {
        UserDAO userDAO = loadUsers();
        QuestionDAO questionDAO = loadQuestions();
        UserController userController = new UserController(userDAO, loadChallenges(), questionDAO);
        AuthController authController = new AuthController(userController, userDAO);

        staticFileLocation("/");

        path("/", () -> {
            get(Path.HOME, userController.showHome);
            get(Path.LEADERBOARD, userController.showLeaderboard);
            get(Path.WEEKLY_CHECK_IN, userController.showWeeklyCheckIn);
            get(Path.SETTINGS, userController.showSettings);
            get(Path.LOGIN, authController.handleLoginGet);

            post(Path.HOME, userController.finishChallenge);
            post(Path.WEEKLY_CHECK_IN, userController.answerQuestion);
            post(Path.LOGIN, authController.handleLoginPost);
        });
    }

    private static QuestionDAO loadQuestions() {
        QuestionDAO dao = new QuestionDAO();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Question>>(){}.getType();
        InputStream stream = HealthyEarth.class.getResourceAsStream("/data/weeklyQuestions.json");
        List<Question> list = gson.fromJson(new InputStreamReader(stream), type);
        dao.insertAll(list);
        return dao;
    }

    private static ChallengeDAO loadChallenges() {
        ChallengeDAO dao = new ChallengeDAO();
        Gson gson = new Gson();
        Type type = new TypeToken<List<Challenge>>(){}.getType();
        InputStream stream = HealthyEarth.class.getResourceAsStream("/data/weeklyChallenges.json");
        List<Challenge> list = gson.fromJson(new InputStreamReader(stream), type);
        dao.insertAll(list);
        return dao;
    }

    private static UserDAO loadUsers() {
        UserDAO dao = new UserDAO();
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>(){}.getType();
        InputStream stream = HealthyEarth.class.getResourceAsStream("/data/users.json");
        List<User> list = gson.fromJson(new InputStreamReader(stream), type);
        dao.insertAll(list);
        return dao;
    }
}
