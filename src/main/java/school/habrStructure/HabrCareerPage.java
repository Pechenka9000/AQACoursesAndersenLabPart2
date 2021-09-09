package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerPage {
    protected WebDriver driver;
    private HabrMainPage habrMainPage;
    private static final Logger LOGGER      = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final String habrCareerPage     = "https://career.habr.com/";
    private final By START_CAREER_PROFILE_SIGN_IN = By.xpath("//a[@class='header__auth-link header__sign_in']");
    private final By EDUCATION_BUTTON       = By.xpath("//a[contains(text(),'Образование')]");
    private final By EDUCATION_SEARCHER     = By.xpath("//input[@id='search_courses_q']");
    private final By LINK1                  = By.xpath("//a[contains(text(),'Автоматизатор тестирования на Java')]");
    private final By LINK1_TITLE            = By.xpath("//h1[contains(text(),'Автоматизатор тестирования на Java')]");
    private final By LINK2                  = By.xpath("//div[@title='Java-разработчик']");
    private final By LINK2_TITLE            = By.xpath("//h1[contains(text(),'Java-разработчик')]");
    private final By LINK3                  = By.xpath("//a[normalize-space()='SQL Fundamentals']");
    private final By LINK3_TITLE            = By.xpath("//h1[normalize-space()='SQL Fundamentals']");
    private final By ENTER_CAREER_PROFILE   = By.xpath("//a[@class='header__auth-link header__sign_in']");
    private final By PROFILE_ICON           = By.xpath("//button[@title='Личное меню']");
    private final By MY_PROFILE_BUTTON      = By.xpath("//a[contains(text(),'Ваш профиль')]");
    private final By MY_NAME_IN_PROFILE     = By.xpath("//h1[contains(text(),'Владислав Гуков')]");
    private final By HABR_CAREER_OUT_BUTON = By.xpath("//button[@class='user_panel__menu-item']");


    public HabrCareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public HabrCareerLoginPage startSignInCareerProfile() {
        driver.findElement(START_CAREER_PROFILE_SIGN_IN).click();
        //driver.switchTo().window(driver.getWindowHandle());
        return new HabrCareerLoginPage(driver);
    }

    public HabrCareerPage enterCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();
        LOGGER.info("Осуществлен вход в профиль 'Хабр Карьера'");
        return new HabrCareerPage(driver);
    }

    public HabrCareerPage getEducationLink(String searchQuery, By link) {
        driver.findElement(EDUCATION_BUTTON).click();
        LOGGER.info("Открыта вкладка 'Образование'");
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
        driver.findElement(LINK3).click();
        return new HabrCareerPage(driver);
    }

    public void habrCareerLogOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(HABR_CAREER_OUT_BUTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    public HabrMainPage getHabrMainPage() {
        return habrMainPage;
    }

    public String getHabrCareerPage() {
        return habrCareerPage;
    }

    public By getEDUCATION_BUTTON() {
        return EDUCATION_BUTTON;
    }

    public By getEDUCATION_SEARCHER() {
        return EDUCATION_SEARCHER;
    }

    public By getLINK1() {
        return LINK1;
    }

    public By getLINK1_TITLE() {
        return LINK1_TITLE;
    }

    public By getLINK2() {
        return LINK2;
    }

    public By getLINK2_TITLE() {
        return LINK2_TITLE;
    }

    public By getLINK3() {
        return LINK3;
    }

    public By getLINK3_TITLE() {
        return LINK3_TITLE;
    }

    public By getENTER_CAREER_PROFILE() {
        return ENTER_CAREER_PROFILE;
    }

    public By getMY_NAME_IN_PROFILE() {
        return MY_NAME_IN_PROFILE;
    }

    public By getPROFILE_ICON() {
        return PROFILE_ICON;
    }

    public By getHABR_CAREER_OUT_BUTON() {
        return HABR_CAREER_OUT_BUTON;
    }
}
