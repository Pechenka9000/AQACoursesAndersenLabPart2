package school.lesson14.habrTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.habrStructure.*;
import school.lesson14.ConfProperties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.junit.Assert.fail;

public class HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(HabrTest.class.getName());
    LogEntries logEntries;
    protected static final java.util.logging.Logger BROWSER_LOGGER = java.util.logging.Logger.getLogger("BrowserLogger");
    private StringBuffer verificationErrors = new StringBuffer();
    protected HabrMainPageActions habrMainPageActions;
    protected HabrLoginPageActions habrLoginPageActions;
    HabrPublicationCreatorActions habrPublicationCreatorActions;
    protected HabrCareerPageActions habrCareerPageActions;
    protected HabrCareerLoginPageActions habrCareerLoginPageActions;
    protected HabrProfileSettingsPageActions profileSettingsPageActions;
    protected final String EXPECTED_LINK_TITLE               = "SQL Fundamentals";
    protected final String EXPECTED_HABR_CAREER_PROFILE_NAME = "Владислав Гуков";
    protected final String LINK_TITLE_TEXT = "Selenium 2.0 — WebDriver. Впечатления, проблемы и советы по использованию";

    private static DesiredCapabilities getCap() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        logPrefs.enable(LogType.PROFILER, Level.INFO);
        logPrefs.enable(LogType.BROWSER, Level.INFO);
        logPrefs.enable(LogType.CLIENT, Level.INFO);
        logPrefs.enable(LogType.DRIVER, Level.INFO);
        logPrefs.enable(LogType.SERVER, Level.INFO);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return caps;
    }

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.CAPABILITY, getCap());
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("habrWebSite"));
        driver.manage().window().maximize();
        habrMainPageActions = new HabrMainPageActions(driver);
        habrLoginPageActions = new HabrLoginPageActions(driver);
        habrPublicationCreatorActions = new HabrPublicationCreatorActions(driver);
        habrCareerPageActions = new HabrCareerPageActions(driver);
        habrCareerLoginPageActions = new HabrCareerLoginPageActions(driver);
        profileSettingsPageActions = new HabrProfileSettingsPageActions(driver);
    }

    @After
    public void tearDown() {
        logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            LOGGER.info("Google Chrome Log - " + entry);
        }
                driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
