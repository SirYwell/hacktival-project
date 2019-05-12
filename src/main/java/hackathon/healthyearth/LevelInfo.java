package hackathon.healthyearth;

public class LevelInfo {
    private int level;
    private int required;
    private int current;

    public LevelInfo(int points) {
        int level = 1;
        while (points > 0) {
            this.current = points;
            points -= level * 100;
            level++;
        }
        if (level > 1) {
            level--;
        }
        this.level = level;
        this.required = level * 100;
    }

    public int getLevel() {
        return level;
    }

    public int getRequired() {
        return required;
    }

    public int getCurrent() {
        return current;
    }

    public int getPercentage() {
        return current * 100 / required;
    }
}
