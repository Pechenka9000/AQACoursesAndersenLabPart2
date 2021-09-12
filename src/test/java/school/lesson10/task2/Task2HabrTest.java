package school.lesson10.task2;

import org.junit.Test;
import school.habrStructure.HabrMainPage;
import school.habrStructure.HabrMainPageActions;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено одним test-case-ом;
 * Test-case1 находится по ссылке:
 * https://docs.google.com/document/d/1LejjmIwSaf50otFVvqCpHWGlodD1V1qhHdSQur3KVNw/edit?usp=sharing
 */
public class Task2HabrTest extends Task2HabrTestConfig{

    @Test
    public void testTask2() {
        LOGGER.info("Осуществлена загрузка сайта");
        HabrMainPageActions.addPostFromTapeToBookmarks(HabrMainPage.LINK_POST);
        HabrMainPageActions.logOut();
    }
}


