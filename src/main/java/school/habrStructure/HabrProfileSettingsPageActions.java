package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HabrProfileSettingsPageActions extends HabrProfileSettingsPage{

    public HabrProfileSettingsPageActions(WebDriver driver) {
        HabrProfileSettingsPage.driver = driver;
    }

    public static void changeAndSaveProfileSettings(String name, String gender, String country, String region, String city) {
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
    }

    public static void clickChangeAndSaveProfileSettings() {
        driver.findElement(SAVE_CHANGES_BUTTON).click();
        LOGGER.info("Осуществлен клик по кнопке 'Сохранить изменения'");
    }
}
