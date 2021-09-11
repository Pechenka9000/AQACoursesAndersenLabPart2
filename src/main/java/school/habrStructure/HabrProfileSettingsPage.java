package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrProfileSettingsPage {
    protected WebDriver driver;
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrProfileSettingsPage.class.getName());
    private final String NAME   = "Владислав";
    private final String GENDER = "Мужской";
    private final String COUNTY = "Беларусь";
    private final String REGION = "Витебская обл.";
    private final String CITY   = "Полоцк";
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

    public void changeAndSaveProfileSettings(String name, String gender, String country, String region, String city) {
        driver.findElement(REAL_NAME_RAW).clear();
        driver.findElement(REAL_NAME_RAW).sendKeys(name);
        LOGGER.info(String.format("Введён текст '%s' в поле 'Настоящее имя'", name));
        driver.findElement(GENDER_SELECTOR).click();
        LOGGER.info("Осуществлен клик в ячейку 'Пол'");
        driver.findElement(By.xpath(String.format(XPATH_SELECTOR_FINDER, gender))).click();
        LOGGER.info(String.format("Выбран пол - '%s'", gender));
        driver.findElement(COUNTRY_SELECTOR).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - страна'");
        driver.findElement(By.xpath(String.format(XPATH_SELECTOR_FINDER, country))).click();
        LOGGER.info(String.format("Выбрана страна - '%s'", country));
        driver.findElement(REGION_SELECTOR).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - регион'");
        driver.findElement(By.xpath(String.format(XPATH_SELECTOR_FINDER, region))).click();
        LOGGER.info(String.format("Выбран регион - '%s'", region));
        driver.findElement(CITY_SELECTOR).click();
        LOGGER.info("Осуществлен клик в ячейку 'Местоположение - город'");
        driver.findElement(By.xpath(String.format(XPATH_SELECTOR_FINDER, city))).click();
        LOGGER.info(String.format("Выбран город - '%s'", city));
        driver.findElement(SAVE_CHANGES_BUTTON).click();
        LOGGER.info("Осуществлен клик по кнопке 'Сохранить изменения'");
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
