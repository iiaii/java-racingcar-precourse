package racinggame.exception;

public class InvalidRoundCountException extends RepeatableException {

    private static final long serialVersionUID = 1L;
    private static final String INVALID_ROUND_COUNT = "라운드 수는 1이상의 값이어야 합니다 (현재값: %d)";

    public InvalidRoundCountException(final int count) {
        super(String.format(INVALID_ROUND_COUNT, count));
    }

}
