import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoMenu {
    WebDriver driver;

    public InfoMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div > div.dp-1w2e4gh-root-root > div.dp-1odq4wk-root-root > div.dp-u64fu3-root > a:nth-child(1)")
    WebElement infoMenu;

    public void infoMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(infoMenu).perform();
    }
}
