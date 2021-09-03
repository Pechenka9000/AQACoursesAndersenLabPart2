package school.lesson11.task1;

import org.junit.Test;

/**
 * Тестирование функционала сайта "https://crm.geekbrains.space/" представлено двумя test-case-ами;
 * Test-case1 и Test-case2 находится по ссылке:
 * https://docs.google.com/document/d/1RLTKJN8-8njE2UeEcKY6aDoBTpXwvgskoPZLPCT4iY8/edit?usp=sharing
 */
public class Task1CRMTest extends Task1CRMTestConfig {

    @Test
    public void testCase1() {
        LOGGER.info("Осуществлена загрузка сайта");
        mainPage.createProject();
        createProjectPage.createNewProject();
    }

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        mainPage.createContactFace();
        createContactFacePage.createNewContactFace("Добытчик", "Алмазов", "ТоргашАлмазами");
    }
}
