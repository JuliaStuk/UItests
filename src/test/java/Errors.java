import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Errors {
    WebDriver driver;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-rryixc-root > div.dp-1dr6zbu-root[data-failed]")
    static WebElement departureDateField;

    public Errors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean isDepartureFieldHighlighted(){
        var color = departureDateField.getCssValue("border-color");
        return color.contains("rgb(213, 0, 98)");
    }
}
