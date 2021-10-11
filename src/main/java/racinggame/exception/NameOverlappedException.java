package racinggame.exception;

public class NameOverlappedException extends RepeatableException {

    private static final long serialVersionUID = 1L;
    private static final String NAME_OVERLAPPED = "주어진 이름들 중에서 서로 중복된 이름이 존재합니다";

    public NameOverlappedException() {
        super(NAME_OVERLAPPED);
    }

}
