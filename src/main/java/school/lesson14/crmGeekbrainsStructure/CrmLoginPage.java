package school.lesson14.crmGeekbrainsStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrmLoginPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER     = LoggerFactory.getLogger(CrmLoginPage.class.getName());
    public static final By LOGIN_FIELD       = By.xpath("//input[@id='prependedInput']");
    public static final By PASSWORD_FIELD    = By.xpath("//input[@id='prependedInput2']");
    protected static final By SIGN_IN_BUTTON = By.xpath("//button[contains(text(),'Войти')]");
    public static final By LOGIN_PAGE_TITLE  = By.xpath("//h2[contains(text(),'Логин')]");
}
