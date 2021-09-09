package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.HabrLoginPage;
import school.habrStructure.HabrMainPage;
import school.lesson11.task2.Task2HabrTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task2HabrTestCofig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task2HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrLoginPage habrLoginPage;
    protected HabrMainPage habrMainPage;
    protected final String LINK_TITLE_TEXT = "Selenium 2.0 — WebDriver. Впечатления, проблемы и советы по использованию";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        habrMainPage = new HabrMainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(habrMainPage.getWEB_SITE_LINK());
        driver.manage().window().maximize();
        habrLoginPage = new HabrLoginPage(driver);
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
