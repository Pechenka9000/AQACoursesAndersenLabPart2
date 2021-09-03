package school.habrStructure;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrProfileSettingsPage {
    protected WebDriver driver;
    private final Logger LOGGER  = LoggerFactory.getLogger(HabrProfileSettingsPage.class.getName());
    private final String NAME = "Владислав";
    private final String GENDER = "Мужской";
    private final String COUNTY = "Беларусь";
    private final String REGION = "Витебская обл.";
    private final String CITY = "Полоцк";

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
}
