package hackathon.healthyearth.data;

public class Challenge {
    private static int counter = 0;
    private transient int id;
    private String facts;
    private String text;
    private int points;

    public Challenge() {
        this.id = counter++;
    }

    public Challenge(int id, String facts, String text, int points) {
        this.id = id;
        this.facts = facts;
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

    public String getFacts() {
        return facts;
    }
}
