package school.lesson13.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.lesson11.task1.Task1CRMTest;
import school.lesson11.task1.*;
import school.lesson14.ConfProperties;
import school.lesson14.crmGeekbrainsStructure.CreateContactFacePageActions;
import school.lesson14.crmGeekbrainsStructure.CreateProjectPageActions;
import school.lesson14.crmGeekbrainsStructure.CrmLoginPageActions;
import school.lesson14.crmGeekbrainsStructure.CrmMainPageActions;
import school.lesson14.crmGeekbrainsTests.CRMGeekbrainsTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Task1CRMTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(CRMGeekbrainsTest.class.getName());
    private StringBuffer verificationErrors = new StringBuffer();
    protected CrmLoginPageActions loginPageActions;
    protected CrmMainPageActions mainPageActions;
    protected CreateProjectPageActions createProjectPage;
    protected CreateContactFacePageActions createContactFacePage;
    protected final String EXPECTED_ORGANIZATION_NAME  = "diamondsPetroleumSuperSellers";
    protected final String EXPECTED_SUBDIVISION        = "Research & Development";
    protected final String EXPECTED_RESPONSIBLE_PERSON = "Applanatest1 Applanatest1 Applanatest1";
    protected final String EXPECTED_CONTACT_PERSON     = "Торгаш Алмаз Нефтевич";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPageActions = new CrmMainPageActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("crmWebSite"));
        driver.manage().window().maximize();
        loginPageActions = new CrmLoginPageActions(driver);
        createProjectPage = new CreateProjectPageActions(driver);
        createContactFacePage = new CreateContactFacePageActions(driver);
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
