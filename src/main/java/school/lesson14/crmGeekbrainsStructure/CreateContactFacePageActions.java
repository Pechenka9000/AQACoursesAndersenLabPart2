package school.lesson14.crmGeekbrainsStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateContactFacePageActions extends CreateContactFacePage{

    public CreateContactFacePageActions(WebDriver driver){
        CreateContactFacePage.driver = driver;
    }

    @Step("Ввести данные для создания контактного лица")
    public static void createNewContactFace(String lastName, String firstName, String position) {
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
    }

    @Step("Сохранить информацию и закрыть окно создания контактного лица")
    public static void saveAndCloseNewContactFace() {
        driver.findElement(CrmMainPage.SAVE_AND_CLOSE_BUTTON).click();
        LOGGER.info("Нажата кнопка 'Сохранить и закрыть'");
    }
}
