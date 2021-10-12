package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 공동_우승() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : -", "최종 우승자는 pobi,woni 입니다.");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 공백_이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi, ,java");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 중복된_이름이_존재하는_경우_예외처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 라운드_입력_숫자가_아닌경우_예외처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "a");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 라운드_입력_0이하의수_예외처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "0");
            verify(ERROR_MESSAGE);
        });
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
