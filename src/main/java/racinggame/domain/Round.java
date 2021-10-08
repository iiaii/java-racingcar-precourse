package racinggame.domain;

import racinggame.exception.InvalidRoundCountException;

public class Round {

    private static final int MIN_COUNT = 1;

    private final int count;

    public Round(final int count) {
        validateCount(count);
        this.count = count;
    }

    public int count() {
        return count;
    }

    private void validateCount(final int count) {
        if (count < MIN_COUNT) {
            throw new InvalidRoundCountException(count);
        }
    }
}
