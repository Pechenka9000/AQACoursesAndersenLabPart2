package school.lesson11.task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.*;
import school.lesson14.ConfProperties;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task2HabrTestCofig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task2HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrLoginPageActions habrLoginPageActions;
    protected HabrMainPageActions habrMainPageActions;
    protected HabrProfileSettingsPageActions profileSettingsPageActions;
    protected final String LINK_TITLE_TEXT = "Selenium 2.0 — WebDriver. Впечатления, проблемы и советы по использованию";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        habrMainPageActions = new HabrMainPageActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habrWebSite"));
        driver.manage().window().maximize();
        habrLoginPageActions = new HabrLoginPageActions(driver);
        profileSettingsPageActions = new HabrProfileSettingsPageActions(driver);
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
