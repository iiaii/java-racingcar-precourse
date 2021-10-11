package racinggame.view;

import racinggame.dto.WinnerNamesDto;

import java.util.List;
import java.util.StringJoiner;

public class RaceResultConsoleOutput {

    private static final String RACE_RESULT_PREFIX = "최종 우승자는 ";
    private static final String RACE_RESULT_SUFFIX = " 입니다.";
    private static final String DELIMITER = ",";

    public static void printRaceResult(final WinnerNamesDto winnerNamesDto) {
        System.out.println(RACE_RESULT_PREFIX + winnerNames(winnerNamesDto.getWinnerNames()) + RACE_RESULT_SUFFIX);
    }

    private static String winnerNames(final List<String> names) {
        StringJoiner result = new StringJoiner(DELIMITER);
        for (String name : names) {
            result.add(name);
        }
        return result.toString();
    }

}
