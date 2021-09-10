package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task3HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task3HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrLoginPage habrLoginPage;
    protected HabrMainPage habrMainPage;
    protected HabrCareerLoginPage habrCareerLoginPage;
    protected HabrCareerPageActions habrCareerPageActions;
    protected final String expectedLinkTitle = "SQL Fundamentals";
    protected final String expectedHabrCareerProfileName = "Владислав Гуков";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        habrMainPage = new HabrMainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habrWebSite"));
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
