package school.lesson11.task2;

import org.junit.*;
import school.habrStructure.HabrProfileSettingsPage;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case2 и Test-case4 находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task2HabrTest extends Task2HabrTestCofig {

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrMainPage.findSmthFromSearchRaw("Selenium IDE");
        habrMainPage.addCommentToBookmarks(habrMainPage.getLINK_COMMENT());
    }

    @Test
    public void testCase4() {
        LOGGER.info("Осуществлена загрузка сайта");
        HabrProfileSettingsPage settingsPage = new HabrProfileSettingsPage(driver);
        habrMainPage.changeAndSaveProfileSettings(settingsPage.getNAME(), settingsPage.getGENDER(), settingsPage.getCOUNTY(), settingsPage.getREGION(), settingsPage.getCITY());
        habrMainPage.logOut();
    }
}
