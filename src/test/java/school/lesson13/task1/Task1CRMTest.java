package school.lesson13.task1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import school.lesson13.ConfProperties;

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
        Assertions.assertEquals("Логин", driver.findElement(loginPage.getLOGIN_PAGE_TITLE()).getText());
        LOGGER.info("Верификация текста ('Логин') в заголовке - "+ driver.findElement(loginPage.getLOGIN_PAGE_TITLE()).getText().equalsIgnoreCase("Логин"));
        mainPage = loginPage.loginValidUser(ConfProperties.getProperty("crmGeekbrainsLogin"), ConfProperties.getProperty("crmGeekbrainsPassword"));
        mainPage.createProject();
        Assertions.assertEquals("Создать проект", driver.findElement(createProjectPage.getCREATE_PROJECT_TITLE()).getText());
        createProjectPage.createNewProject();
        Assertions.assertAll(
                () -> assertEquals(EXPECTED_ORGANIZATION_NAME, driver.findElement(createProjectPage.getORGANIZATION_NAME_FIELD_VALUE()).getText()),
                () -> assertEquals(EXPECTED_SUBDIVISION, driver.findElement(createProjectPage.getSUBDIVISION_VALUE()).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(createProjectPage.getPROJECT_CURATOR_VALUE()).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(createProjectPage.getPROJECT_SUPERVISOR_VALUE()).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(createProjectPage.getPROJECT_ADMINISTRATOR_VALUE()).getText()),
                () -> assertEquals(EXPECTED_RESPONSIBLE_PERSON, driver.findElement(createProjectPage.getMANAGER_VALUE()).getText()),
                () -> assertEquals(EXPECTED_CONTACT_PERSON, driver.findElement(createProjectPage.getPRIMARY_CONTACT_PERSON_VALUE()).getText())
        );
        LOGGER.info("Осуществлена верификация введенных данных");
    }

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        Assertions.assertEquals("Логин", driver.findElement(loginPage.getLOGIN_PAGE_TITLE()).getText());
        LOGGER.info("Верификация текста ('Логин') в заголовке - "+ driver.findElement(loginPage.getLOGIN_PAGE_TITLE()).getText().equalsIgnoreCase("Логин"));
        mainPage = loginPage.loginValidUser(ConfProperties.getProperty("crmGeekbrainsLogin"), ConfProperties.getProperty("crmGeekbrainsPassword"));
        mainPage.createContactFace();
        Assertions.assertEquals("Создать контактное лицо", driver.findElement(createContactFacePage.getCREATE_CONTACT_TITLE()).getText());
        LOGGER.info("Верификация текста ('Создать контактное лицо') в заголовке - "+ driver.findElement(createContactFacePage.getCREATE_CONTACT_TITLE()).getText().equalsIgnoreCase("Создать контактное лицо"));
        createContactFacePage.createNewContactFace("Добытчик", "Алмазов", "ТоргашАлмазами");
        Assertions.assertEquals("diamondsPetroleumSuperSellers", driver.findElement(createContactFacePage.getORGANIZATION_NAME_FIELD_VALUE()).getText());
        LOGGER.info("Осуществлена верификация введенных данных");
    }
}
