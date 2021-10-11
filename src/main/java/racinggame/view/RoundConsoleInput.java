package racinggame.view;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundConsoleInput {

    private static final String ROUND_QUESTION = "시도할 회수는 몇회인가요?";

    public static String askCarNames() {
        System.out.println(ROUND_QUESTION);
        return Console.readLine();
    }

}
