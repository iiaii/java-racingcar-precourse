package racinggame.domain;

import racinggame.exception.InvalidPositionValueException;

public class Position {

    private static final int MIN_POSITION = 0;

    private final int position;

    public Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    public int intValue() {
        return position;
    }

    private void validatePosition(final int position) {
        if (!isValidPosition(position)) {
            throw new InvalidPositionValueException(MIN_POSITION, position);
        }
    }

    private boolean isValidPosition(final int position) {
        return position >= MIN_POSITION;
    }
}
