package school.habrStructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HabrPublicationCreator {
    protected static WebDriver driver;
    protected static final Logger LOGGER  = LoggerFactory.getLogger(HabrPublicationCreator.class.getName());
    protected static final By ADD_PUBLICATION_TITLE = By.xpath("//div[@class='ProseMirror']");
    protected static final By EMPTY_PUBLICATION_PARAGRAPH = By.xpath("//div[@class='node node_paragraph is-empty']");
    public static final By READY_TO_PUBLICATION_BUTTON = By.xpath("//button[contains(text(),'Готово к публикации')]");
    protected static final By ADD_PUBLICATION_HUBS = By.xpath("//input[@placeholder='Выберите хабы']");
    protected static final By DESIRED_HUB = By.xpath("//span[contains(text(),'IT-систем *')]");
    public static final By SELECTED_HUB = By.xpath("//div[@class='base-chips__added tm-chips__added base-chips__added_hubs ']");
    protected static final By TUTORIAL_OPTION = By.xpath("//div[@class='base-checkbox__square tm-checkbox__square base-checkbox__square_istutorial base-checkbox__square_default-icon']");
    protected static final By ADD_PUBLICATION_KEY_WARDS = By.xpath("//input[@placeholder='Ключевые слова']");
    protected static final By DESIRED_KEY_WARD = By.xpath("//div[@class='base-chips__suggest tm-chips-outline__suggest base-chips__suggest_tags ']//div[2]");
    public static final By SELECTED_KEY_WARD = By.xpath("//div[@class='base-chips__added tm-chips-outline__added base-chips__added_tags ']");
    protected static final By ADD_PUBLICATION_TEXT = By.xpath("//div[@class='node node_paragraph is-empty']");
    public static final By PUBLICATION_TEXT = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[10]/div[1]/div[1]/div[4]/div[1]/div[2]/div[2]");
    public static final By SEND_FOR_MODERATION = By.xpath("//button[contains(text(),'Отправить на модерацию')]");
}
