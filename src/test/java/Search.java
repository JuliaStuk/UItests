import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
    WebDriver driver;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(1) > div > div > input[placeholder='Откуда']")
    static WebElement fromFieldEnter;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(4) > div > div > input[placeholder='Куда']")
    static WebElement toFieldEnter;

    @FindBy(css = ".dp-1dggv77-root-root")
    static WebElement searchButton;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void enterFrom(String from) {
        fromFieldEnter.sendKeys(from);
        fromFieldEnter.sendKeys(Keys.ARROW_DOWN);
        fromFieldEnter.sendKeys(Keys.ENTER);
    }

    public static void enterTo(String to) {
        toFieldEnter.sendKeys(to);
        toFieldEnter.sendKeys(Keys.ARROW_DOWN);
        toFieldEnter.sendKeys(Keys.ENTER);
    }

    public static void clickSearch() {
        searchButton.click();
    }
}