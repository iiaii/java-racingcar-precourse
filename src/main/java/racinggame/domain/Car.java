package racinggame.domain;

import java.util.Objects;

public class Car {

    private static final Position MOVING_UNIT = new Position(1);

    private final CarName carName;
    private Position position;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public Position move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.add(MOVING_UNIT);
        }
        return position;
    }

    public boolean isSamePosition(final Position position) {
        return position.equals(this.position);
    }

    public CarName carName() {
        return carName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}
