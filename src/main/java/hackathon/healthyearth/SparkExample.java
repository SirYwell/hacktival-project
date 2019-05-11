package hackathon.healthyearth;

import static spark.Spark.get;

public class SparkExample {

    public static void main(String[] args) {
        get("/", (request, response) -> "Hello World");
        get("/:param", ((request, response) -> "Your parameter: " + request.params("param")));
    }
}
