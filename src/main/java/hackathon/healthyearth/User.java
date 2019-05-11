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
    // TODO add personal data

    private List<Challenge> currentChallenges;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.receivedPoints = new HashMap<>();
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

}
