package school.lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Task1Test {
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(Task1Test.class.getName());
    private static final String EMAIL = "pechenka9000@gmail.com";
    private static final String PASSWORD = "Zetju2mkyv";
    private static final By LINK_POST = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/main/div/div/div[2]/div[1]/div/div[3]/div/div/button/span[1]");

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://habr.com/ru/all/");
        driver.manage().window().maximize();
    }

    @Test
    public void testTask1() {
        LOGGER.info("Осуществлена загрузка сайта");
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginValidUser(EMAIL, PASSWORD);
        mainPage.addToBookmarks(LINK_POST);
        mainPage.logOut();
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}


