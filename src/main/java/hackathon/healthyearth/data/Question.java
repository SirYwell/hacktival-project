package hackathon.healthyearth.data;

import java.util.List;

public class Question {
    private static int counter = 0;
    private int id;
    private String text;
    private List<Answer> answers;

    public Question() {
        this.id = counter++;
    }

    public Question(String text, List<Answer> answers) {
        super();
        this.text = text;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getId() {
        return id;
    }
}
