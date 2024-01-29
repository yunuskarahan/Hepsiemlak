package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {



    @FindBy(xpath = "//img[@class='he-logo' and @alt='hepsiemlak']")
    public WebElement hepsiEmlakLogo;








    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


}

