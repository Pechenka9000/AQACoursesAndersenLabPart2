package school.lesson14.habrTests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import school.habrStructure.*;
import school.lesson14.ConfProperties;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-cases находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
@DisplayName("Позитивные тест-кейсы Habr")
public class HabrTest extends HabrTestConfig {

    @Story("Habr testing")
    @Test
    @Description("Вход в профиль")
    public void testCase1() {
        LOGGER.info("Осуществлена загрузка сайта");
        HabrMainPageActions.startSignIn();
        HabrLoginPageActions.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals("Вход", driver.findElement(HabrLoginPage.LOGIN_TITLE).getText()),
                () -> assertEquals(ConfProperties.getProperty("habrLoginEmail"), driver.findElement(HabrLoginPage.EMAIL_FIELD).getAttribute("value")),
                () -> assertEquals(ConfProperties.getProperty("habrLoginPassword"), driver.findElement(HabrLoginPage.PASSWORD_FIELD).getAttribute("value"))
        );
        LOGGER.info("Произведена верификация введенных данных");
        HabrLoginPageActions.clickSignInButton();
        LOGGER.info("Осуществлена загрузка сайта");
        driver.findElement(HabrMainPage.PROFILE_ICON).click();
        LOGGER.info("Верификация текста ('@pechenka9000') в заголовке профиля - "+ driver.findElement(HabrMainPage.PROFILE_ICON_TITLE).getText().equalsIgnoreCase("@pechenka9000"));
        Assertions.assertEquals("@pechenka9000", driver.findElement(HabrMainPage.PROFILE_ICON_TITLE).getText());
    }

    @Story("Habr testing")
    @Test
    @Description("Поиск и добавление комментария в закладки")
    public void testCase2() {
        HabrMainPageActions.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        HabrMainPageActions.findSmthFromSearchRaw("Selenium IDE");
        HabrMainPageActions.addCommentToBookmarks(HabrMainPage.LINK_COMMENT);
        LOGGER.info("Верификация заголовка в искомом комментарии " + driver.findElement(HabrMainPage.LINK_POST_TITLE).getText().equalsIgnoreCase(LINK_TITLE_TEXT));
        Assertions.assertEquals(LINK_TITLE_TEXT, driver.findElement(HabrMainPage.LINK_POST_TITLE).getText());
    }

    @Story("Habr testing")
    @Test
    @Description("Создание публикации")
    public void testCase3() {
        HabrMainPageActions.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
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

    @Story("Habr testing")
    @Test
    @Description("Редактирование профиля данной информацией и выход из него")
    public void testCase4() {
        HabrMainPageActions.logIn(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
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

    @Story("Habr testing")
    @Test
    @Description("Вход в профиль Хабр-Карьера")
    public void testCase5() {
        driver.get(ConfProperties.getProperty("habrWebSite"));
        LOGGER.info("Осуществлена загрузка сайта 'Хабр'");
        HabrMainPageActions.startCareer();
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        HabrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        HabrCareerLoginPageActions.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals(ConfProperties.getProperty("habrLoginEmail"), driver.findElement(HabrCareerLoginPage.EMAIL_FIELD).getAttribute("value")),
                () -> assertEquals(ConfProperties.getProperty("habrLoginPassword"), driver.findElement(HabrCareerLoginPage.PASSWORD_FIELD).getAttribute("value"))
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        HabrCareerLoginPageActions.clickSignInButton();
        LOGGER.info("Осуществлён вход в профиль 'Хабр Карьера'");
        HabrCareerPageActions.enterToMyCareerProfile();
        LOGGER.info("Верификация успешного входа в заданный профиль - " +
                driver.findElement(HabrCareerPage.MY_NAME_IN_PROFILE).getText().equals(EXPECTED_HABR_CAREER_PROFILE_NAME));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_PROFILE_NAME, driver.findElement(HabrCareerPage.MY_NAME_IN_PROFILE).getText());
    }

    @Story("Habr testing")
    @Test
    @Description("Поиск образовательного курса и выход из профиля Хабр-Карьера")
    public void testCase6() {
        driver.get(ConfProperties.getProperty("habrWebSite"));
        LOGGER.info("Осуществлена загрузка сайта");
        HabrMainPageActions.startCareer();
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        HabrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        HabrCareerLoginPageActions.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        HabrCareerLoginPageActions.clickSignInButton();
        HabrCareerPageActions.getEducationLink("SQL", HabrCareerPage.LINK);
        Assertions.assertEquals(EXPECTED_LINK_TITLE, driver.findElement(HabrCareerPage.LINK_TITLE).getText());
        LOGGER.info(String.format("Верификация текста ('%s') в заголовке - ", EXPECTED_LINK_TITLE) +
                driver.findElement(HabrCareerPage.LINK_TITLE).getText().equalsIgnoreCase(EXPECTED_LINK_TITLE));
        HabrCareerPageActions.habrCareerLogOut();
        Assertions.assertTrue(driver.findElement(HabrCareerPage.ENTER_CAREER_PROFILE).isDisplayed());
    }
}
