package school.lesson14.crmGeekbrainsStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateContactFacePage {
    protected static WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(CreateContactFacePage.class.getName());
    protected static final By LAST_NAME                  = By.cssSelector(".responsive-cell:nth-child(1) > .control-group:nth-child(2) input");
    protected static final By FIRST_NAME                 = By.cssSelector(".responsive-cell:nth-child(1) > .control-group:nth-child(3) input");
    protected static final By ORGANIZATION_NAME_FIELD    = By.xpath("//span[contains(text(),'Укажите организацию')]");
    protected static final By ORGANIZATION_NAME_RAW      = By.xpath("//div[@id='select2-drop']//input[@type='text']");
    public static final By ORGANIZATION_NAME_FIELD_VALUE = By.xpath("//span[contains(text(),'diamondsPetroleumSuperSellers')]");
    protected static final By POSITION_RAW               = By.cssSelector(".responsive-cell:nth-child(2) > .control-group:nth-child(3) input");
    public static final By CREATE_CONTACT_TITLE          = By.xpath("//h1[contains(text(),'Создать контактное лицо')]");
}