package school.lesson13.task2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import school.habrStructure.HabrProfileSettingsPage;
import school.lesson13.ConfProperties;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-cases находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task2HabrTest extends Task2HabrTestConfig {

    @Test
    public void testCase1() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrLoginPage = habrMainPage.startSignIn();
        habrLoginPage.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals("Вход", driver.findElement(habrLoginPage.getLOGIN_TITLE()).getText()),
                () -> assertEquals(ConfProperties.getProperty("habrLoginEmail"), driver.findElement(habrLoginPage.getEMAIL_FIELD()).getAttribute("value")),
                () -> assertEquals(ConfProperties.getProperty("habrLoginPassword"), driver.findElement(habrLoginPage.getPASSWORD_FIELD()).getAttribute("value"))
        );
        LOGGER.info("Произведена верификация введенных данных");
        habrLoginPage.clickSignInButton();
        LOGGER.info("Осуществлена загрузка сайта");
        driver.findElement(habrMainPage.getPROFILE_ICON()).click();
        LOGGER.info("Верификация текста ('@pechenka9000') в заголовке профиля - "+ driver.findElement(habrMainPage.getPROFILE_ICON_TITLE()).getText().equalsIgnoreCase("@pechenka9000"));
        Assertions.assertEquals("@pechenka9000", driver.findElement(habrMainPage.getPROFILE_ICON_TITLE()).getText());
    }

    @Test
    public void testCase2() {
        habrMainPage.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        habrMainPage.findSmthFromSearchRaw("Selenium IDE");
        habrMainPage.addCommentToBookmarks(habrMainPage.getLINK_COMMENT());
        LOGGER.info("Верификация заголовка в искомом комментарии " + driver.findElement(habrMainPage.getLINK_POST_TITLE()).getText().equalsIgnoreCase(LINK_TITLE_TEXT));
        Assertions.assertEquals(LINK_TITLE_TEXT, driver.findElement(habrMainPage.getLINK_POST_TITLE()).getText());
    }

    @Test
    public void testCase3() {
        habrMainPage.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        habrPublicationCreator = habrMainPage.createNewPublication();
        habrPublicationCreator.createPublicationStep1("Моя будущая публикация", "текст внутри публикации");
        LOGGER.info("Введен заголовок публикации");
        Assertions.assertTrue(driver.findElement(habrPublicationCreator.getREADY_TO_PUBLICATION_BUTTON()).isEnabled());
        LOGGER.info("Публикация готова");
        habrPublicationCreator.createPublicationStartStep2();
        habrPublicationCreator.createPublicationStep2("тестирование", "текст внутри публикации");
        Assertions.assertAll(
                () -> assertEquals("Тестирование IT-систем *", driver.findElement(habrPublicationCreator.getSELECTED_HUB()).getText()),
                () -> assertEquals("тестирование", driver.findElement(habrPublicationCreator.getSELECTED_KEY_WARD()).getText()),
                () -> assertEquals("текст внутри публикации", driver.findElement(habrPublicationCreator.getPUBLICATION_TEXT()).getText())
        );
        LOGGER.info("Произведена верификация введенных данных в публикации");
        LOGGER.info("Состояние кнопки 'Отправить на модерацию' - " + driver.findElement(habrPublicationCreator.getSEND_FOR_MODERATION()).isEnabled());
        Assertions.assertTrue(driver.findElement(habrPublicationCreator.getSEND_FOR_MODERATION()).isEnabled());
        habrPublicationCreator.createPublicationCompletion();
    }

    @Test
    public void testCase4() {
        habrMainPage.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        profileSettingsPage = habrMainPage.openProfileSettings();
        profileSettingsPage.changeAndSaveProfileSettings(profileSettingsPage.getNAME(), profileSettingsPage.getGENDER(),
                profileSettingsPage.getCOUNTY(), profileSettingsPage.getREGION(), profileSettingsPage.getCITY());
        Assertions.assertAll(
            () -> assertEquals("Владислав", driver.findElement(profileSettingsPage.getREAL_NAME_RAW()).getAttribute("value")),
            () -> assertEquals("Мужской", driver.findElement(By.xpath(String.format(profileSettingsPage.getXPATH_SELECTOR_FINDER(), profileSettingsPage.getGENDER()))).getText()),
            () -> assertEquals("Беларусь", driver.findElement(By.xpath(String.format(profileSettingsPage.getXPATH_SELECTOR_FINDER(), profileSettingsPage.getCOUNTY()))).getText()),
            () -> assertEquals("Витебская обл.", driver.findElement(By.xpath(String.format(profileSettingsPage.getXPATH_SELECTOR_FINDER(), profileSettingsPage.getREGION()))).getText()),
            () -> assertEquals("Полоцк", driver.findElement(By.xpath(String.format(profileSettingsPage.getXPATH_SELECTOR_FINDER(), profileSettingsPage.getCITY()))).getText())
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        habrMainPage.logOut();
        LOGGER.info("Осуществлен выход из профиля");
    }
}
