package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrMainPage {
    protected WebDriver driver;
    private HabrLoginPage habrLoginPage;
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final String WEB_SITE_LINK  = "https://habr.com/ru/all/";
    private final By PROFILE_EMPTY_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div");
    private final By PROFILE_ICON       = By.xpath("//div[@data-test-id='menu-toggle-user']//*[local-name()='svg']");
    private final By PROFILE_ICON_TITLE = By.xpath("//a[normalize-space()='@pechenka9000']");
    private final By ENTER_ICON         = By.linkText("Войти");
    private final By OUT_ICON           = By.xpath("//a[@class='tm-user-menu__menu-link tm-user-menu__menu-link_grey']");
    private final By TAB_MY_TAPE        = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]");
    private final By ADD_TO_BOOKMARK    = By.xpath("//div[@class='tm-data-icons tm-page-article__counters-panel']");
    private final By FIND_ICON          = By.xpath("//a[@class='tm-header-user-menu__item tm-header-user-menu__search']");
    private final By CONFIRM_FIND_ICON  = By.xpath("//div[@class='tm-input-text-decorated__label tm-input-text-decorated__label_after']");
    private final By SEARCH_RAW         = By.xpath("//input[@placeholder='Поиск']");
    private final By LINK_COMMENT       = By.xpath("//span[contains(text(),'2.0 — WebDriver. Впечатления, проблемы и советы по')]");
    private final By LINK_POST          = By.xpath("//span[contains(text(),'ЭТТ, или когда в резюме можно написать, что профес')]");
    private final By LINK_POST_TITLE    = By.xpath("//span[contains(text(),'Selenium 2.0 — WebDriver. Впечатления, проблемы и ')]");
    private final By NEW_PUBLICATION_ICON = By.xpath("//a[@href='/ru/publication/new/']");
    private final By PROFILE_SETTINGS_BUTTON   = By.xpath("//span[contains(text(),'Настройки профиля')]");
    // new
    private final By HABR_SERVICES_OPENER         = By.xpath("//button[@class='tm-header__dropdown-toggle']");
    private final By CAREER_OPENER         = By.xpath("//a[@href='https://career.habr.com?utm_source=habr&utm_medium=habr_top_panel']");

    public HabrMainPage(WebDriver driver){
        this.driver = driver;
    }

    public HabrLoginPage startSignIn() {
        driver.findElement(PROFILE_EMPTY_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(ENTER_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Войти'");
        return new HabrLoginPage(driver);
    }

    public HabrCareerPageActions startCareer() {
        driver.findElement(HABR_SERVICES_OPENER).click();
        LOGGER.info("Осуществлено открытие списка сервисов Хабра");
        driver.findElement(CAREER_OPENER).click();
        LOGGER.info("Осуществлён клик по кнопке 'Карьера'");
        return new HabrCareerPageActions(driver);
    }

    public HabrPublicationCreator createNewPublication() {
        driver.findElement(NEW_PUBLICATION_ICON).click();
        return new HabrPublicationCreator(driver);
    }

    public void addPostFromTapeToBookmarks(By link) {
        driver.findElement(TAB_MY_TAPE).click();
        LOGGER.info("Выбрана вкладка 'Моя лента'");
        driver.findElement(link).click();
        LOGGER.info("Открыт пост из ленты");
        driver.findElement(ADD_TO_BOOKMARK).click();
        LOGGER.info("Пост добавлен в закладки");
    }

    public void findSmthFromSearchRaw(String searchText) {
        driver.findElement(FIND_ICON).click();
        LOGGER.info("Осуществлён клик по значку поиска");
        driver.findElement(SEARCH_RAW).sendKeys(searchText);
        LOGGER.info(String.format("Введён текст '%s' в строку поиска", searchText));
        driver.findElement(CONFIRM_FIND_ICON).click();
        LOGGER.info("Клик-инициализация по значку поиска");
    }

    public void addCommentToBookmarks(By link) {
        driver.findElement(link).click();
        LOGGER.info("Открыт искомый комментарий");
        driver.findElement(ADD_TO_BOOKMARK).click();
        LOGGER.info("Комментарий добавлен в закладки");
    }

    public HabrProfileSettingsPage openProfileSettings() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(PROFILE_SETTINGS_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Настройки профиля'");
        return new HabrProfileSettingsPage(driver);
    }

    public void logIn(String login, String password) {
        driver.findElement(PROFILE_EMPTY_ICON).click();
        driver.findElement(ENTER_ICON).click();
        habrLoginPage = new HabrLoginPage(driver);
        driver.findElement(habrLoginPage.getEMAIL_FIELD()).sendKeys(login);
        driver.findElement(habrLoginPage.getPASSWORD_FIELD()).sendKeys(password);
        driver.findElement(habrLoginPage.getSIGN_IN_BUTTON()).click();
    }

    public void logOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(OUT_ICON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    public String getWEB_SITE_LINK() {
        return WEB_SITE_LINK;
    }

    public By getLINK_COMMENT() {
        return LINK_COMMENT;
    }

    public By getLINK_POST() {
        return LINK_POST;
    }

    public By getLINK_POST_TITLE() {
        return LINK_POST_TITLE;
    }

    public By getHABR_SERVICES_OPENER() {
        return HABR_SERVICES_OPENER;
    }

    public By getCAREER_OPENER() {
        return CAREER_OPENER;
    }

    public By getPROFILE_ICON() {
        return PROFILE_ICON;
    }

    public By getPROFILE_ICON_TITLE() {
        return PROFILE_ICON_TITLE;
    }
}
