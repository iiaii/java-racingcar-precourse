package racinggame.util;

import racinggame.exception.NotNumberException;

import java.util.regex.Pattern;

public class NumberUtils {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static Integer parseIntOrThrow(final String number) {
        requireNumber(number);
        return Integer.parseInt(number);
    }

    private static void requireNumber(final String number) {
        if (!isNumber(number)) {
            throw new NotNumberException(number);
        }
    }

    private static boolean isNumber(final String number) {
        return NUMBER_PATTERN.matcher(number).matches();
    }

}
