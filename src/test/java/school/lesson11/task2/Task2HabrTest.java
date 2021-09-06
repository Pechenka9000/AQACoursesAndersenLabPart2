package school.lesson11.task2;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import school.habrStructure.HabrProfileSettingsPage;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case2 и Test-case4 находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task2HabrTest extends Task2HabrTestCofig {

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrMainPage.startSignIn();
        LOGGER.info("Верификация текста ('Вход') в заголовке - "+ driver.findElement(habrLoginPage.getLOGIN_TITLE()).getText().equalsIgnoreCase("Вход"));
        habrMainPage = habrLoginPage.loginValidUser(habrLoginPage.getEMAIL(), habrLoginPage.getPASSWORD());
        LOGGER.info("Осуществлена загрузка сайта");
        habrMainPage.findSmthFromSearchRaw("Selenium IDE");
        habrMainPage.addCommentToBookmarks(habrMainPage.getLINK_COMMENT());
        Assertions.assertEquals(LINK_TITLE_TEXT, driver.findElement(habrMainPage.getLINK_POST_TITLE()).getText());
    }

    @Test
    public void testCase4() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrMainPage.startSignIn();
        Assertions.assertEquals("Вход", driver.findElement(habrLoginPage.getLOGIN_TITLE()).getText());
        LOGGER.info("Верификация текста ('Вход') в заголовке - "+ driver.findElement(habrLoginPage.getLOGIN_TITLE()).getText().equalsIgnoreCase("Вход"));
        habrMainPage = habrLoginPage.loginValidUser(habrLoginPage.getEMAIL(), habrLoginPage.getPASSWORD());
        LOGGER.info("Осуществлена загрузка сайта");
        HabrProfileSettingsPage settingsPage = new HabrProfileSettingsPage(driver);
        habrMainPage.changeAndSaveProfileSettings(settingsPage.getNAME(), settingsPage.getGENDER(), settingsPage.getCOUNTY(), settingsPage.getREGION(), settingsPage.getCITY());
        settingsPage = new HabrProfileSettingsPage(driver);
        HabrProfileSettingsPage finalSettingsPage = settingsPage;
        Assertions.assertAll(
            () -> assertEquals("Мужской", driver.findElement(By.xpath(String.format(finalSettingsPage.getXPATH_SELECTOR_FINDER(), finalSettingsPage.getGENDER()))).getText()),
            () -> assertEquals("Беларусь", driver.findElement(By.xpath(String.format(finalSettingsPage.getXPATH_SELECTOR_FINDER(), finalSettingsPage.getCOUNTY()))).getText()),
            () -> assertEquals("Витебская обл.", driver.findElement(By.xpath(String.format(finalSettingsPage.getXPATH_SELECTOR_FINDER(), finalSettingsPage.getREGION()))).getText()),
            () -> assertEquals("Полоцк", driver.findElement(By.xpath(String.format(finalSettingsPage.getXPATH_SELECTOR_FINDER(), finalSettingsPage.getCITY()))).getText())
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        habrMainPage.logOut();
        LOGGER.info("Осуществлен выход из профиля");
    }
}
