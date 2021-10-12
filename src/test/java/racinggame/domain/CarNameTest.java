package racinggame.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.InvalidCarNameLengthException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNameTest {

    @Test
    @DisplayName("플레이어 이름 생성 - 공백인 경우")
    public void 플레이어이름생성_공백() {
        // given
        String name = " ";

        // when
        ThrowingCallable throwingCallable = () -> new CarName(name);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidCarNameLengthException.class);
    }

    @Test
    @DisplayName("플레이어 이름 생성 - 6글자 이상")
    public void 플레이어이름생성_6글자이상() {
        // given
        String name = "abcdef";

        // when
        ThrowingCallable throwingCallable = () -> new CarName(name);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(InvalidCarNameLengthException.class);
    }

    @Test
    @DisplayName("플레이어 이름 생성 - 5글자 이하")
    public void 플레이어이름생성_5글자이하() {
        // given
        String name = "abcde";

        // when
        CarName carName = new CarName(name);

        // then
        assertThat(carName).isEqualTo(new CarName(name));
        assertThat(carName.name()).isEqualTo(name);
    }

}