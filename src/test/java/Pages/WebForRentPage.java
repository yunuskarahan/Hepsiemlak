package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebForRentPage extends BasePage{

    @FindBy(xpath = "//div[@class='applied-filters__title']/h1")
    public WebElement resultSearchText;

    @FindBy(xpath = "//ul[@class='he-pagination__links']/li/a[contains(text(),'3')]")
    public WebElement pageUçLink;

    @FindBy(css = ".telephone-button")
    public WebElement showPhoneNumberButton;

    @FindBy(css = ".telephone-button")
    public List<WebElement> phoneNumberButton;

    @FindBy(xpath = "//ul[@class='list-phone-numbers']/li/a")
    public List<WebElement> listPhoneNumber;


}
