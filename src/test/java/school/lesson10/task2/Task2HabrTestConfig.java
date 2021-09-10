package school.lesson10.task2;

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

import java.util.concurrent.TimeUnit;

public class Task2HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task2HabrTest.class.getName());
    private static final long IMPLICITLY_WAIT_TIMER = 20;
    HabrLoginPage habrLoginPage;
    HabrMainPage habrMainPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMER, TimeUnit.SECONDS);
        habrMainPage = new HabrMainPage(driver);
        driver.get(habrMainPage.getWEB_SITE_LINK());
        driver.manage().window().maximize();
        habrLoginPage = new HabrLoginPage(driver);
        habrLoginPage.loginValidUser(habrLoginPage.getEMAIL(), habrLoginPage.getPASSWORD());
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
