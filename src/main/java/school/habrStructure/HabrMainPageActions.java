package school.habrStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HabrMainPageActions extends HabrMainPage{

    public HabrMainPageActions(WebDriver driver){
        HabrMainPage.driver = driver;
    }

    @Step("Инициация входа в профиль Хабр")
    public static void startSignIn() {
        driver.findElement(PROFILE_EMPTY_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(ENTER_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Войти'");
    }

    @Step("Вход в сервис Хабр-Карьера")
    public static void startCareer() {
        driver.findElement(HABR_SERVICES_OPENER).click();
        LOGGER.info("Осуществлено открытие списка сервисов Хабра");
        driver.findElement(CAREER_OPENER).click();
        LOGGER.info("Осуществлён клик по кнопке 'Карьера'");
    }

    @Step("Создать новую публикацию")
    public static void createNewPublication() {
        driver.findElement(NEW_PUBLICATION_ICON).click();
    }

    @Step("Открыть пост из 'моей ленты'")
    public static void addPostFromTapeToBookmarks(By link) {
        driver.findElement(TAB_MY_TAPE).click();
        LOGGER.info("Выбрана вкладка 'Моя лента'");
        driver.findElement(link).click();
        LOGGER.info("Открыт пост из ленты");
        driver.findElement(ADD_TO_BOOKMARK).click();
        LOGGER.info("Пост добавлен в закладки");
    }

    @Step("Инициализация поиска")
    public static void findSmthFromSearchRaw(String searchText) {
        driver.findElement(FIND_ICON).click();
        LOGGER.info("Осуществлён клик по значку поиска");
        driver.findElement(SEARCH_RAW).sendKeys(searchText);
        LOGGER.info(String.format("Введён текст '%s' в строку поиска", searchText));
        driver.findElement(CONFIRM_FIND_ICON).click();
        LOGGER.info("Клик-инициализация по значку поиска");
    }

    @Step("Добавить искомый комментарий в закладки")
    public static void addCommentToBookmarks(By link) {
        driver.findElement(link).click();
        LOGGER.info("Открыт искомый комментарий");
        driver.findElement(ADD_TO_BOOKMARK).click();
        LOGGER.info("Комментарий добавлен в закладки");
    }

    @Step("Открыть настройки профиля Хабр")
    public static void openProfileSettings() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по иконке профиля");
        driver.findElement(PROFILE_SETTINGS_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Настройки профиля'");
    }

    @Step("Полный вход в профиль Хабр")
    public static void logIn(String login, String password) {
        driver.findElement(PROFILE_EMPTY_ICON).click();
        driver.findElement(ENTER_ICON).click();
        driver.findElement(HabrLoginPage.EMAIL_FIELD).sendKeys(login);
        driver.findElement(HabrLoginPage.PASSWORD_FIELD).sendKeys(password);
        driver.findElement(HabrLoginPage.SIGN_IN_BUTTON).click();
    }

    @Step("Выход из профиля Хабр")
    public static void logOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(OUT_ICON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }
}
