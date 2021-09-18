package school.lesson10.task1;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
@DisplayName("Тестирование метода расчета оставшихся дней до Нового года")
class AppTest {
    private static final long NEW_YEAR_DAYS_EXPECTATION = 122;

    @Test
    @Description("Проверка на соответствие ожидаемого количества дней с реальным")
    void newYearCalculator() {
        Assertions.assertEquals(NEW_YEAR_DAYS_EXPECTATION, App.newYearCalculator(2021, 9, 1));
    }
}