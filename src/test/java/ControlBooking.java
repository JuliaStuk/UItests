import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlBooking {
    WebDriver driver;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div:nth-child(1) > div > div > input[placeholder='Фамилия клиента']")
     WebElement clientSurname;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div:nth-child(2) > div > div > input[placeholder='Номер бронирования или билета']")
     WebElement numberBooking;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div:nth-child(1) > div > div > input[placeholder='Фамилия клиента']")
    static WebElement enterClientSurname;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div:nth-child(2) > div > div > input[placeholder='Номер бронирования или билета']")
    static WebElement enterNumberBooking;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div.dp-73uj1a-root-root-tabs > div.dp-n243ru-root-group > button:nth-child(3)")
    WebElement controlBooking;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div:nth-child(2) > div > div.dp-qglwxc-root-root")
    static WebElement errNumberBooking;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > form > div > div.dp-1q9prrv-root > button")
    static WebElement searchButton;

    public ControlBooking(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean clientSurname() {
        return clientSurname.isDisplayed();
    }

    public boolean numberBooking() {
        return numberBooking.isDisplayed();
    }

    public static void enterClientSurname(String surname) {
        enterClientSurname.sendKeys(surname);
    }

    public static void enterNumberBooking(String number) {
        enterNumberBooking.sendKeys(number);
    }

    public void scrollControlBooking() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(controlBooking).perform();
    }

    public void clickControlBooking() {
        controlBooking.click();
    }

    public boolean findSearch() {
        return searchButton.isDisplayed();
    }
    public static void clickSearch() {
        searchButton.click();
    }

    public static boolean isNumberBooking(){
            return errNumberBooking.isDisplayed();
        }

}