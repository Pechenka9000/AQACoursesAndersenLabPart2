package school.lesson14.crmGeekbrainsStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateProjectPageActions extends CreateProjectPage{

    public CreateProjectPageActions(WebDriver driver){
        CreateProjectPage.driver = driver;
    }

    @Step("Ввести данные для создания нового проекта")
    public static void createNewProject() {
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
    }

    @Step("Сохранить информацию и закрыть окно создания нового проекта")
    public static void saveAndCloseNewProject() {
        driver.findElement(CrmMainPageActions.SAVE_AND_CLOSE_BUTTON).click();
        LOGGER.info("Нажата кнопка 'Сохранить и закрыть'");
    }
}
