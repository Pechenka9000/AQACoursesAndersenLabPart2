package school.habrStructure;

import org.openqa.selenium.WebDriver;

public class HabrLoginPageActions extends HabrLoginPage{

    public HabrLoginPageActions(WebDriver driver) {
        HabrLoginPage.driver = driver;
    }

    public static void loginValidUser(String userEmail, String password) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(userEmail);
        LOGGER.info(String.format("Введён @email - '%s'", userEmail));
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        LOGGER.info(String.format("Введён пароль - '%s'", password));
    }

    public static void clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON).click();
        LOGGER.info("Нажата клавиша 'Войти'");
    }
}
