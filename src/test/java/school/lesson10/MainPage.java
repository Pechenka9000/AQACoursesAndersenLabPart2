package school.lesson10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
    protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class.getName());
    private final By PROFILE_EMPTY_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div");
    private final By PROFILE_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div");
    private final By ENTER_ICON = By.linkText("Войти");
    private final By OUT_ICON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[5]/a[2]");
    private final By TAB_MY_TAPE = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]");
    private final By TAB_POST_BOOKMARK = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/main/div/div/div[2]/div[1]/div/div[3]/div/div/button/span[1]");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToBookmarks(By link) {
        driver.findElement(TAB_MY_TAPE).click();
        LOGGER.info("Выбрана вкладка 'Моя лента'");
        driver.findElement(link).click();
        LOGGER.info("Открыт пост из ленты");
        driver.findElement(TAB_POST_BOOKMARK).click();
        LOGGER.info("Пост добавлен в закладки");
    }

    public void logOut() {
        driver.findElement(PROFILE_ICON).click();
        LOGGER.info("Осуществлён клик по кнопке профиля");
        driver.findElement(OUT_ICON).click();
        LOGGER.info("Осуществлён выход из профиля");
    }

    public By getPROFILE_EMPTY_ICON() {
        return PROFILE_EMPTY_ICON;
    }

    public By getENTER_ICON() {
        return ENTER_ICON;
    }
}
