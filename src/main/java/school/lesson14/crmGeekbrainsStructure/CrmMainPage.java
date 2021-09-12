package school.lesson14.crmGeekbrainsStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrmMainPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(CrmMainPage.class.getName());
    protected final String WEB_SITE_LINK = "https://crm.geekbrains.space/";
    protected final String LOGIN = "Applanatest1";
    protected final String PASSWORD = "Student2020!";
    protected static final By MAIN_PAGE_TITLE            = By.xpath("//a[contains(text(),'Geekbrains')]");
    protected static final By PROJECTS_BUTTON            = By.xpath("//span[@class='title'][contains(text(),'Проекты')]");
    protected static final By MY_PROJECTS_BUTTON         = By.xpath("//span[contains(text(),'Мои проекты')]");
    protected static final By CREATE_PROJECT_BUTTON      = By.xpath("//a[@title='Создать проект']");
    protected static final By COUNTER_PARTIES_BUTTON     = By.xpath("//span[@class='title'][contains(text(),'Контрагенты')]");
    protected static final By CONTACT_FACES_BUTTON       = By.xpath("//span[contains(text(),'Контактные лица')]");
    protected static final By CREATE_CONTACT_FACE_BUTTON = By.xpath("//a[@title='Создать контактное лицо']");
    protected static final By PROFILE_FIELD              = By.xpath("//a[normalize-space()='Applanatest1 Applanatest1 Applanatest1']");
    protected static final By QUIT_BUTTON                = By.xpath("//a[contains(text(),'Выйти')]");
    protected static final By SAVE_AND_CLOSE_BUTTON      = By.xpath("//button[contains(text(),'Сохранить и закрыть')]");
    protected static final By CANCEL_BUTTON              = By.xpath("//a[contains(text(),'Отмена')]");

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

    public By getMAIN_PAGE_TITLE() {
        return MAIN_PAGE_TITLE;
    }
}
