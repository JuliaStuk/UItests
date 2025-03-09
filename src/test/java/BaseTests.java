import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20));
    LogoCheck logoCheck;
    InfoMenu infoMenu;
    InformationHoverMenu informationHoverMenu;
    FindPageCheck findPageCheck;
    Search search;
    Errors errors;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Kirill/Downloads/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://pobeda.aero/");
    }

    @Test
    public void openPobeda() throws InterruptedException {
        logoCheck = new LogoCheck(driver);
        infoMenu = new InfoMenu(driver);
        informationHoverMenu = new InformationHoverMenu(driver);
        findPageCheck = new FindPageCheck(driver);
        search = new Search(driver);
        errors = new Errors(driver);

        // Заголовок
        Assert.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", logoCheck.getPageTitle());

        // Лого
        Assert.assertTrue(logoCheck.logoCheck());

        //скролл
        WebElement iframe = driver.findElement(By.cssSelector("div.dp-n243ru-root-group > button:nth-child(1)"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();

        Assert.assertTrue("Откуда", findPageCheck.fromField());
        Assert.assertTrue("Куда", findPageCheck.toField());
        Assert.assertTrue("Туда", findPageCheck.departureDateField());
        Assert.assertTrue("Обратно", findPageCheck.returnDateField());

        // Ввод критериев поиска
        Search.enterFrom("Москва");
        Search.enterTo("Санкт-Петербург");

        // Нажатие кнопки поиска
        Search.clickSearch();
        Thread.sleep(500);
        Assert.assertTrue(Errors.isDepartureFieldHighlighted());
    }
}
