package school.lesson13.task3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import school.habrStructure.*;
import school.lesson14.ConfProperties;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case5 и Test-case6 находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task3HabrTest extends Task3HabrTestConfig {

    @Test
    public void testCase5() {
        LOGGER.info("Осуществлена загрузка сайта 'Хабр'");
        HabrMainPageActions.startCareer();
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        HabrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        HabrCareerLoginPageActions.loginValidUser(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), school.lesson14.ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), driver.findElement(HabrCareerLoginPage.EMAIL_FIELD).getAttribute("value")),
                () -> assertEquals(school.lesson14.ConfProperties.getProperty("habrLoginPassword"), driver.findElement(HabrCareerLoginPage.PASSWORD_FIELD).getAttribute("value"))
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        HabrCareerLoginPageActions.clickSignInButton();
        LOGGER.info("Осуществлён вход в профиль 'Хабр Карьера'");
        HabrCareerPageActions.enterToMyCareerProfile();
        LOGGER.info("Верификация успешного входа в заданный профиль - " +
                driver.findElement(HabrCareerPage.MY_NAME_IN_PROFILE).getText().equals(EXPECTED_HABR_CAREER_PROFILE_NAME));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_PROFILE_NAME, driver.findElement(HabrCareerPage.MY_NAME_IN_PROFILE).getText());
    }

    @Test
    public void testCase6() {
        LOGGER.info("Осуществлена загрузка сайта");
        HabrMainPageActions.startCareer();
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        HabrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        HabrCareerLoginPageActions.loginValidUser(school.lesson14.ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        HabrCareerLoginPageActions.clickSignInButton();
        HabrCareerPageActions.getEducationLink("SQL", HabrCareerPage.LINK);
        Assertions.assertEquals(EXPECTED_LINK_TITLE, driver.findElement(HabrCareerPage.LINK_TITLE).getText());
        LOGGER.info(String.format("Верификация текста ('%s') в заголовке - ", EXPECTED_LINK_TITLE) +
                driver.findElement(HabrCareerPage.LINK_TITLE).getText().equalsIgnoreCase(EXPECTED_LINK_TITLE));
        HabrCareerPageActions.habrCareerLogOut();
        Assertions.assertTrue(driver.findElement(HabrCareerPage.ENTER_CAREER_PROFILE).isDisplayed());
    }
}
