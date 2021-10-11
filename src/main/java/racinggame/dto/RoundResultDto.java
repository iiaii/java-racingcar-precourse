package racinggame.dto;

import racinggame.domain.CarName;
import racinggame.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class RoundResultDto {

    private final List<String> names;
    private final List<List<Integer>> roundPositions;

    public RoundResultDto(final List<CarName> carNames, final List<List<Position>> roundPositions) {
        this.names = toStringNames(carNames);
        this.roundPositions = toIntRoundPositions(roundPositions);
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<Integer>> getRoundPositions() {
        return roundPositions;
    }

    private List<String> toStringNames(final List<CarName> carNames) {
        List<String> result = new ArrayList<>();
        for (CarName carName : carNames) {
            result.add(carName.name());
        }
        return result;
    }

    private List<List<Integer>> toIntRoundPositions(final List<List<Position>> roundPositions) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Position> roundPosition : roundPositions) {
            result.add(toIntPositions(roundPosition));
        }
        return result;
    }

    private List<Integer> toIntPositions(final List<Position> positions) {
        List<Integer> result = new ArrayList<>();
        for (Position position : positions) {
            result.add(position.intValue());
        }
        return result;
    }

}
