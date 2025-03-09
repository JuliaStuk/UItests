import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFlight {

    WebDriver driver;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(1) > div > div > input[placeholder='Откуда']")
    WebElement fromField;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(4) > div > div > input[placeholder='Куда']")
    WebElement toField;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(1) > div > div > input[placeholder='Откуда']")
    static WebElement enterFrom;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(4) > div > div > input[placeholder='Куда']")
    static WebElement enterTo;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-rryixc-root > div > input[placeholder='Туда']")
    WebElement departureDateField;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-yxigg0-root > div > input[placeholder='Обратно']")
    WebElement returnDateField;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-rryixc-root > div.dp-1dr6zbu-root[data-failed]")
    static WebElement errDepartureDateField;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-4yxucm-root > button")
    static WebElement searchButton;
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div.dp-73uj1a-root-root-tabs > div.dp-n243ru-root-group > button:nth-child(1)")
    WebElement findTickets;


    public FindFlight(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void scrollFindFlight() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(findTickets).perform();
    }

    public boolean fromField() {
        return fromField.isDisplayed();
    }

    public boolean toField() {
        return toField.isDisplayed();
    }

    public boolean departureDateField() {
        return departureDateField.isDisplayed();
    }

    public boolean returnDateField() {
        return returnDateField.isDisplayed();
    }

    public static void enterFrom(String from) {
        enterFrom.sendKeys(from);
        enterFrom.sendKeys(Keys.ARROW_DOWN);
        enterFrom.sendKeys(Keys.ENTER);
    }

    public static void enterTo(String to) {
        enterTo.sendKeys(to);
        enterTo.sendKeys(Keys.ARROW_DOWN);
        enterTo.sendKeys(Keys.ENTER);
    }

    public static void clickSearch() {
        searchButton.click();
    }

    public static boolean isDepartureFieldHighlighted(){
            var color = errDepartureDateField.getCssValue("border-color");
            return color.contains("rgb(213, 0, 98)");
    }
}
