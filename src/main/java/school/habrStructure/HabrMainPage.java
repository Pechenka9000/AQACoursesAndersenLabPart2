package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrMainPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    protected static final String WEB_SITE_LINK  = "https://habr.com/ru/all/";
    protected static final By PROFILE_EMPTY_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div");
    public static final By PROFILE_ICON       = By.xpath("//div[@data-test-id='menu-toggle-user']//*[local-name()='svg']");
    public static final By PROFILE_ICON_TITLE = By.xpath("//a[normalize-space()='@pechenka9000']");
    protected static final By ENTER_ICON         = By.linkText("Войти");
    protected static final By OUT_ICON           = By.xpath("//a[@class='tm-user-menu__menu-link tm-user-menu__menu-link_grey']");
    protected static final By TAB_MY_TAPE        = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]");
    protected static final By ADD_TO_BOOKMARK    = By.xpath("//div[@class='tm-data-icons tm-page-article__counters-panel']");
    protected static final By FIND_ICON          = By.xpath("//a[@class='tm-header-user-menu__item tm-header-user-menu__search']");
    protected static final By CONFIRM_FIND_ICON  = By.xpath("//div[@class='tm-input-text-decorated__label tm-input-text-decorated__label_after']");
    protected static final By SEARCH_RAW         = By.xpath("//input[@placeholder='Поиск']");
    public static final By LINK_COMMENT       = By.xpath("//span[contains(text(),'2.0 — WebDriver. Впечатления, проблемы и советы по')]");
    public static final By LINK_POST          = By.xpath("//span[contains(text(),'ЭТТ, или когда в резюме можно написать, что профес')]");
    public static final By LINK_POST_TITLE    = By.xpath("//span[contains(text(),'Selenium 2.0 — WebDriver. Впечатления, проблемы и ')]");
    protected static final By NEW_PUBLICATION_ICON = By.xpath("//a[@href='/ru/publication/new/']");
    protected static final By PROFILE_SETTINGS_BUTTON   = By.xpath("//span[contains(text(),'Настройки профиля')]");
    protected static final By HABR_SERVICES_OPENER         = By.xpath("//button[@class='tm-header__dropdown-toggle']");
    protected static final By CAREER_OPENER         = By.xpath("//a[@href='https://career.habr.com?utm_source=habr&utm_medium=habr_top_panel']");
}
