package hackathon.healthyearth;

import hackathon.healthyearth.data.Answer;
import hackathon.healthyearth.data.Challenge;
import hackathon.healthyearth.data.Question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private Map<LocalDateTime, Integer> receivedPoints;
    private LocalDateTime lastLogin = LocalDateTime.now().minusWeeks(1);
    // TODO add personal data

    private List<Challenge> currentChallenges;
    private List<Question> questions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.receivedPoints = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    public List<Challenge> getCurrentChallenges() {
        return currentChallenges;
    }

    public void setCurrentChallenges(List<Challenge> newChallenges) {
      currentChallenges = newChallenges;
    }

    public void finishChallenge(Challenge challenge) {
        currentChallenges.remove(challenge);
        receivedPoints.put(LocalDateTime.now(), challenge.getPoints());
    }

    public List<Question> getCurrentQuestions() {
        return questions != null ? questions : (questions = new ArrayList<>());
    }

    public void setCurrentQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void answerQuestion(Question question, Answer answer) {
        questions.remove(question);
        receivedPoints.put(LocalDateTime.now(), answer.getPoints());
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public Map<LocalDateTime, Integer> getReceivedPoints() {
        return receivedPoints;
    }

    public int getPointsSince(LocalDateTime when) {
        return receivedPoints.entrySet().stream()
                .filter(entry -> entry.getKey().isAfter(when))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int getTotalPoints() {
        return getPointsSince(LocalDateTime.MIN);
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
