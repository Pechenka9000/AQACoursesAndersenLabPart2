package school.lesson13.task3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.*;
import school.lesson13.ConfProperties;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task3HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task3HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrMainPage habrMainPage;
    protected HabrCareerLoginPage habrCareerLoginPage;
    protected HabrCareerPage habrCareerPage;
    protected HabrCareerPageActions habrCareerPageActions;
    protected final String EXPECTED_LINK_TITLE               = "SQL Fundamentals";
    protected final String EXPECTED_HABR_CAREER_PROFILE_NAME = "Владислав Гуков";

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
        habrCareerPage = new HabrCareerPage(driver);
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
