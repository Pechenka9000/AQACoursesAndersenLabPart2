package school.lesson14.crmGeekbrainsStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateProjectPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(CreateProjectPage.class.getName());
    protected static final By PROJECT_NAME1              = By.cssSelector("input[name='crm_project[name]']");
    public static final By CREATE_PROJECT_TITLE          = By.xpath("//h1[contains(text(),'Создать проект')]");
    protected static final By ORGANIZATION_NAME_FIELD    = By.xpath("//span[contains(text(),'Укажите организацию')]");
    protected static final By ORGANIZATION_NAME_RAW      = By.xpath("//div[@id='select2-drop']//input[@type='text']");
    public static final By ORGANIZATION_NAME_FIELD_VALUE = By.xpath("//span[contains(text(),'diamondsPetroleumSuperSellers')]");
    protected static final By PRIMARY_CONTACT_PERSON     = By.cssSelector(".controls > .select2-container .select2-arrow");
    public static final By PRIMARY_CONTACT_PERSON_VALUE  = By.cssSelector("select[name='crm_project[contactMain]'] option[value='2308']");
    protected static final By SUBDIVISION                = By.cssSelector(".control-group:nth-child(6) .selector");
    public static final By SUBDIVISION_VALUE             = By.xpath("//option[normalize-space()='Research & Development']");
    protected static final By PROJECT_CURATOR            = By.cssSelector(".control-group:nth-child(8) .selector");
    public static final By PROJECT_CURATOR_VALUE         = By.cssSelector(".control-group:nth-child(7) option:nth-child(4)");
    protected static final By PROJECT_SUPERVISOR         = By.cssSelector(".control-group:nth-child(8) .selector");
    public static final By PROJECT_SUPERVISOR_VALUE      = By.cssSelector(".control-group:nth-child(8) option:nth-child(4)");
    protected static final By PROJECT_ADMINISTRATOR      = By.cssSelector(".crm-administrator-select .selector");
    public static final By PROJECT_ADMINISTRATOR_VALUE   = By.cssSelector(".crm-administrator-select > option:nth-child(4)");
    protected static final By MANAGER                    = By.cssSelector(".crm-manager-select .selector");
    public static final By MANAGER_VALUE                 = By.cssSelector(".crm-manager-select > option:nth-child(4)");
}
