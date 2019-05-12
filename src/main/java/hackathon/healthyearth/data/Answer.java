package hackathon.healthyearth.data;

public class Answer {
    private static int counter;
    private int id;
    private String text;
    private int points;

    public Answer() {
        this.id = counter++;
    }

    public Answer(String text, int points) {
        super();
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public int getId() {
        return id;
    }
}
