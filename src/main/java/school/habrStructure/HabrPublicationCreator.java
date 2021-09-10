package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrPublicationCreator {
    protected WebDriver driver;
    private static final Logger LOGGER  = LoggerFactory.getLogger(HabrMainPage.class.getName());
    private final By ADD_PUBLICATION_TITLE = By.xpath("//div[@class='ProseMirror']");
    private final By EMPTY_PUBLICATION_PARAGRAPH = By.xpath("//div[@class='node node_paragraph is-empty']");
    private final By FILED_PUBLICATION_PARAGRAPH = By.xpath("//div[@class='node node_paragraph']");
    private final By READY_TO_PUBLICATION_BUTTON = By.xpath("//button[contains(text(),'Готово к публикации')]");
    private final By ADD_PUBLICATION_HUBS = By.xpath("//input[@placeholder='Выберите хабы']");
    private final By DESIRED_HUB = By.xpath("//span[contains(text(),'IT-систем *')]");
    private final By TUTORIAL_OPTION = By.xpath("//div[@class='base-checkbox__square tm-checkbox__square base-checkbox__square_istutorial base-checkbox__square_default-icon']");
    private final By ADD_PUBLICATION_KEY_WARDS = By.xpath("//input[@placeholder='Ключевые слова']");
    private final By DESIRED_KEY_WARD = By.xpath("//div[@class='base-chips__suggest tm-chips-outline__suggest base-chips__suggest_tags ']//div[2]");
    private final By ADD_PUBLICATION_TEXT = By.xpath("//div[@class='node node_paragraph is-empty']");
    private final By PUBLICATION_TEXT = By.xpath("//div[@class='tm-editor__step-2']//div[2]//div[2]");
    private final By SEND_FOR_MODERATION = By.xpath("//button[contains(text(),'Отправить на модерацию')]");

    public HabrPublicationCreator(WebDriver driver) {
        this.driver = driver;
    }

    public void createPublicationStep1(String publicationTitle, String publicationParagraph) {
        driver.findElement(ADD_PUBLICATION_TITLE).sendKeys(publicationTitle);
        LOGGER.info(String.format("Введён текст '%s' в заголовок публикации", publicationTitle));
        driver.findElement(EMPTY_PUBLICATION_PARAGRAPH).click();
        driver.findElement(EMPTY_PUBLICATION_PARAGRAPH).sendKeys(publicationParagraph);
        LOGGER.info(String.format("Введён текст '%s' в параграф публикации", publicationParagraph));
    }

    public void createPublicationStartStep2() {
        driver.findElement(READY_TO_PUBLICATION_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Готово к публикации'");
    }

    public void createPublicationStep2(String desiredWord, String publicationText) {
        driver.findElement(ADD_PUBLICATION_HUBS).sendKeys(desiredWord);
        driver.findElement(DESIRED_HUB).click();
        LOGGER.info("Добавлен хаб");
        driver.findElement(TUTORIAL_OPTION).click();
        LOGGER.info("Выбрана опция 'Tutorial'");
        driver.findElement(ADD_PUBLICATION_KEY_WARDS).sendKeys(desiredWord);
        driver.findElement(DESIRED_KEY_WARD).click();
        LOGGER.info("Добавлены 'ключевые слова'");
        driver.findElement(ADD_PUBLICATION_TEXT).sendKeys(publicationText);
        LOGGER.info(String.format("Введён текст '%s' в публикацию - ", publicationText));
    }

    public void createPublicationCompletion() {
        driver.findElement(SEND_FOR_MODERATION).click();
        LOGGER.info("Осуществлен клик по кнопке 'Отправить на модерацию'");
    }

    public By getADD_PUBLICATION_TITLE() {
        return ADD_PUBLICATION_TITLE;
    }

    public By getFILED_PUBLICATION_PARAGRAPH() {
        return FILED_PUBLICATION_PARAGRAPH;
    }

    public By getADD_PUBLICATION_HUBS() {
        return ADD_PUBLICATION_HUBS;
    }

    public By getADD_PUBLICATION_KEY_WARDS() {
        return ADD_PUBLICATION_KEY_WARDS;
    }

    public By getADD_PUBLICATION_TEXT() {
        return ADD_PUBLICATION_TEXT;
    }

    public By getSEND_FOR_MODERATION() {
        return SEND_FOR_MODERATION;
    }

    public By getREADY_TO_PUBLICATION_BUTTON() {
        return READY_TO_PUBLICATION_BUTTON;
    }

    public By getPUBLICATION_TEXT() {
        return PUBLICATION_TEXT;
    }
}
