package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrProfileSettingsPage {
    protected static WebDriver driver;
    protected static final Logger LOGGER  = LoggerFactory.getLogger(HabrProfileSettingsPage.class.getName());
    public static final String NAME   = "Владислав";
    public static final String GENDER = "Мужской";
    public static final String COUNTY = "Беларусь";
    public static final String REGION = "Витебская обл.";
    public static final String CITY   = "Полоцк";
    public static final By REAL_NAME_RAW             = By.xpath("//input[@name='fullname']");
    protected static final By GENDER_SELECTOR           = By.xpath("//select[@name='gender']");
    protected static final By COUNTRY_SELECTOR          = By.xpath("//select[@name='locationCountryId']");
    protected static final By REGION_SELECTOR           = By.xpath("//select[@name='locationRegionId']");
    protected static final By CITY_SELECTOR             = By.xpath("//select[@name='locationCityId']");
    protected static final By SAVE_CHANGES_BUTTON       = By.xpath("//button[contains(text(),'Сохранить изменения')]");
    public static final String XPATH_SELECTOR_FINDER = "//option[contains(text(),'%s')]";

    public String getNAME() {
        return NAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public String getCOUNTY() {
        return COUNTY;
    }

    public String getREGION() {
        return REGION;
    }

    public String getCITY() {
        return CITY;
    }

    public By getREAL_NAME_RAW() {
        return REAL_NAME_RAW;
    }

    public By getGENDER_SELECTOR() {
        return GENDER_SELECTOR;
    }

    public By getCOUNTRY_SELECTOR() {
        return COUNTRY_SELECTOR;
    }

    public By getREGION_SELECTOR() {
        return REGION_SELECTOR;
    }

    public By getCITY_SELECTOR() {
        return CITY_SELECTOR;
    }

    public By getSAVE_CHANGES_BUTTON() {
        return SAVE_CHANGES_BUTTON;
    }

    public String getXPATH_SELECTOR_FINDER() {
        return XPATH_SELECTOR_FINDER;
    }
}
