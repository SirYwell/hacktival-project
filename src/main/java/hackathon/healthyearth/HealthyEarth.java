package hackathon.healthyearth;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class HealthyEarth {
    public static void main(String[] args) {
        UserController userController = new UserController();
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
}
