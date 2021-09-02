package school.lesson11.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
    protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class.getName());
    private final String WEB_SITE_LINK = "https://crm.geekbrains.space/";
    private final String LOGIN = "Applanatest1";
    private final String PASSWORD = "Student2020!";
    private final By MAIN_PAGE_TITLE            = By.xpath("//a[contains(text(),'Geekbrains')]");
    private final By PROJECTS_BUTTON            = By.xpath("//span[@class='title'][contains(text(),'Проекты')]");
    private final By MY_PROJECTS_BUTTON         = By.xpath("//span[contains(text(),'Мои проекты')]");
    private final By CREATE_PROJECT_BUTTON      = By.xpath("//a[@title='Создать проект']");
    private final By COUNTER_PARTIES_BUTTON     = By.xpath("//span[@class='title'][contains(text(),'Контрагенты')]");
    private final By CONTACT_FACES_BUTTON       = By.xpath("//span[contains(text(),'Контактные лица')]");
    private final By CREATE_CONTACT_FACE_BUTTON = By.xpath("//a[@title='Создать контактное лицо']");
    private final By PROFILE_FIELD              = By.xpath("//a[normalize-space()='Applanatest1 Applanatest1 Applanatest1']");
    private final By QUIT_BUTTON                = By.xpath("//a[contains(text(),'Выйти')]");
    private final By SAVE_AND_CLOSE_BUTTON      = By.xpath("//button[contains(text(),'Сохранить и закрыть')]");
    private final By CANCEL_BUTTON              = By.xpath("//a[contains(text(),'Отмена')]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void createProject() {
        LOGGER.info("Верификация текста 'Geekbrains' в заголовке - "+ driver.findElement(MAIN_PAGE_TITLE).getText().equalsIgnoreCase("Geekbrains"));
        driver.findElement(PROJECTS_BUTTON).click();
        driver.findElement(MY_PROJECTS_BUTTON).click();
        LOGGER.info("Выбрана вкладка 'Мои проекты'");
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Создать проект'");
    }

    public void createContactFace() {
        LOGGER.info("Верификация текста 'Geekbrains' в заголовке - "+ driver.findElement(MAIN_PAGE_TITLE).getText().equalsIgnoreCase("Geekbrains"));
        driver.findElement(COUNTER_PARTIES_BUTTON).click();
        driver.findElement(CONTACT_FACES_BUTTON).click();
        LOGGER.info("Выбрана вкладка 'Контактные лица'");
        driver.findElement(CREATE_CONTACT_FACE_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Создать контактное лицо'");
    }

    public void logOut() {
        driver.findElement(PROFILE_FIELD).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(QUIT_BUTTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    public String getWEB_SITE_LINK() {
        return WEB_SITE_LINK;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public By getSAVE_AND_CLOSE_BUTTON() {
        return SAVE_AND_CLOSE_BUTTON;
    }

    public By getCANCEL_BUTTON() {
        return CANCEL_BUTTON;
    }
}
