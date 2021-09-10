package school.habrStructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HabrCareerPageActions extends HabrCareerPage {

    public HabrCareerPageActions(WebDriver driver) {
        super(driver);
    }

    public void clickEducationButton() {
        educationButton.click();
    }

    public void sendKeysEducationSearcher(String searchQuery) {
        educationSearcher.sendKeys(searchQuery);
    }

    public void clickEnterCareerProfile() {
        enterCareerProfile.click();
    }


    public HabrCareerLoginPage startSignInCareerProfile() {
        startCareerProfileSignIn.click();
        LOGGER.info("Выполнен клик по кнопке 'Войти в профиль Хабр Карьера'");
        return new HabrCareerLoginPage(driver);
    }

    public HabrCareerPage enterCareerProfile() {
        profileIcon.click();
        myProfileButton.click();
        LOGGER.info("Осуществлен вход в профиль 'Хабр Карьера'");
        return new HabrCareerPage(driver);
    }

    public HabrCareerPage getEducationLink(String searchQuery, WebElement link) {
        educationButton.click();
        LOGGER.info("Открыта вкладка 'Образование'");
        educationSearcher.sendKeys(searchQuery);
        link.click();
        return new HabrCareerPage(driver);
    }

    public void habrCareerLogOut() {
        profileIcon.click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        habrCareerOutButton.click();
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
