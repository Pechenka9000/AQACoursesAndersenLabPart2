package school.lesson10.task1;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Happy New Year!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(newYearCalculator(2021, 9, 1));
    }

    public static long newYearCalculator(int year, int month, int dayOfMonth) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalDate firstDayOfYear = LocalDate.of(date.getYear() + 1, 1,  1);
        return ChronoUnit.DAYS.between(date, firstDayOfYear);
    }
}
