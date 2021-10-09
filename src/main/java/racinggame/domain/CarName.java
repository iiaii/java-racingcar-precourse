package racinggame.domain;

import racinggame.exception.InvalidCarNameLengthException;

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
}
