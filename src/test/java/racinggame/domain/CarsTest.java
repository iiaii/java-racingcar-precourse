package racinggame.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.exception.NameOverlappedException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 콜렉션 생성 - 중복된 이름이 있는 경우")
    public void 자동차콜렉션생성_중복된이름이있는경우() {
        // given
        List<String> names = Arrays.asList("123", "abc", "abc");

        // when
        ThrowingCallable throwingCallable = () -> new Cars(names);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(NameOverlappedException.class);
    }

    @Test
    @DisplayName("자동차 모든 이름 확인")
    public void 자동차_모든_이름_확인() {
        // given
        List<String> names = Arrays.asList("123", "abc");
        Cars cars = new Cars(names);

        // when
        List<CarName> carNames = cars.carNames();

        // then
        assertThat(carNames)
                .containsExactly(new CarName("123"), new CarName("abc"));
    }

    @Test
    @DisplayName("자동차 모든 차량 이동 - 모두 움직인 경우")
    public void 자동차모든차량이동_모두움직인경우() {
        // given
        Cars cars = new Cars(Arrays.asList("123", "abc"));
        int expectedSize = 2;
        List<Position> expectedPositions = Arrays.asList(new Position(1), new Position(1));

        // when
        List<Position> movedPositions = cars.moveCars(() -> true);

        // then
        assertThat(movedPositions.size()).isEqualTo(expectedSize);
        assertThat(movedPositions).isEqualTo(expectedPositions);
    }

    @Test
    @DisplayName("우승 차량 이름 반환")
    public void 우승차량이름반환() {
        // given
        Cars cars = new Cars(Arrays.asList("123", "abc"));

        // when
        cars.moveCars(() -> true);
        List<CarName> carNames = cars.winnerCarNames();


        // then
        assertThat(carNames).containsExactly(new CarName("123"), new CarName("abc"));
    }

}