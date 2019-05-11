package hackathon.healthyearth;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class AuthController {
    private static final String CURRENT_USER_ATTR = "currentUser";
    private static final String LOGIN_REDIRECT_ATTR = "loginRedirect";
    private UserController userController;

    public AuthController(UserController userController) {
        this.userController = userController;
    }

    public final Route handleLoginPost = (request, response) -> {
        String username = request.queryParams("username");
        String password = request.queryParams("password");
        Map<String, Object> model = new HashMap<>();
        if (!userController.authenticate(username, password)) {
            model.put("authSucceeded", false);
            model.put("error", "Wrong auth data.");
            return ViewUtil.render(request, model, Template.LOGIN);
        }
        model.put("authSucceeded", true);
        request.session().attribute(CURRENT_USER_ATTR, username);
        String redirect = request.session().attribute(LOGIN_REDIRECT_ATTR);
        if (redirect == null) {
            response.redirect(Path.OVERVIEW);
            return ViewUtil.render(request, model, Template.LEADERBOARD);
        }
        response.redirect(redirect);
        return null;
    };

    public final Route handleLoginGet = (request, response) -> {
        if (request.session().attribute(CURRENT_USER_ATTR) != null) {
            response.redirect(Template.LEADERBOARD);
            return null;
        }
        return ViewUtil.render(request, new HashMap<>(), Template.LOGIN);
    };

    public static void ensureLoggedIn(Request request, Response response) {
        if (request.session().attribute(CURRENT_USER_ATTR) == null) {
            request.session().attribute(LOGIN_REDIRECT_ATTR, request.pathInfo());
            response.redirect(Path.LOGIN);
        }
    }
}
