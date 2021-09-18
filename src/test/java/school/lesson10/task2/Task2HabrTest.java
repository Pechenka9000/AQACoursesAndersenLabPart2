package school.lesson10.task2;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import school.habrStructure.HabrMainPage;
import school.habrStructure.HabrMainPageActions;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено одним test-case-ом;
 * Test-case1 находится по ссылке:
 * https://docs.google.com/document/d/1LejjmIwSaf50otFVvqCpHWGlodD1V1qhHdSQur3KVNw/edit?usp=sharing
 */
@DisplayName("Тестирование Habr: добавление поста в закладки")
public class Task2HabrTest extends Task2HabrTestConfig{

    @Story("Habr testing")
    @Test
    @Description("Вход в профиль, добавление поста в закладки, выход из профиля")
    public void testTask2() {
        LOGGER.info("Осуществлена загрузка сайта");
        HabrMainPageActions.addPostFromTapeToBookmarks(HabrMainPage.LINK_POST);
        HabrMainPageActions.logOut();
    }
}


