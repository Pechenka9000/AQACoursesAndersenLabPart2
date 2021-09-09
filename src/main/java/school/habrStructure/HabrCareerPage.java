package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrCareerPage {
    protected WebDriver driver;
    private HabrMainPage habrMainPage;
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final String habrCareerPage = "https://career.habr.com/";
    private final By HABR_CAREER_PAGE_TITLE   = By.xpath("//a[@title='Хабр Карьера']");
    private final By EDUCATION_BUTTON   = By.xpath("//a[contains(text(),'Образование')]");
    private final By SEARCHER   = By.xpath("//input[@id='search_courses_q']");
    private final By LINK1   = By.xpath("//a[contains(text(),'Автоматизатор тестирования на Java')]");
    private final By LINK2   = By.xpath("//div[@title='Java-разработчик']");

    public HabrCareerPage startCareer() {
        habrMainPage = new HabrMainPage(driver);
        driver.findElement(habrMainPage.getHABR_SERVICES_OPENER()).click();
        LOGGER.info("Осуществлено открытие списка сервисов Хабра");
        driver.findElement(habrMainPage.getCAREER_OPENER()).click();
        LOGGER.info("Осуществлён клик по кнопке 'Карьера'");
        return new HabrCareerPage();
    }

}
