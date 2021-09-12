package school.lesson14.crmGeekbrainsStructure;

import org.openqa.selenium.WebDriver;

public class CrmLoginPageActions extends CrmLoginPage{

    public CrmLoginPageActions(WebDriver driver){
        CrmLoginPage.driver = driver;
    }

    public static void loginValidUser(String login, String password) {
        driver.findElement(LOGIN_FIELD).clear();
        driver.findElement(LOGIN_FIELD).sendKeys(login);
        LOGGER.info(String.format("Введён логин - '%s'", login));
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        LOGGER.info(String.format("Введён пароль - '%s'", password));
    }

    public static void signIn() {
        driver.findElement(SIGN_IN_BUTTON).click();
        LOGGER.info("Нажата клавиша 'Войти'");
    }
}
