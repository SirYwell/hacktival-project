package hackathon.healthyearth.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ChallengeDAO {
    private List<Challenge> challenges;

    public ChallengeDAO() {
        this.challenges = new ArrayList<>();
    }

    public List<Challenge> findAll() {
        return Collections.unmodifiableList(challenges);
    }

    public Optional<Challenge> findById(int id) {
        for (Challenge challenge : challenges) {
            if (challenge.getId() == id) {
                return Optional.of(challenge);
            }
        }
        return Optional.empty();
    }

    public boolean insertAll(Collection<Challenge> challenges) {
        return this.challenges.addAll(challenges);
    }
}
