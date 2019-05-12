package hackathon.healthyearth.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    public Optional<Question> findById(int id) {
        for (Question question : questions) {
            if (question.getId() == id) {
                return Optional.of(question);
            }
        }
        return Optional.empty();
    }
}
