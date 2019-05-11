package hackathon.healthyearth;

public class User {
    private String username;
    private String password;
    private int points;
    // TODO add personal data

    private List<Challenge> currentChallenges;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;

        //create and assign random challenges
        this.currentChallenges = getNewChallenges();

    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

    public void setCurrentChallenges(List<Challenge> newChallenges) {
      currentChallenges = newChallenges;
    }

}
