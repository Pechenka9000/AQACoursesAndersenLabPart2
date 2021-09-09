package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HabrLoginPage {
    protected WebDriver driver;
    private final HabrMainPage habrMainPage = new HabrMainPage(driver);
    private static final Logger LOGGER = LoggerFactory.getLogger(HabrLoginPage.class.getName());
    private final By EMAIL_FIELD       = By.id("email_field");
    private final By PASSWORD_FIELD    = By.id("password_field");
    private final By SIGN_IN_BUTTON    = By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button");
    private final By LOGIN_TITLE       = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]");
    private final String EMAIL         = "pechenka9000@gmail.com";
    private final String PASSWORD      = "Zetju2mkyv";

    public HabrLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HabrMainPage loginValidUser(String userEmail, String password) {
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(userEmail);
        LOGGER.info(String.format("Введён @email - '%s'", userEmail));
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        LOGGER.info(String.format("Введён пароль - '%s'", password));
        driver.findElement(SIGN_IN_BUTTON).click();
        return new HabrMainPage(driver);
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public By getLOGIN_TITLE() {
        return LOGIN_TITLE;
    }
}
