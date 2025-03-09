import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindPageCheck {

    WebDriver driver;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(1) > div > div > input[placeholder='Откуда']")
 WebElement fromField;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-8anvqd-root > div > div:nth-child(4) > div > div > input[placeholder='Куда']")
     WebElement toField;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div.dp-13bei22-root-card > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-rryixc-root > div > input[placeholder='Туда']")
    WebElement departureDateField;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-m018yk-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1qzhqzf-root > div > div.dp-1yftpbu-root > div.dp-9qwv4e-root > div > div.dp-yxigg0-root > div > input[placeholder='Обратно']")
    WebElement returnDateField;

    public FindPageCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

 }