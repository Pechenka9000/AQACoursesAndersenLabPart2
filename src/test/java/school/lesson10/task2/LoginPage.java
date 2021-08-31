package school.lesson10.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    protected WebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class.getName());
    private final By emailBy = By.id("email_field");
    private final By passwordBy = By.id("password_field");
    private final By signInBy = By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button");
    private final By titleBy = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]");
    MainPage mainPage = new MainPage(driver);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage loginValidUser(String userEmail, String password) {
        driver.findElement(mainPage.getPROFILE_EMPTY_ICON()).click();
        LOGGER.info("Произведён клик на иконку профиля");
        driver.findElement(mainPage.getENTER_ICON()).click();
        LOGGER.info("Произведён клик по кнопке 'Войти'");
        try {
            assertEquals("Вход", driver.findElement(titleBy).getText());
        } catch (Error e) {
            LOGGER.error("Такого элемента нет на данной странице ", e);
            verificationErrors.append(e);
        }
        LOGGER.info("Верификация текста в заголовке");
        driver.findElement(emailBy).click();
        driver.findElement(emailBy).clear();
        driver.findElement(emailBy).sendKeys(userEmail);
        driver.findElement(passwordBy).click();
        driver.findElement(passwordBy).clear();
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signInBy).click();
        return new MainPage(driver);
    }
}
