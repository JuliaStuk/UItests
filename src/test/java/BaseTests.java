import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    LogoCheck logoCheck;
    InfoMenu infoMenu;
    InformationHoverMenu informationHoverMenu;

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
    public void openPobeda() {
        logoCheck = new LogoCheck(driver);
        infoMenu = new InfoMenu(driver);
        informationHoverMenu = new InformationHoverMenu(driver);

        // Заголовок
        Assert.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками",logoCheck.getPageTitle());

        // Лого
        Assert.assertTrue(logoCheck.logoCheck());

        //Наводим на инфрормацию
        infoMenu.infoMenu();

        //Проверяем заголовки
        Assert.assertTrue(informationHoverMenu.prepToFlight().contains("Подготовка к полёту"));
        Assert.assertTrue(informationHoverMenu.info().contains("Полезная информация"));
        Assert.assertTrue(informationHoverMenu.aboutCompany().contains("О компании"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
