package racinggame.dto;

import racinggame.domain.CarName;

import java.util.ArrayList;
import java.util.List;

public class WinnerNamesDto {

    private final List<String> winnerNames;

    public WinnerNamesDto(final List<CarName> winnerCarNames) {
        this.winnerNames = toStringNames(winnerCarNames);
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    private List<String> toStringNames(final List<CarName> carNames) {
        List<String> result = new ArrayList<>();
        for (CarName carName : carNames) {
            result.add(carName.name());
        }
        return result;
    }

}
