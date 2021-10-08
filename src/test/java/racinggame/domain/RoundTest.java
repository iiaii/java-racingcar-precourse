package racinggame.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.InvalidRoundCountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundTest {

    @Test
    @DisplayName("라운드 생성 - 0이하의 값 입력")
    public void 라운드생성_0이하의값() {
        // given
        int round = 0;

        // when
        ThrowingCallable throwingCallable = () -> new Round(round);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidRoundCountException.class);
    }

    @Test
    @DisplayName("라운드 생성 - 1이상의 값 입력")
    public void 라운드생성_1이상의값() {
        // given
        int roundNumber = 1;

        // when
        Round round = new Round(roundNumber);

        // then
        assertThat(round.count()).isEqualTo(roundNumber);
    }

}