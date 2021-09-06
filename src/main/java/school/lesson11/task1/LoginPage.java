package school.lesson11.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class.getName());
    private final By LOGIN_FIELD = By.xpath("//input[@id='prependedInput']");
    private final By PASSWORD_FIELD = By.xpath("//input[@id='prependedInput2']");
    private final By SIGN_IN_BUTTON = By.xpath("//button[contains(text(),'Войти')]");
    private final By LOGIN_PAGE_TITLE = By.xpath("//h2[contains(text(),'Логин')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage loginValidUser(String login, String password) {
        driver.findElement(LOGIN_FIELD).clear();
        driver.findElement(LOGIN_FIELD).sendKeys(login);
        LOGGER.info(String.format("Введён логин - '%s'", login));
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        LOGGER.info(String.format("Введён пароль - '%s'", password));
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MainPage(driver);
    }

    public By getLOGIN_PAGE_TITLE() {
        return LOGIN_PAGE_TITLE;
    }
}
