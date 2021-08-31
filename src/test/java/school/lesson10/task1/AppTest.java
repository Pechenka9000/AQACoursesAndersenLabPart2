package school.lesson10.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
class AppTest {
    private static final long NEW_YEAR_DAYS_EXPECTATION = 122;

    @Test
    void newYearCalculator() {
        Assertions.assertEquals(NEW_YEAR_DAYS_EXPECTATION, App.newYearCalculator(2021, 9, 1));
    }
}