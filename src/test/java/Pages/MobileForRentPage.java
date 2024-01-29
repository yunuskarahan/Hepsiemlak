package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileForRentPage extends BasePage {


    @FindBy(xpath = "//div[@class='listing-title']/h1")
    public WebElement mobileResultSearchText;

    @FindBy(id = "call-owner")
    public WebElement mobileShowCallButton;

    @FindBy(id = "call-owner")
    public List<WebElement> mobileCallButton;

    @FindBy(xpath = "//div[@class='phone-list']/ul/li/a")
    public List<WebElement> mobileListPhoneNumber;


}
