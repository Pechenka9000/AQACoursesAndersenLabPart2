package school.lesson11.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateProjectPage {
    protected WebDriver driver;
    MainPage mainPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateProjectPage.class.getName());
    private final By PROJECT_NAME1                 = By.cssSelector("input[name='crm_project[name]']");
    private final By ORGANIZATION_NAME_FIELD       = By.xpath("//span[contains(text(),'Укажите организацию')]");
    private final By ORGANIZATION_NAME_RAW         = By.xpath("//div[@id='select2-drop']//input[@type='text']");
    private final By ORGANIZATION_NAME_FIELD_VALUE = By.xpath("//span[contains(text(),'diamondsPetroleumSuperSellers')]");
    private final By PRIMARY_CONTACT_PERSON        = By.cssSelector(".controls > .select2-container .select2-arrow");
    private final By PRIMARY_CONTACT_PERSON_VALUE  = By.cssSelector("select[name='crm_project[contactMain]'] option[value='2308']");
    private final By SUBDIVISION                   = By.cssSelector(".control-group:nth-child(6) .selector");
    private final By SUBDIVISION_VALUE             = By.xpath("//option[normalize-space()='Research & Development']");
    private final By PROJECT_CURATOR               = By.cssSelector(".control-group:nth-child(8) .selector");
    private final By PROJECT_CURATOR_VALUE         = By.cssSelector(".control-group:nth-child(7) option:nth-child(4)");
    private final By PROJECT_SUPERVISOR            = By.cssSelector(".control-group:nth-child(8) .selector");
    private final By PROJECT_SUPERVISOR_VALUE      = By.cssSelector(".control-group:nth-child(8) option:nth-child(4)");
    private final By PROJECT_ADMINISTRATOR         = By.cssSelector(".crm-administrator-select .selector");
    private final By PROJECT_ADMINISTRATOR_VALUE   = By.cssSelector(".crm-administrator-select > option:nth-child(4)");
    private final By MANAGER                       = By.cssSelector(".crm-manager-select .selector");
    private final By MANAGER_VALUE                 = By.cssSelector(".crm-manager-select > option:nth-child(4)");

    public CreateProjectPage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewProject() {
        driver.findElement(PROJECT_NAME1).sendKeys("diamondsPetroleumSuperSellersWebSite");
        LOGGER.info("Введено название проекта");
        driver.findElement(ORGANIZATION_NAME_FIELD).click();
        driver.findElement(ORGANIZATION_NAME_RAW).sendKeys("diamondsPetroleumSuperSellers");
        driver.findElement(ORGANIZATION_NAME_FIELD_VALUE).click();
        LOGGER.info("Выбрана организация из предложенного списка");
        driver.findElement(SUBDIVISION).click();
        driver.findElement(SUBDIVISION_VALUE).click();
        LOGGER.info("Выбрано подразделение");
        driver.findElement(PROJECT_CURATOR).click();
        driver.findElement(PROJECT_CURATOR_VALUE).click();
        LOGGER.info("Выбран куратор");
        driver.findElement(PROJECT_SUPERVISOR).click();
        driver.findElement(PROJECT_SUPERVISOR_VALUE).click();
        LOGGER.info("Выбран руководитель");
        driver.findElement(PROJECT_ADMINISTRATOR).click();
        driver.findElement(PROJECT_ADMINISTRATOR_VALUE).click();
        LOGGER.info("Выбран администратор");
        driver.findElement(MANAGER).click();
        driver.findElement(MANAGER_VALUE).click();
        LOGGER.info("Выбран менеджер");
        driver.findElement(PRIMARY_CONTACT_PERSON).click();
        LOGGER.info("Клик по полю контактного лица");
        driver.findElement(PRIMARY_CONTACT_PERSON_VALUE).click();
        LOGGER.info("Выбрано контактное лицо");
        mainPage = new MainPage(driver);
        driver.findElement(mainPage.getSAVE_AND_CLOSE_BUTTON()).click();
        LOGGER.info("Нажата кнопка 'Сохранить и закрыть'");
    }
}
