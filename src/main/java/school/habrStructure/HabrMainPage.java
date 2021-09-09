package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrMainPage {
    protected WebDriver driver;
    private HabrMainPage habrMainPage;
    private HabrProfileSettingsPage settingsPage;
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final String WEB_SITE_LINK  = "https://habr.com/ru/all/";
    private final By PROFILE_EMPTY_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div");
    private final By PROFILE_ICON       = By.xpath("//div[@data-test-id='menu-toggle-user']//*[local-name()='svg']");
    private final By ENTER_ICON         = By.linkText("Войти");
    private final By OUT_ICON           = By.xpath("//a[@class='tm-user-menu__menu-link tm-user-menu__menu-link_grey']");
    private final By TAB_MY_TAPE        = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]");
    private final By ADD_TO_BOOKMARK    = By.xpath("//div[@class='tm-data-icons tm-page-article__counters-panel']");
    private final By FIND_ICON          = By.xpath("//a[@class='tm-header-user-menu__item tm-header-user-menu__search']");
    private final By CONFIRM_FIND_ICON  = By.xpath("//div[@class='tm-input-text-decorated__label tm-input-text-decorated__label_after']");
    private final By SEARCH_RAW         = By.xpath("//input[@placeholder='Поиск']");
    private final By LINK_COMMENT       = By.xpath("//article[@id='171703']//a[@class='tm-article-snippet__title-link']");
    private final By LINK_POST          = By.xpath("//span[contains(text(),'ЭТТ, или когда в резюме можно написать, что профес')]");
    private final By LINK_POST_TITLE    = By.xpath("//span[contains(text(),'Selenium 2.0 — WebDriver. Впечатления, проблемы и ')]");
    // new
    private final By HABR_SERVICES_OPENER         = By.xpath("//button[@class='tm-header__dropdown-toggle']");
    private final By CAREER_OPENER         = By.xpath("//a[@href='https://career.habr.com?utm_source=habr&utm_medium=habr_top_panel']");



    public HabrMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void startSignIn() {
        habrMainPage = new HabrMainPage(driver);
        driver.findElement(PROFILE_EMPTY_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(ENTER_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Войти'");
    }

    public HabrCareerPage startCareer() {
        driver.findElement(HABR_SERVICES_OPENER).click();
        LOGGER.info("Осуществлено открытие списка сервисов Хабра");
        driver.findElement(CAREER_OPENER).click();
        LOGGER.info("Осуществлён клик по кнопке 'Карьера'");
        return new HabrCareerPage();
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

    public void changeAndSaveProfileSettings(String name, String gender, String country, String region, String city) {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        settingsPage = new HabrProfileSettingsPage(driver);
        driver.findElement(settingsPage.getPROFILE_SETTINGS_BUTTON()).click();
        LOGGER.info("Осуществлён клик по кнопке 'Настройки профиля'");
        driver.findElement(settingsPage.getREAL_NAME_RAW()).clear();
        driver.findElement(settingsPage.getREAL_NAME_RAW()).sendKeys(name);
        LOGGER.info(String.format("Введён текст '%s' в поле 'Настоящее имя'", name));
        driver.findElement(settingsPage.getGENDER_SELECTOR()).click();
        LOGGER.info("Осуществлен клик в ячейку 'Пол'");
        driver.findElement(By.xpath(String.format(settingsPage.getXPATH_SELECTOR_FINDER(), gender))).click();
        LOGGER.info(String.format("Выбран пол - '%s'", gender));
        driver.findElement(settingsPage.getCOUNTRY_SELECTOR()).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - страна'");
        driver.findElement(By.xpath(String.format(settingsPage.getXPATH_SELECTOR_FINDER(), country))).click();
        LOGGER.info(String.format("Выбрана страна - '%s'", country));
        driver.findElement(settingsPage.getREGION_SELECTOR()).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - регион'");
        driver.findElement(By.xpath(String.format(settingsPage.getXPATH_SELECTOR_FINDER(), region))).click();
        LOGGER.info(String.format("Выбран регион - '%s'", region));
        driver.findElement(settingsPage.getCITY_SELECTOR()).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - город'");
        driver.findElement(By.xpath(String.format(settingsPage.getXPATH_SELECTOR_FINDER(), city))).click();
        LOGGER.info(String.format("Выбран город - '%s'", city));
        driver.findElement(settingsPage.getSAVE_CHANGES_BUTTON()).click();
        LOGGER.info("Осуществлен клик по кнопке 'Сохранить изменения'");
    }

    public void logOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(OUT_ICON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    public By getPROFILE_EMPTY_ICON() {
        return PROFILE_EMPTY_ICON;
    }

    public By getENTER_ICON() {
        return ENTER_ICON;
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
}
