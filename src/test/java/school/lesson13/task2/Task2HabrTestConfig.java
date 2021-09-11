package school.lesson13.task2;

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
import school.lesson13.task3.Task3HabrTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task2HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task3HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrPublicationCreator habrPublicationCreator;
    protected HabrMainPage habrMainPage;
    protected HabrLoginPage habrLoginPage;
    protected HabrProfileSettingsPage profileSettingsPage;
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
