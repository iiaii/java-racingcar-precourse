package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Position;
import racinggame.domain.RandomMovingStrategy;
import racinggame.domain.Round;
import racinggame.dto.RoundResultDto;
import racinggame.dto.WinnerNamesDto;
import racinggame.exception.RepeatableException;
import racinggame.view.*;

import java.util.List;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        Cars cars = repeatIfError(() -> new Cars(CarNameConsoleInput.askCarNames())) ;
        Round round = repeatIfError(() -> new Round(RoundConsoleInput.askCarNames()));
        List<List<Position>> roundPositions = round.repeat(() -> cars.moveCars(new RandomMovingStrategy()));
        RoundResultConsoleOutput.printRoundResults(new RoundResultDto(cars.carNames(), roundPositions));
        RaceResultConsoleOutput.printRaceResult(new WinnerNamesDto(cars.winnerCarNames()));
    }

    private static <T> T repeatIfError(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch(RepeatableException e) {
            ErrorMessageConsoleOutput.print(e.getMessage());
            return repeatIfError(supplier);
        }
    }

}
