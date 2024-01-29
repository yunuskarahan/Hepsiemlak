package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    @FindBy(xpath = "(//ul/li/a[@class='btn btn-search'])[1]")
    public WebElement satılıkButton;

    @FindBy(xpath = "//div[@class='link-sliding']/a/aside/*[contains(text(),'Satılık')]")
    public WebElement mobileSatılıkbutton;

    @FindBy(xpath = "(//ul/li/a[@class='btn btn-search'])[2]")
    public WebElement kiralıkButton;

    @FindBy(xpath = "//div[@class='link-sliding']/a/aside/*[contains(text(),'Kiralık')]")
    public WebElement mobileKiralıkbutton;




    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


}

