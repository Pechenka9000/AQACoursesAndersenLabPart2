package school.lesson11.task2;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.lesson10.task2.LoginPage;
import school.lesson10.task2.MainPage;

/**
 * Тестирование функционала сайта "https://habr.com/ru/all/" представлено четырьмя test-case-ами;
 * Test-case2 находится по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class TestCase2Test {
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCase2Test.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String WEB_SITE_LINK = "https://habr.com/ru/all/";
    private static final String EMAIL = "pechenka9000@gmail.com";
    private static final String PASSWORD = "Zetju2mkyv";
    private static final By LINK_COMMENT = By.xpath("//article[@id='171703']//a[@class='tm-article-snippet__title-link']");
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(WEB_SITE_LINK);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mainPage = loginPage.loginValidUser(EMAIL, PASSWORD);
    }

    @Test
    public void testUntitledTestCase() {
        LOGGER.info("Осуществлена загрузка сайта");
        mainPage.findSmthFromSearchRaw("Selenium IDE");
        mainPage.addCommentToBookmarks(LINK_COMMENT);
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
