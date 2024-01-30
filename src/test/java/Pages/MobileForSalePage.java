package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileForSalePage extends BasePage{

    @FindBy(xpath = "//div[@class='val']/p")
    public List<WebElement> mobileResultFilter;

    @FindBy(xpath = "//div[@class='listing-title']/h1")
    public WebElement mobileResultTitle;



}
