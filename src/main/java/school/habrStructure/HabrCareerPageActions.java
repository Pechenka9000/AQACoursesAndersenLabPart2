package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HabrCareerPageActions extends HabrCareerPage {

    public HabrCareerPageActions(WebDriver driver) {
        super(driver);
    }

    public void clickEducationButton() {
        driver.findElement(EDUCATION_BUTTON).click();
    }

    public void sendKeysEducationSearcher(String searchQuery) {
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
    }

    public void clickEnterCareerProfile() {
        driver.findElement(ENTER_CAREER_PROFILE).click();
    }

    public void enterToMyCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();

    }

    public HabrCareerLoginPage startSignInCareerProfile() {
        driver.findElement(START_CAREER_PROFILE_SIGN_IN).click();
        LOGGER.info("Выполнен клик по кнопке 'Войти в профиль Хабр Карьера'");
        return new HabrCareerLoginPage(driver);
    }

    public HabrCareerPage enterCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();
        LOGGER.info("Осуществлен вход в профиль 'Хабр Карьера'");
        return new HabrCareerPage(driver);
    }

    public HabrCareerPage getEducationLink(String searchQuery, By link) {
        driver.findElement(EDUCATION_BUTTON).click();
        LOGGER.info("Открыта вкладка 'Образование'");
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
        driver.findElement(link).click();
        return new HabrCareerPage(driver);
    }

    public void habrCareerLogOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(HABR_CAREER_OUT_BUTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    /*
    public HabrCareerLoginPage startSignInCareerProfile() {
        startCareerProfileSignIn.click();
        //driver.switchTo().window(driver.getWindowHandle());
        return new HabrCareerLoginPage(driver);
    }

    public HabrCareerPage enterCareerProfile() {
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(MY_PROFILE_BUTTON).click();
        LOGGER.info("Осуществлен вход в профиль 'Хабр Карьера'");
        return new HabrCareerPage(driver);
    }

    public HabrCareerPage getEducationLink(String searchQuery, By link) {
        driver.findElement(EDUCATION_BUTTON).click();
        LOGGER.info("Открыта вкладка 'Образование'");
        driver.findElement(EDUCATION_SEARCHER).sendKeys(searchQuery);
        driver.findElement(LINK3).click();
        return new HabrCareerPage(driver);
    }

    public void habrCareerLogOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(HABR_CAREER_OUT_BUTON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

     */
}
