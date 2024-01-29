package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends BasePage{


    @FindBy(xpath = "(//ul/li/a[@class='btn btn-search'])[1]")
    public WebElement satılıkButton;

    @FindBy(xpath = "(//ul/li/a[@class='btn btn-search'])[2]")
    public WebElement kiralıkButton;
}
