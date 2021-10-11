package racinggame.domain;

import racinggame.exception.NameOverlappedException;

import java.util.*;

public class Cars {

    private final List<Car> cars;
    private Position bestPosition;

    public Cars(final List<String> names) {
        validateNames(names);
        this.cars = createCars(names);
    }

    public List<CarName> carNames() {
        List<CarName> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.carName());
        }
        return carNames;
    }

    public List<Position> moveCars(final MovingStrategy movingStrategy) {
        List<Position> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(movingStrategy));
        }
        findBestPosition(positions);
        return positions;
    }

    public List<CarName> winnerCarNames() {
        List<CarName> winnerCarNames = new ArrayList<>();
        for (Car car : cars) {
            addCarNameIfWinner(winnerCarNames, car);
        }
        return winnerCarNames;
    }

    private void addCarNameIfWinner(final List<CarName> winnerCarNames, final Car car) {
        if (car.isSamePosition(bestPosition)) {
            winnerCarNames.add(car.carName());
        }
    }

    private void findBestPosition(final List<Position> positions) {
        bestPosition = Collections.max(positions);
    }

    private List<Car> createCars(final List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void validateNames(final List<String> names) {
        if (hasOverlappedName(names)) {
            throw new NameOverlappedException();
        }
    }

    private boolean hasOverlappedName(final List<String> names) {
        return names.size() != new HashSet<>(names).size();
    }
}
