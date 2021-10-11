package racinggame.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.InvalidRoundCountException;

import java.util.List;
import java.util.function.Supplier;

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
    @DisplayName("라운드 반복")
    public void 라운드반복() {
        // given
        Round round = new Round(3);
        Supplier<Boolean> trueFunction = () -> true;
        int expectedSize = 3;

        // when
        List<Boolean> result = round.repeat(trueFunction);

        // then
        assertThat(result.size()).isEqualTo(expectedSize);
        assertThat(result).containsExactly(true, true, true);
    }

}