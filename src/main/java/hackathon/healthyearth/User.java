package hackathon.healthyearth;

import hackathon.healthyearth.data.Challenge;

import java.time.LocalDateTime;
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

    public void setCurrentChallenges(List<Challenge> newChallenges) {
      currentChallenges = newChallenges;
    }

    public void finishChallenge(Challenge challenge) {
        currentChallenges.remove(challenge);
        receivedPoints.put(LocalDateTime.now(), challenge.getPoints());
    }

    public List<Challenge> getCurrentChallenges() {
        return currentChallenges;
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
}
