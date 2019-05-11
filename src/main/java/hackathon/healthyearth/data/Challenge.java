package hackathon.healthyearth.data;

public class Challenge {
    private static int counter = 0;
    private transient int id;
    private String fact;
    private String text;
    private int points;

    public Challenge() {
        this.id = counter++;
    }

    public Challenge(int id, String fact, String text, int points) {
        this.id = id;
        this.fact = fact;
        this.text = text;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public String getFact() {
        return fact;
    }
}
