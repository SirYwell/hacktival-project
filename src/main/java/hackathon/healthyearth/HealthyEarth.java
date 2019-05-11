package hackathon.healthyearth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hackathon.healthyearth.data.Challenge;
import hackathon.healthyearth.data.ChallengeDAO;

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
        UserController userController = new UserController(loadChallenges());
        AuthController authController = new AuthController(userController);

        staticFileLocation("/");

        // TODO
        userController.addUser("Günther", new User("Günther", "password123"));


        path("/", () -> {
            get(Path.HOME, userController.showHome);
            get(Path.LEADERBOARD, userController.showLeaderboard);
            get(Path.WEEKLY_CHECK_IN, userController.showWeeklyCheckIn);
            get(Path.SETTINGS, userController.showSettings);
            get(Path.LOGIN, authController.handleLoginGet);
            post(Path.LOGIN, authController.handleLoginPost);
        });
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
}
