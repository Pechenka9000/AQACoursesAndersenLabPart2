package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrProfileSettingsPage {
    protected WebDriver driver;
    private final String NAME   = "Владислав";
    private final String GENDER = "Мужской";
    private final String COUNTY = "Беларусь";
    private final String REGION = "Витебская обл.";
    private final String CITY   = "Полоцк";
    private final By PROFILE_SETTINGS_BUTTON   = By.xpath("//span[contains(text(),'Настройки профиля')]");
    private final By REAL_NAME_RAW             = By.xpath("//input[@name='fullname']");
    private final By GENDER_SELECTOR           = By.xpath("//select[@name='gender']");
    private final By COUNTRY_SELECTOR          = By.xpath("//select[@name='locationCountryId']");
    private final By REGION_SELECTOR           = By.xpath("//select[@name='locationRegionId']");
    private final By CITY_SELECTOR             = By.xpath("//select[@name='locationCityId']");
    private final By SAVE_CHANGES_BUTTON       = By.xpath("//button[contains(text(),'Сохранить изменения')]");
    private final String XPATH_SELECTOR_FINDER = "//option[contains(text(),'%s')]";

    public HabrProfileSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public By getPROFILE_SETTINGS_BUTTON() {
        return PROFILE_SETTINGS_BUTTON;
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
