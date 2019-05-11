package hackathon.healthyearth;

public class User {
    private String username;
    private String password;
    private int points;
    // TODO add personal data

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.points = 0;
    }

    public boolean passwordMatches(String password) {
        return this.password.equals(password);
    }

}
