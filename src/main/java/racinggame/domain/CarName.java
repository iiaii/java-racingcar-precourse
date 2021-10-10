package racinggame.domain;

import racinggame.exception.InvalidCarNameLengthException;

import java.util.Objects;

public class CarName {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validateCarName(name);
        this.name = name;
    }

    public String name() {
        return name;
    }

    private void validateCarName(final String name) {
        if (!isValidCarNameLength(name)) {
            throw new InvalidCarNameLengthException(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }
    }

    private boolean isValidCarNameLength(final String name) {
        return name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
