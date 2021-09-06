package school.lesson11.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task1CRMTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(Task1CRMTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected CreateProjectPage createProjectPage;
    protected CreateContactFacePage createContactFacePage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(mainPage.getWEB_SITE_LINK());
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        createProjectPage = new CreateProjectPage(driver);
        createContactFacePage = new CreateContactFacePage(driver);
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
