package racinggame.exception;

public class InvalidPositionValueException extends RepeatableException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_POSITION_VALUE = "위치값은 %d 이상의 값이어야 합니다 (현재값: %d)";

    public InvalidPositionValueException(final int min, final int current) {
        super(String.format(INVALID_POSITION_VALUE, min, current));
    }

}
