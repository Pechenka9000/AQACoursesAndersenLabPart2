package school.habrStructure;

import org.openqa.selenium.WebDriver;

public class HabrCareerLoginPageActions extends HabrCareerLoginPage {

    public HabrCareerLoginPageActions(WebDriver driver){
        HabrCareerLoginPage.driver = driver;
    }

    public static void clickHabrSignInButton() {
        driver.findElement(HABR_SIGN_IN_BUTTON).click();
        LOGGER.info("Осуществлен клик по кнопке 'Войти через Хабр'");
    }

    public static void loginValidUser(String careerEmail, String careerPassword) {
        driver.findElement(EMAIL_FIELD).sendKeys(careerEmail);
        driver.findElement(PASSWORD_FIELD).sendKeys(careerPassword);
        LOGGER.info("Введены заданные данные");
    }

    public static void clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
    }
}
