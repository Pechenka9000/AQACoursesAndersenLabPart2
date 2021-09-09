package school.lesson13;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import school.habrStructure.HabrProfileSettingsPage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case2 и Test-case4 находятся по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task3HabrTest extends Task3HabrTestConfig {

    @Test
    public void testCase5() {
        LOGGER.info("Осуществлена загрузка сайта 'Хабр'");
        habrMainPage.startSignIn();
        habrMainPage = habrLoginPage.loginValidUser(habrLoginPage.getEMAIL(), habrLoginPage.getPASSWORD());
        habrCareerPage = habrMainPage.startCareer();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        //LOGGER.info("Верификация текста ('Хабр Карьера') в заголовке - "+ driver.findElement(habrCareerPage.getHABR_CAREER_PAGE_TITLE()).getText().equalsIgnoreCase("Хабр Карьера"));
        //Assertions.assertEquals(EXPECTED_HABR_CAREER_TITLE, driver.findElement(habrCareerPage.getHABR_CAREER_PAGE_TITLE()).getText());
        habrCareerLoginPage = habrCareerPage.startSignInCareerProfile();
        LOGGER.info("инициализировали логин пейдж");
        habrCareerPage = habrCareerLoginPage.clickHabrSignInButton(); //Лучше скорее всего просто сделать void метод
        LOGGER.info("провернули клик по кнопке хабра ");
        habrCareerPage.enterCareerProfile();
        LOGGER.info("Осуществлён вход в профиль 'Хабр Карьера'");
        LOGGER.info("Верификация успешного входа в заданный профиль - " +
                driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText().equals(EXPECTED_HABR_CAREER_PROFILE_NAME));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_PROFILE_NAME, driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText());
    }

    @Test
    public void testCase6() {
        LOGGER.info("Осуществлена загрузка сайта");
        habrCareerPage = habrMainPage.startCareer();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        habrCareerLoginPage = habrCareerPage.startSignInCareerProfile();
        LOGGER.info("инициализировали логин пейдж");
        habrCareerPage = habrCareerLoginPage.signIn(habrLoginPage.getEMAIL(), habrLoginPage.getPASSWORD());
        habrCareerPage.getEducationLink("SQL", habrCareerPage.getLINK3());
        Assertions.assertEquals(EXPECTED_LINK3_TITLE, driver.findElement(habrCareerPage.getLINK3_TITLE()).getText());
        LOGGER.info(String.format("Верификация текста ('%s') в заголовке - ", EXPECTED_LINK3_TITLE) +
                driver.findElement(habrCareerPage.getLINK3_TITLE()).getText().equalsIgnoreCase(EXPECTED_LINK3_TITLE));
        new Actions(driver).click(driver.findElement(habrCareerPage.getPROFILE_ICON()))
                .click(driver.findElement(habrCareerPage.getHABR_CAREER_OUT_BUTON())).build().perform();
        //habrCareerPage.habrCareerLogOut();
        Assertions.assertTrue(driver.findElement(habrCareerPage.getENTER_CAREER_PROFILE()).isDisplayed());
        LOGGER.info("Осуществлен выход из профиля");

    }

    /*
    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.close();
    driver.switchTo().window(tabs2.get(0));
     */
}
