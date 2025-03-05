import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoCheck {

    WebDriver driver;

    @FindBy(css = "img[alt=\"«Авиакомпания «Победа», Группа «Аэрофлот»\"]")
    WebElement logo;

    public LogoCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public boolean logoCheck() {
        return logo.isDisplayed();
    }
}
