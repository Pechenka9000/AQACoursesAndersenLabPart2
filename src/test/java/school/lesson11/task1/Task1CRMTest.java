package school.lesson11.task1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import school.lesson14.ConfProperties;
import school.lesson14.crmGeekbrainsStructure.*;
import school.lesson14.crmGeekbrainsStructure.CreateContactFacePage;
import school.lesson14.crmGeekbrainsStructure.CreateProjectPage;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование функционала сайта "https://crm.geekbrains.space/" представлено двумя test-case-ами;
 * Test-case1 и Test-case2 находится по ссылке:
 * https://docs.google.com/document/d/1RLTKJN8-8njE2UeEcKY6aDoBTpXwvgskoPZLPCT4iY8/edit?usp=sharing
 */
public class Task1CRMTest extends Task1CRMTestConfig {

    @Test
    public void testCase1() {
        LOGGER.info("Осуществлена загрузка сайта");
        LOGGER.info("Верификация текста ('Логин') в заголовке - "+ driver.findElement(CrmLoginPage.LOGIN_PAGE_TITLE).getText().equalsIgnoreCase("Логин"));
        CrmLoginPageActions.loginValidUser(ConfProperties.getProperty("crmGeekbrainsLogin"), ConfProperties.getProperty("crmGeekbrainsPassword"));
        Assertions. assertEquals("Логин", driver.findElement(CrmLoginPage.LOGIN_PAGE_TITLE).getText());
        LOGGER.info("Осуществлена верификация введенных данных");
        CrmLoginPageActions.signIn();
        CrmMainPageActions.createProject();
        Assertions.assertEquals("Создать проект", driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.CREATE_PROJECT_TITLE).getText());
        CreateProjectPageActions.createNewProject();
        Assertions.assertAll(
                () -> assertEquals(EXPECTED_ORGANIZATION_NAME, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.ORGANIZATION_NAME_FIELD_VALUE).getText()),
                () -> assertEquals(EXPECTED_SUBDIVISION, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.SUBDIVISION_VALUE).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.PROJECT_CURATOR_VALUE).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.PROJECT_SUPERVISOR_VALUE).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.PROJECT_ADMINISTRATOR_VALUE).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateProjectPage.MANAGER_VALUE).getText()),
                () -> assertEquals(EXPECTED_CONTACT_PERSON, driver.findElement(CreateProjectPage.PRIMARY_CONTACT_PERSON_VALUE).getText())
        );
        CreateProjectPageActions.saveAndCloseNewProject();
        LOGGER.info("Осуществлена верификация введенных данных");
    }

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        Assertions.assertEquals("Логин", driver.findElement(CrmLoginPage.LOGIN_PAGE_TITLE).getText());
        LOGGER.info("Верификация текста ('Логин') в заголовке - "+ driver.findElement(CrmLoginPage.LOGIN_PAGE_TITLE).getText().equalsIgnoreCase("Логин"));
        CrmLoginPageActions.loginValidUser(ConfProperties.getProperty("crmGeekbrainsLogin"), ConfProperties.getProperty("crmGeekbrainsPassword"));
        CrmLoginPageActions.signIn();
        CrmMainPageActions.createContactFace();
        Assertions.assertEquals("Создать контактное лицо", driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateContactFacePage.CREATE_CONTACT_TITLE).getText());
        LOGGER.info("Верификация текста ('Создать контактное лицо') в заголовке - "+ driver.findElement(school.lesson14.crmGeekbrainsStructure.CreateContactFacePage.CREATE_CONTACT_TITLE).getText().equalsIgnoreCase("Создать контактное лицо"));
        CreateContactFacePageActions.createNewContactFace("Добытчик", "Алмазов", "ТоргашАлмазами");
        Assertions.assertEquals("diamondsPetroleumSuperSellers", driver.findElement(CreateContactFacePage.ORGANIZATION_NAME_FIELD_VALUE).getText());
        LOGGER.info("Осуществлена верификация введенных данных");
        CreateContactFacePageActions.saveAndCloseNewContactFace();
    }
}
