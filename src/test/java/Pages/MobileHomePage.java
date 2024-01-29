package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileHomePage extends BasePage{

    @FindBy(xpath = "//div[@class='link-sliding']/a/aside/*[contains(text(),'Kiralık')]")
    public WebElement mobileKiralıkbutton;

    @FindBy(xpath = "//div[@class='link-sliding']/a/aside/*[contains(text(),'Satılık')]")
    public WebElement mobileSatılıkbutton;
}
