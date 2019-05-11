package hackathon.healthyearth.data;

public class Answer {
    private String text;
    private int points;

    public Answer(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }
}
