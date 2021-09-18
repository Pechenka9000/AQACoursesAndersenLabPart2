package school.lesson11.task2;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import school.habrStructure.HabrMainPage;
import school.habrStructure.HabrMainPageActions;
import school.habrStructure.HabrProfileSettingsPage;
import school.habrStructure.HabrProfileSettingsPageActions;
import school.lesson13.ConfProperties;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case2 и Test-case4 находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
@DisplayName("Тест-кейсы 2,4 Habr")
public class Task2HabrTest extends Task2HabrTestCofig {

    @Story("Habr testing")
    @Test
    @Description("Поиск и добавление комментария в закладки")
    public void testCase2() {
        HabrMainPageActions.logIn(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
        HabrMainPageActions.findSmthFromSearchRaw("Selenium IDE");
        HabrMainPageActions.addCommentToBookmarks(HabrMainPage.LINK_COMMENT);
        LOGGER.info("Верификация заголовка в искомом комментарии " + driver.findElement(HabrMainPage.LINK_POST_TITLE).getText().equalsIgnoreCase(LINK_TITLE_TEXT));
        Assertions.assertEquals(LINK_TITLE_TEXT, driver.findElement(HabrMainPage.LINK_POST_TITLE).getText());
    }

    @Story("Habr testing")
    @Test
    @Description("Редактирование профиля данной информацией и выход из него")
    public void testCase4() {
        HabrMainPageActions.logIn(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
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
