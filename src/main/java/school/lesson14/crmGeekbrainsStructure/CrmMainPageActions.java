package school.lesson14.crmGeekbrainsStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CrmMainPageActions extends CrmMainPage {

    public CrmMainPageActions(WebDriver driver){
        CrmMainPage.driver = driver;
    }

    @Step("Инициация создания нового проекта")
    public static void createProject() {
        LOGGER.info("Верификация текста 'Geekbrains' в заголовке - "+ driver.findElement(MAIN_PAGE_TITLE).getText().equalsIgnoreCase("Geekbrains"));
        driver.findElement(PROJECTS_BUTTON).click();
        driver.findElement(MY_PROJECTS_BUTTON).click();
        LOGGER.info("Выбрана вкладка 'Мои проекты'");
        driver.findElement(CREATE_PROJECT_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Создать проект'");
    }

    @Step("Инициация создания нового контактного лица")
    public static void createContactFace() {
        LOGGER.info("Верификация текста 'Geekbrains' в заголовке - "+ driver.findElement(MAIN_PAGE_TITLE).getText().equalsIgnoreCase("Geekbrains"));
        driver.findElement(COUNTER_PARTIES_BUTTON).click();
        driver.findElement(CONTACT_FACES_BUTTON).click();
        LOGGER.info("Выбрана вкладка 'Контактные лица'");
        driver.findElement(CREATE_CONTACT_FACE_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Создать контактное лицо'");
    }

    @Step("Выход из профиля CRMGeekbrains")
    public static void logOut() {
        driver.findElement(PROFILE_FIELD).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(QUIT_BUTTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }
}
