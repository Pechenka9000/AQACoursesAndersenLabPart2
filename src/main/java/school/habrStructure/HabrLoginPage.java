package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrLoginPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(HabrLoginPage.class.getName());
    public static final By EMAIL_FIELD       = By.id("email_field");
    public static final By PASSWORD_FIELD    = By.id("password_field");
    protected static final By SIGN_IN_BUTTON    = By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button");
    public static final By LOGIN_TITLE       = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]");
    protected static final String EMAIL         = "pechenka9000@gmail.com";
    protected static final String PASSWORD      = "Zetju2mkyv";
}
