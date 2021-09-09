package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerLoginPage {
    protected WebDriver driver;
    HabrLoginPage habrLoginPage = new HabrLoginPage(driver);
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final String habrCareerPage = "https://career.habr.com/users/sign_in";
    private final By HABR_CAREER_LOGIN_PAGE_TITLE   = By.xpath("//a[@aria-label='Хабр Карьера']//*[local-name()='svg']");
    private final By EMAIL_FIELD   = By.xpath("//input[@placeholder='Почта']");
    private final By PASSWORD_FIELD   = By.xpath("//input[@placeholder='Пароль']");
    private final By SIGN_IN_BUTTON   = By.xpath("//button[contains(text(),'Войти')]");
    private final By HABR_SIGN_IN_BUTTON   = By.xpath("//a[@title='Авторизоваться через Habr Account']");
    private final By ENTER_CAREER_PROFILE   = By.xpath("//a[@class='header__auth-link header__sign_in']");

    public HabrCareerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HabrCareerPage clickHabrSignInButton() {
        driver.findElement(HABR_SIGN_IN_BUTTON).click();
        LOGGER.info("Осуществлен клик по кнопке 'Войти через Хабр'");
        return new HabrCareerPage(driver);
    }

    public HabrCareerPage signIn(String careerEmail, String careerPassword) {
        driver.findElement(EMAIL_FIELD).sendKeys(careerEmail);
        driver.findElement(PASSWORD_FIELD).sendKeys(careerPassword);
        LOGGER.info("Введены заданные данные");
        driver.findElement(SIGN_IN_BUTTON).click();
        return new HabrCareerPage(driver);
    }
}
