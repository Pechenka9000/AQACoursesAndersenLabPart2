package school.lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1Test {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testTask1() {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        driver.get("https://habr.com/ru/all/");
        driver.manage().window().maximize();
        System.out.println("Осуществлена загрузка сайта");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div")).click();
        System.out.println("Произведён клик на иконку профиля");
        driver.findElement(By.linkText("Войти")).click();
        System.out.println("Произведён клик по кнопке 'Войти'");
        try {
            assertEquals("Вход", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='E-mail'])[1]/preceding::div[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e);
        }
        System.out.println("Верификация текста в заголовке");
        driver.findElement(By.id("email_field")).click();
        driver.findElement(By.id("email_field")).clear();
        driver.findElement(By.id("email_field")).sendKeys("pechenka9000@gmail.com");
        System.out.println("Введён @email");
        driver.findElement(By.id("password_field")).click();
        driver.findElement(By.id("password_field")).clear();
        driver.findElement(By.id("password_field")).sendKeys("Zetju2mkyv");
        System.out.println("Введён пароль");
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/fieldset/div[4]/button")).click();
        System.out.println("Нажата кнопка 'Вход'");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]")));
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/nav/a[1]")).click();
        System.out.println("Выбрана вкладка 'Моя лента'");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"574528\"]/div[1]/h2/a")));
        driver.findElement(By.xpath("//*[@id=\"574528\"]/div[1]/h2/a")).click();
        System.out.println("Открыт пост из ленты");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/main/div/div/div[2]/div[1]/div/div[3]/div/div/button/span[1]")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/main/div/div/div[2]/div[1]/div/div[3]/div/div/button/span[1]")).click();
        System.out.println("Пост добавлен в закладки");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div")).click();
        System.out.println("Осуществлён клик по кнопке профиля");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[5]/a[2]")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[5]/a[2]")).click();
        System.out.println("Осуществлён выход из профиля");
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}


