package racinggame.view;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameConsoleInput {

    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로구분)";
    private static final String DELIMITER = ",";

    public static List<String> askCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return convertToList(Console.readLine());
    }

    private static List<String> convertToList(final String line) {
        return new ArrayList<>(Arrays.asList(line.split(DELIMITER)));
    }

}
