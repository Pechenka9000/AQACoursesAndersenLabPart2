package school.habrStructure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HabrCareerPageActions extends HabrCareerPage {

    public HabrCareerPageActions(WebDriver driver){
        HabrCareerPage.driver = driver;
    }

    @Step("Вход во вкладку 'образование'")
    public static void clickEducationButton() {
        driver.findElement(EDUCATION_BUTTON).click();
    }

    @Step("Ввод данных в поисковую строку во вкладке 'образование'")
    public static  void sendKeysEducationSearcher(String searchQuery) {
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
    }

    @Step("Вход в профиль Хабр-Карьера")
    public static void clickEnterCareerProfile() {
        driver.findElement(ENTER_CAREER_PROFILE).click();
    }

    @Step("'Мой профиль' Хабр-Карьера")
    public static void enterToMyCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();
        LOGGER.info("Выполнен клик по кнопке 'Мой профиль'");
    }

    @Step("Инициация входа в профиль Хабр-Карьера")
    public static void startSignInCareerProfile() {
        driver.findElement(START_CAREER_PROFILE_SIGN_IN).click();
        LOGGER.info("Выполнен клик по кнопке 'Войти в профиль Хабр Карьера'");
    }

    /*@Step("Ввод данных для последующего входа в профиль Хабр-Карьера")
    public static void enterCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();
        LOGGER.info("Осуществлен вход в профиль 'Хабр Карьера'");
    }

     */

    @Step("Открытие ссылки через строку поиска во вкладке 'образование'")
    public static void getEducationLink(String searchQuery, By link) {
        driver.findElement(EDUCATION_BUTTON).click();
        LOGGER.info("Открыта вкладка 'Образование'");
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
        driver.findElement(link).click();
    }

    @Step("Выход из профиля Хабр-Карьера")
    public static void habrCareerLogOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(HABR_CAREER_OUT_BUTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }
}
