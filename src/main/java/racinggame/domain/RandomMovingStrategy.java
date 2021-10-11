package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int BASIS = 3;

    @Override
    public boolean movable() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) > BASIS;
    }

}
