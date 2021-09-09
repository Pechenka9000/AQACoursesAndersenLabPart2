package school.lesson13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.HabrCareerLoginPage;
import school.habrStructure.HabrCareerPage;
import school.habrStructure.HabrLoginPage;
import school.habrStructure.HabrMainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task3HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task3HabrTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrLoginPage habrLoginPage;
    protected HabrMainPage habrMainPage;
    protected HabrCareerLoginPage habrCareerLoginPage;
    protected HabrCareerPage habrCareerPage;
    protected final String LINK_TITLE_TEXT = "Selenium 2.0 — WebDriver. Впечатления, проблемы и советы по использованию";
    protected final String EXPECTED_HABR_CAREER_TITLE = "Хабр Карьера";
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
