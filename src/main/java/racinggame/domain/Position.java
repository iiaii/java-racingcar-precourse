package racinggame.domain;

import racinggame.exception.InvalidPositionValueException;

import java.util.Objects;

public class Position {

    private static final int MIN_POSITION = 0;

    private final int position;

    public Position() {
        this(MIN_POSITION);
    }

    public Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    public Position add(final Position position) {
        return new Position(this.position + position.position);
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
