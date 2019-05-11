package hackathon.healthyearth;

import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;

public class HealthyEarth {
    public static void main(String[] args) {
        UserController userController = new UserController();
        AuthController authController = new AuthController(userController);

        // TODO
        userController.addUser("Günther", new User("Günther", "password123"));


        path("/", () -> {
            get(Path.OVERVIEW, userController.showOverview);
            get(Path.LOGIN, authController.handleLoginGet);
            post(Path.LOGIN, authController.handleLoginPost);
        });
    }
}
