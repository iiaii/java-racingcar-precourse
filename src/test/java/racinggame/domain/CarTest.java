package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 생성 - 자동차 비교, 현재 위치 0")
    public void 자동차생성() {
        // given
        String name = "abc";
        Position expectedPosition = new Position(0);

        // when
        Car car = new Car(name);
        boolean samePosition = car.isSamePosition(expectedPosition);

        // then
        assertThat(car).isEqualTo(new Car(name));
        assertThat(samePosition).isTrue();
    }

    @Test
    @DisplayName("자동차 이동 - 이동 가능한 경우")
    public void 자동차이동_이동가능한경우() {
        // given
        Car car = new Car("abc");
        Position expectedPosition = new Position(1);

        // when
        Position position = car.move(() -> true);

        // then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("자동차 이동 - 이동 불가능한 경우")
    public void 자동차이동_이동불가능한경우() {
        // given
        Car car = new Car("abc");
        Position expectedPosition = new Position(0);

        // when
        Position position = car.move(() -> false);

        // then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("자동차 위치 비교")
    public void 자동차위치비교() {
        // given
        Car car = new Car("abc");
        Position expectedPosition = new Position(0);
        Position notExpectedPosition = new Position(1);

        // when
        boolean samePosition = car.isSamePosition(expectedPosition);
        boolean differentPosition = car.isSamePosition(notExpectedPosition);

        // then
        assertThat(samePosition).isTrue();
        assertThat(differentPosition).isFalse();
    }

}
