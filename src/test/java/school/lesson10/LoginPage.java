package school.lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    protected WebDriver driver;
    private final StringBuffer verificationErrors = new StringBuffer();
    private static final Logger LOGGER = LoggerFactory.getLogger(Task1Test.class.getName());
    private By emailBy = By.id("email_field");
    private By passwordBy = By.id("password_field");
    private By signInBy = By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button");
    private By titleBy = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]");
    MainPage mainPage = new MainPage(driver);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getEmailBy() {
        return emailBy;
    }

    public By getPasswordBy() {
        return passwordBy;
    }

    public By getSignInBy() {
        return signInBy;
    }

    public By getTitleBy() {
        return titleBy;
    }

    public MainPage loginValidUser(String userEmail, String password) {
        driver.findElement(mainPage.getProfileIconEmptyBy()).click();
        LOGGER.info("Произведён клик на иконку профиля");
        driver.findElement(By.linkText("Войти")).click();
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
