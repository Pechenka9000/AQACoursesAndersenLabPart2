package school.lesson14.crmGeekbrainsTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.lesson14.ConfProperties;
import school.lesson14.crmGeekbrainsStructure.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class CRMGeekbrainsTestConfig {
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
