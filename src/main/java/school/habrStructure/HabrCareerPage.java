package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerPage {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(HabrCareerPage.class.getName());
    protected final By START_CAREER_PROFILE_SIGN_IN = By.xpath("//a[@class='header__auth-link header__sign_in']");
    protected final By EDUCATION_BUTTON             = By.xpath("//a[contains(text(),'Образование')]");
    protected final By EDUCATION_SEARCHER           = By.xpath("//input[@id='search_courses_q']");
    protected final By LINK                         = By.xpath("//a[normalize-space()='SQL Fundamentals']");
    protected final By LINK_TITLE                   = By.xpath("//h1[normalize-space()='SQL Fundamentals']");
    protected final By ENTER_CAREER_PROFILE         = By.xpath("//a[@class='header__auth-link header__sign_in']");
    protected final By PROFILE_ICON                 = By.xpath("//button[@title='Личное меню']");
    protected final By MY_PROFILE_BUTTON            = By.xpath("//a[contains(text(),'Ваш профиль')]");
    protected final By MY_NAME_IN_PROFILE           = By.xpath("//h1[contains(text(),'Владислав Гуков')]");
    protected final By HABR_CAREER_OUT_BUTON        = By.xpath("//button[@class='user_panel__menu-item']");

    public HabrCareerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public By getLINK3() {
        return LINK;
    }

    public By getLINK_TITLE() {
        return LINK_TITLE;
    }

    public By getENTER_CAREER_PROFILE() {
        return ENTER_CAREER_PROFILE;
    }

    public By getMY_NAME_IN_PROFILE() {
        return MY_NAME_IN_PROFILE;
    }
}
