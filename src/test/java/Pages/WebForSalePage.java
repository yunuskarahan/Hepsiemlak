package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebForSalePage extends BasePage{

    @FindBy(xpath = "//span[@class='applied-filters-list-item' or @class='applied-filters-list-item last--item']")
    public List<WebElement> resultFilter;





}
