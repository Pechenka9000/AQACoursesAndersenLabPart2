package school.lesson10.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage {
    protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class.getName());
    private final By EMAIL = By.id("email_field");
    private final By PASSWORD = By.id("password_field");
    private final By SIGN_IN_BUTTON = By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button");
    private final By LOGIN_TITLE = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]");
    MainPage mainPage = new MainPage(driver);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage loginValidUser(String userEmail, String password) {
        //LOGGER.info("Верификация текста ('Логин') в заголовке - "+ driver.findElement(LOGIN_TITLE).getText().equalsIgnoreCase("Логин"));
        driver.findElement(mainPage.getPROFILE_EMPTY_ICON()).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(mainPage.getENTER_ICON()).click();
        LOGGER.info("Осуществлён клик по кнопке 'Войти'");
        LOGGER.info("Верификация текста в заголовке");
        driver.findElement(EMAIL).click();
        driver.findElement(EMAIL).clear();
        driver.findElement(EMAIL).sendKeys(userEmail);
        LOGGER.info(String.format("Введён @email - '%s'", userEmail));
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD).clear();
        driver.findElement(PASSWORD).sendKeys(password);
        LOGGER.info(String.format("Введён пароль - '%s'", password));
        driver.findElement(SIGN_IN_BUTTON).click();
        return new MainPage(driver);
    }
}
