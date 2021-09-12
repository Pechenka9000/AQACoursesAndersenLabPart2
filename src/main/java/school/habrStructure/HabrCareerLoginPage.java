package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerLoginPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER            = LoggerFactory.getLogger(HabrCareerLoginPage.class.getName());
    public static final By EMAIL_FIELD           = By.xpath("//input[@placeholder='Почта']");
    public static final By PASSWORD_FIELD        = By.xpath("//input[@placeholder='Пароль']");
    protected static final By SIGN_IN_BUTTON        = By.xpath("//button[contains(text(),'Войти')]");
    protected static final By HABR_SIGN_IN_BUTTON   = By.xpath("//a[@title='Авторизоваться через Habr Account']");
    protected static final By ENTER_CAREER_PROFILE  = By.xpath("//a[@class='header__auth-link header__sign_in']");
}
