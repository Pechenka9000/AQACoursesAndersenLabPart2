package school.lesson14.habrTests;

import au.com.bytecode.opencsv.CSVWriter;
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.fail;

public class HabrTestConfig {
    protected WebDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(HabrTest.class.getName());
    protected static final Logger LOGGER1 = LoggerFactory.getLogger(HabrTest.class.getName());
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
    public static final String PATH = new File("src/test/log/browserLogFile.log").getAbsolutePath();

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
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(caps);

        /////
        /*ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.CAPABILITY, getCap());
        driver = new ChromeDriver(options);

         */
        ////
        //driver = new ChromeDriver();
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
        /*LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        */
        /////
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println("браузерныйЛог" + entry);
            LOGGER1.info("лог браузера - " + entry);
            LOGGER1.info("лог браузера - " + entry.toString());
        }
        /////
        /*FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler(PATH);
            BROWSER_LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            // the following statement is used to log any messages
            BROWSER_LOGGER.info("My first log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

         */
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    /*private static void filterLog(LogEntries entries) {
        List<LogEntry> logs = new ArrayList<>();
        for (LogEntry entry : entries) {
                System.out.println(entry);
                LOGGER1.info(entry.toString());
                logs.add(entry);
        }

     */


}
