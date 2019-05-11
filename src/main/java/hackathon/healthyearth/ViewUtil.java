package hackathon.healthyearth;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

public class ViewUtil {
    private static FreeMarkerEngine freeMarkerEngine;

    static {
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(new ClassTemplateLoader(HealthyEarth.class, "/"));
        freeMarkerEngine = new FreeMarkerEngine(configuration);
    }

    public static String render(Request request, Map<String, Object> model, String templatePath) {
        model.put("currentUser", request.session().attribute("currentUser"));
        return freeMarkerEngine.render(new ModelAndView(model, templatePath));
    }
}
