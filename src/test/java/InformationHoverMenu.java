import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationHoverMenu {

    WebDriver driver;

    @FindBy(css = "div.dp-ukl30h-root > div > div > div:nth-child(1) > a")
    WebElement prepToFlight;
    @FindBy(css = "div.dp-ukl30h-root > div > div > div:nth-child(2) > a")
    WebElement info;
    @FindBy(css = "div.dp-ukl30h-root > div > div > div:nth-child(3) > a")
    WebElement aboutCompany;

    public InformationHoverMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String prepToFlight() {
        return prepToFlight.getText();
    }

    public String info() {
        return info.getText();
    }

    public String aboutCompany() {
        return aboutCompany.getText();
    }
}
