package hackathon.healthyearth.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionDAO {
    private List<Question> questions;

    public QuestionDAO() {
        this.questions = new ArrayList<>();
    }

    public List<Question> findAll() {
        return questions;
    }

    public boolean insertAll(Collection<Question> questions) {
        return this.questions.addAll(questions);
    }
}
