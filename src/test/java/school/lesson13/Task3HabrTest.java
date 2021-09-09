package school.lesson13;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import school.habrStructure.HabrProfileSettingsPage;

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
        habrCareerPage = habrMainPage.startCareer();
        LOGGER.info("Верификация текста ('Хабр Карьера') в заголовке - "+ driver.findElement(habrCareerPage.getHABR_CAREER_PAGE_TITLE()).getText().equals("Хабр Карьера"));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_TITLE, driver.findElement(habrCareerPage.getHABR_CAREER_PAGE_TITLE()).getText());
        habrCareerLoginPage = habrCareerPage.startSignInCareerProfile();
        habrCareerPage = habrCareerLoginPage.clickHabrSignInButton(); //Лучше скорее всего просто сделать void метод
        habrCareerPage.enterCareerProfile();
        LOGGER.info("Осуществлён вход в профиль 'Хабр Карьера'");
        LOGGER.info("Верификация успешного входа в заданный профиль - "+ driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText().equals("Владислав Гуков"));
        Assertions.assertEquals(EXPECTED_HABR_CAREER_PROFILE_NAME, driver.findElement(habrCareerPage.getMY_NAME_IN_PROFILE()).getText());
    }

    @Test
    public void testCase6() {
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
