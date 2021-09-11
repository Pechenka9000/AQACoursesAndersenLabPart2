package school.lesson13.task3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import school.lesson13.ConfProperties;

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
        habrCareerPageActions = habrMainPage.startCareer();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        habrCareerLoginPage = habrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        habrCareerLoginPage.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        Assertions.assertAll(
                () -> assertEquals(ConfProperties.getProperty("habrLoginEmail"), driver.findElement(habrCareerLoginPage.getEMAIL_FIELD()).getAttribute("value")),
                () -> assertEquals(ConfProperties.getProperty("habrLoginPassword"), driver.findElement(habrCareerLoginPage.getPASSWORD_FIELD()).getAttribute("value"))
        );
        LOGGER.info("Осуществлена верификация введенных данных");
        habrCareerLoginPage.clickSignInButton();
        LOGGER.info("Осуществлён вход в профиль 'Хабр Карьера'");
        habrCareerPageActions.enterToMyCareerProfile();
        LOGGER.info("Верификация успешного входа в заданный профиль - " +
                driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText().equals(EXPECTED_HABR_CAREER_PROFILE_NAME));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_PROFILE_NAME, driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText());
    }

    @Test
    public void testCase6() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrCareerPageActions = habrMainPage.startCareer();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        habrCareerLoginPage = habrCareerPageActions.startSignInCareerProfile();
        LOGGER.info("Инициирован вход в профиль 'Хабр Карьера'");
        habrCareerLoginPage.loginValidUser(ConfProperties.getProperty("habrLoginEmail"), ConfProperties.getProperty("habrLoginPassword"));
        habrCareerLoginPage.clickSignInButton();
        habrCareerPageActions.getEducationLink("SQL", habrCareerPage.getLINK3());
        Assertions.assertEquals(EXPECTED_LINK_TITLE, driver.findElement(habrCareerPage.getLINK_TITLE()).getText());
        LOGGER.info(String.format("Верификация текста ('%s') в заголовке - ", EXPECTED_LINK_TITLE) +
                driver.findElement(habrCareerPage.getLINK_TITLE()).getText().equalsIgnoreCase(EXPECTED_LINK_TITLE));
        habrCareerPageActions.habrCareerLogOut();
        Assertions.assertTrue(driver.findElement(habrCareerPage.getENTER_CAREER_PROFILE()).isDisplayed());
        LOGGER.info("Осуществлен выход из профиля");
    }
}
