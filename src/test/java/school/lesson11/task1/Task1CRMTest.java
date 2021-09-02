package school.lesson11.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Тестирование функционала сайта "https://crm.geekbrains.space/" представлено двумя test-case-ами;
 * Test-case-ы находится по ссылке:
 * https://docs.google.com/document/d/14p2rgzeft96fiHZvV4V5nWB2sE_I9dd-dLs-68lmOtw/edit?usp=sharing
 */
public class Task1CRMTest {
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(Task1CRMTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    LoginPage loginPage;
    MainPage mainPage;
    CreateProjectPage createProjectPage;
    CreateContactFacePage createContactFacePage;

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
        mainPage = loginPage.loginValidUser(mainPage.getLOGIN(), mainPage.getPASSWORD());
        createProjectPage = new CreateProjectPage(driver);
        createContactFacePage = new CreateContactFacePage(driver);
    }

    @Test
    public void testCase1() {
        LOGGER.info("Осуществлена загрузка сайта");
        mainPage.createProject();
        createProjectPage.createNewProject();
    }

    @Test
    public void testCase2() {
        LOGGER.info("Осуществлена загрузка сайта");
        mainPage.createContactFace();
        createContactFacePage.createNewContactFace("Добытчик", "Алмазов", "ТоргашАлмазами");
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
