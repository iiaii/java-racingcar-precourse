package racinggame.domain;

import racinggame.exception.InvalidRoundCountException;
import racinggame.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Round {

    private static final int MIN_COUNT = 1;

    private final int count;

    public Round(final String count) {
        this(NumberUtils.parseIntOrThrow(count));
    }

    public Round(final int count) {
        validateCount(count);
        this.count = count;
    }

    private void validateCount(final int count) {
        if (count < MIN_COUNT) {
            throw new InvalidRoundCountException(count);
        }
    }

    public <T> List<T> repeat(final Supplier<T> supplier) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(supplier.get());
        }
        return result;
    }
}
