package racinggame.exception;

public class InvalidNameLengthException extends RepeatableException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_NAME_LENGTH = "이름의 길이는 %d ~ %d 사이의 값이어야 합니다";

    public InvalidNameLengthException(final int min, final int max) {
        super(String.format(INVALID_NAME_LENGTH, min, max));
    }

}
