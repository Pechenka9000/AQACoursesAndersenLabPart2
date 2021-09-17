package school.lesson13.task2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import school.habrStructure.*;
import school.lesson14.ConfProperties;

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
        HabrMainPageActions.startSignIn();
        HabrLoginPageActions.loginValidUser(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals("Вход", driver.findElement(HabrLoginPage.LOGIN_TITLE).getText()),
                () -> assertEquals(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), driver.findElement(HabrLoginPage.EMAIL_FIELD).getAttribute("value")),
                () -> assertEquals(school.lesson14.ConfProperties.getProperty("habrLoginPassword"), driver.findElement(HabrLoginPage.PASSWORD_FIELD).getAttribute("value"))
        );
        LOGGER.info("Произведена верификация введенных данных");
        HabrLoginPageActions.clickSignInButton();
        LOGGER.info("Осуществлена загрузка сайта");
        driver.findElement(HabrMainPage.PROFILE_ICON).click();
        LOGGER.info("Верификация текста ('@pechenka9000') в заголовке профиля - "+ driver.findElement(HabrMainPage.PROFILE_ICON_TITLE).getText().equalsIgnoreCase("@pechenka9000"));
        Assertions.assertEquals("@pechenka9000", driver.findElement(HabrMainPage.PROFILE_ICON_TITLE).getText());
    }

    @Test
    public void testCase2() {
        HabrMainPageActions.logIn(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
        HabrMainPageActions.findSmthFromSearchRaw("Selenium IDE");
        HabrMainPageActions.addCommentToBookmarks(HabrMainPage.LINK_COMMENT);
        LOGGER.info("Верификация заголовка в искомом комментарии " + driver.findElement(HabrMainPage.LINK_POST_TITLE).getText().equalsIgnoreCase(LINK_TITLE_TEXT));
        Assertions.assertEquals(LINK_TITLE_TEXT, driver.findElement(HabrMainPage.LINK_POST_TITLE).getText());
    }

    @Test
    public void testCase3() {
        HabrMainPageActions.logIn(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
        HabrMainPageActions.createNewPublication();
        HabrPublicationCreatorActions.createPublicationStep1("Моя будущая публикация", "текст внутри публикации");
        LOGGER.info("Введен заголовок публикации");
        Assertions.assertTrue(driver.findElement(HabrPublicationCreator.READY_TO_PUBLICATION_BUTTON).isEnabled());
        LOGGER.info("Публикация готова");
        HabrPublicationCreatorActions.createPublicationStartStep2();
        HabrPublicationCreatorActions.createPublicationStep2("тестирование", "текст внутри публикации");
        Assertions.assertAll(
                () -> assertEquals("Тестирование IT-систем *", driver.findElement(HabrPublicationCreator.SELECTED_HUB).getText()),
                () -> assertEquals("тестирование", driver.findElement(HabrPublicationCreator.SELECTED_KEY_WARD).getText()),
                () -> assertEquals("текст внутри публикации", driver.findElement(HabrPublicationCreator.PUBLICATION_TEXT).getText())
        );
        LOGGER.info("Произведена верификация введенных данных в публикации");
        LOGGER.info("Состояние кнопки 'Отправить на модерацию' - " + driver.findElement(HabrPublicationCreator.SEND_FOR_MODERATION).isEnabled());
        Assertions.assertTrue(driver.findElement(HabrPublicationCreator.SEND_FOR_MODERATION).isEnabled());
        HabrPublicationCreatorActions.createPublicationCompletion();
    }

    @Test
    public void testCase4() {
        HabrMainPageActions.logIn(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        HabrMainPageActions.openProfileSettings();
        HabrProfileSettingsPageActions.changeAndSaveProfileSettings(HabrProfileSettingsPage.NAME, HabrProfileSettingsPage.GENDER,
                HabrProfileSettingsPage.COUNTY, HabrProfileSettingsPage.REGION, HabrProfileSettingsPage.CITY);
        Assertions.assertAll(
                () -> assertEquals("Владислав", driver.findElement(HabrProfileSettingsPage.REAL_NAME_RAW).getAttribute("value")),
                () -> assertEquals("Мужской", driver.findElement(By.xpath(String.format(HabrProfileSettingsPage.XPATH_SELECTOR_FINDER, HabrProfileSettingsPage.GENDER))).getText()),
                () -> assertEquals("Беларусь", driver.findElement(By.xpath(String.format(HabrProfileSettingsPage.XPATH_SELECTOR_FINDER, HabrProfileSettingsPage.COUNTY))).getText()),
                () -> assertEquals("Витебская обл.", driver.findElement(By.xpath(String.format(HabrProfileSettingsPage.XPATH_SELECTOR_FINDER, HabrProfileSettingsPage.REGION))).getText()),
                () -> assertEquals("Полоцк", driver.findElement(By.xpath(String.format(HabrProfileSettingsPage.XPATH_SELECTOR_FINDER, HabrProfileSettingsPage.CITY))).getText())
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        HabrProfileSettingsPageActions.clickChangeAndSaveProfileSettings();
        HabrMainPageActions.logOut();
    }
}
