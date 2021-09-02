package school.lesson11.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateContactFacePage {
    protected WebDriver driver;
    MainPage mainPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateContactFacePage.class.getName());
    private final By LAST_NAME                     = By.cssSelector(".responsive-cell:nth-child(1) > .control-group:nth-child(2) input");
    private final By FIRST_NAME                    = By.cssSelector(".responsive-cell:nth-child(1) > .control-group:nth-child(3) input");
    private final By ORGANIZATION_NAME_FIELD       = By.xpath("//span[contains(text(),'Укажите организацию')]");
    private final By ORGANIZATION_NAME_RAW         = By.xpath("//div[@id='select2-drop']//input[@type='text']");
    private final By ORGANIZATION_NAME_FIELD_VALUE = By.xpath("//span[contains(text(),'diamondsPetroleumSuperSellers')]");
    private final By POSITION_RAW                  = By.cssSelector(".responsive-cell:nth-child(2) > .control-group:nth-child(3) input");

    public CreateContactFacePage(WebDriver driver){
        this.driver = driver;
    }

    public void createNewContactFace(String lastName, String firstName, String position) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        LOGGER.info(String.format("Введена фамилия - '%s'", lastName));
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        LOGGER.info(String.format("Введено имя - '%s'", firstName));
        driver.findElement(ORGANIZATION_NAME_FIELD).click();
        driver.findElement(ORGANIZATION_NAME_RAW).sendKeys("diamondsPetroleumSuperSellers");
        driver.findElement(ORGANIZATION_NAME_FIELD_VALUE).click();
        LOGGER.info("Выбрана организация из предложенного списка");
        driver.findElement(POSITION_RAW).sendKeys(position);
        LOGGER.info(String.format("Введена должность - '%s'", position));
        mainPage = new MainPage(driver);
        driver.findElement(mainPage.getSAVE_AND_CLOSE_BUTTON()).click();
        LOGGER.info("Нажата кнопка 'Сохранить и закрыть'");
    }
}