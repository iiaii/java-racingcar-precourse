package racinggame.view;

import racinggame.dto.RoundResultDto;

import java.util.List;

public class RoundResultConsoleOutput {

    private static final String ROUND_RESULT_HEAD = "\n실행결과";
    private static final String ROUND_RESULT = "%s : %s";
    private static final String MOVED_SIGN = "-";

    public static void printRoundResults(final RoundResultDto roundResultDto) {
        System.out.println(ROUND_RESULT_HEAD);
        printAllRound(roundResultDto);
    }

    private static void printAllRound(final RoundResultDto roundResultDto) {
        for (List<Integer> roundPosition : roundResultDto.getRoundPositions()) {
            printRoundResult(roundResultDto.getNames(), roundPosition);
            System.out.println();
        }
    }

    private static void printRoundResult(final List<String> names, final List<Integer> positions) {
        for (int i = 0; i < names.size(); i++) {
            System.out.println(roundResult(names.get(i), positions.get(i)));
        }
    }

    private static String roundResult(final String name, final int count) {
        return String.format(ROUND_RESULT, name, repeatMovedSign(count));
    }

    private static String repeatMovedSign(final int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(MOVED_SIGN);
        }
        return result.toString();
    }

}
