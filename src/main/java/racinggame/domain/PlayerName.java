package racinggame.domain;

import racinggame.exception.InvalidNameLengthException;

public class PlayerName {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        validateName(name);
        this.name = name;
    }

    public String name() {
        return name;
    }

    private void validateName(final String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }
    }
}
