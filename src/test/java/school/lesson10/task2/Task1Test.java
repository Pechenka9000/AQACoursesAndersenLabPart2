package school.lesson10.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено одним test-case-ом;
 * Test-case1 находится по ссылке:
 * https://docs.google.com/document/d/1LejjmIwSaf50otFVvqCpHWGlodD1V1qhHdSQur3KVNw/edit?usp=sharing
 */
public class Task1Test {
    private WebDriver driver;
    private static final String WEB_SITE_LINK = "https://habr.com/ru/all/";
    private static final Logger LOGGER = LoggerFactory.getLogger(Task1Test.class.getName());
    private static final String EMAIL = "pechenka9000@gmail.com";
    private static final String PASSWORD = "Zetju2mkyv";
    private static final By LINK_POST = By.xpath("//span[contains(text(),'ЭТТ, или когда в резюме можно написать, что профес')]");
    private static final long IMPLICITLY_WAIT_TIMER = 20;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMER, TimeUnit.SECONDS);
        driver.get(WEB_SITE_LINK);
        driver.manage().window().maximize();
    }

    @Test
    public void testTask1() {
        LOGGER.info("Осуществлена загрузка сайта");
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginValidUser(EMAIL, PASSWORD);
        mainPage.addPostFromTapeToBookmarks(LINK_POST);
        mainPage.logOut();
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}


