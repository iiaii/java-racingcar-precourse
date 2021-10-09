package racinggame.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.InvalidPositionValueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositionTest {

    @Test
    @DisplayName("포지션 생성 - 0 미만의 값 입력")
    public void 포지션생성_0미만의값() {
        // given
        int position = -1;

        // when
        ThrowingCallable throwingCallable = () -> new Position(position);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidPositionValueException.class);
    }

    @Test
    @DisplayName("포지션 생성 - 0이상의 값 입력")
    public void 포지션생성_0이상의값() {
        // given
        int positionNumber = 0;

        // when
        Position position = new Position(positionNumber);

        // then
        assertThat(position.intValue()).isEqualTo(positionNumber);
    }

}