package school.habrStructure;

import org.openqa.selenium.WebDriver;

public class HabrPublicationCreatorActions extends HabrPublicationCreator{

    public HabrPublicationCreatorActions(WebDriver driver) {
        HabrPublicationCreator.driver = driver;
    }

    public static void createPublicationStep1(String publicationTitle, String publicationParagraph) {
        driver.findElement(ADD_PUBLICATION_TITLE).sendKeys(publicationTitle);
        LOGGER.info(String.format("Введён текст '%s' в заголовок публикации", publicationTitle));
        driver.findElement(EMPTY_PUBLICATION_PARAGRAPH).click();
        driver.findElement(EMPTY_PUBLICATION_PARAGRAPH).sendKeys(publicationParagraph);
        LOGGER.info(String.format("Введён текст '%s' в параграф публикации", publicationParagraph));
    }

    public static void createPublicationStartStep2() {
        driver.findElement(READY_TO_PUBLICATION_BUTTON).click();
        LOGGER.info("Осуществлён клик по кнопке 'Готово к публикации'");
    }

    public static void createPublicationStep2(String desiredWord, String publicationText) {
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

    public static void createPublicationCompletion() {
        driver.findElement(SEND_FOR_MODERATION).click();
        LOGGER.info("Осуществлен клик по кнопке 'Отправить на модерацию'");
    }
}
