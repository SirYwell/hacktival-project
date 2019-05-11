package hackathon.healthyearth;

import java.util.function.Function;

public class LevelInfo {
    private static final Function<Integer, Integer> CALC_LEVEL = i -> i / 100;
    private static final Function<Integer, Integer> CALC_REQUIRED = i -> i * 100 + 100;
    private int level;
    private int required;

    public LevelInfo(int points) {
        this.level = CALC_LEVEL.apply(points);
        this.required = CALC_REQUIRED.apply(level);
    }

    public int getLevel() {
        return level;
    }

    public int getRequired() {
        return required;
    }
}
