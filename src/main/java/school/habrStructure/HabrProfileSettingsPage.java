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
}
