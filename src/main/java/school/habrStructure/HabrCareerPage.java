package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(HabrCareerPage.class.getName());
    protected static final By START_CAREER_PROFILE_SIGN_IN = By.xpath("//a[@class='header__auth-link header__sign_in']");
    protected static final By EDUCATION_BUTTON             = By.xpath("//a[contains(text(),'Образование')]");
    protected static final By EDUCATION_SEARCHER           = By.xpath("//input[@id='search_courses_q']");
    public static final By LINK                         = By.xpath("//a[normalize-space()='SQL Fundamentals']");
    public static final By LINK_TITLE                   = By.xpath("//h1[normalize-space()='SQL Fundamentals']");
    public static final By ENTER_CAREER_PROFILE         = By.xpath("//a[@class='header__auth-link header__sign_in']");
    public static final By PROFILE_ICON                 = By.xpath("//button[@title='Личное меню']");
    protected static final By MY_PROFILE_BUTTON            = By.xpath("//a[contains(text(),'Ваш профиль')]");
    public static final By MY_NAME_IN_PROFILE           = By.xpath("//h1[contains(text(),'Владислав Гуков')]");
    protected static final By HABR_CAREER_OUT_BUTON        = By.xpath("//button[@class='user_panel__menu-item']");
}
