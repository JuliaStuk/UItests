import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20));
    InfoMenu infoMenu;
    InformationHoverMenu informationHoverMenu;
    FindFlight findFlight;
    ControlBooking controlBooking;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Kirill/Downloads/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://pobeda.aero/");

        infoMenu = new InfoMenu(driver);
        informationHoverMenu = new InformationHoverMenu(driver);
        findFlight = new FindFlight(driver);
        controlBooking = new ControlBooking(driver);
    }

    @Test
    public void openPobeda() {
        // Заголовок
        Assert.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", infoMenu.getPageTitle());
        // Лого
        Assert.assertTrue(infoMenu.logoCheck());
        //Наводим на инфрормацию
        infoMenu.infoMenu();

        //Проверяем заголовки
        Assert.assertTrue(informationHoverMenu.prepToFlight().contains("Подготовка к полёту"));
        Assert.assertTrue(informationHoverMenu.info().contains("Полезная информация"));
        Assert.assertTrue(informationHoverMenu.aboutCompany().contains("О компании"));
    }

    @Test
    public void controlBooking() {

        controlBooking.scrollControlBooking();

        controlBooking.clickControlBooking();
        Assert.assertTrue("Фамилия клиента", controlBooking.clientSurname());
        Assert.assertTrue("Номер бронирования или билета", controlBooking.numberBooking());
        Assert.assertTrue("Поиск", controlBooking.findSearch());

        ControlBooking.enterClientSurname("Qwerty");
        ControlBooking.enterNumberBooking("XXXXX");
        ControlBooking.clickSearch();
        Assert.assertTrue(ControlBooking.isNumberBooking());
    }

    @Test
    public void findFlight() throws InterruptedException {

        findFlight.scrollFindFlight();

        Assert.assertTrue("Откуда", findFlight.fromField());
        Assert.assertTrue("Куда", findFlight.toField());
        Assert.assertTrue("Туда", findFlight.departureDateField());
        Assert.assertTrue("Обратно", findFlight.returnDateField());

        // Ввод критериев поиска
        FindFlight.enterFrom("Москва");
        FindFlight.enterTo("Санкт-Петербург");

        // Нажатие кнопки поиска
        FindFlight.clickSearch();
        Thread.sleep(500);
        Assert.assertTrue(FindFlight.isDepartureFieldHighlighted());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
