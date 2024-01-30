package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebFilterPage extends BasePage{




    @FindBy(xpath = "//*[contains(text(),'İl Seçiniz')]")
    public WebElement selectCityMenu;

    @FindBy(xpath = "//div/input[@placeholder='İl ara']")
    public WebElement searchCityInput;







    @FindBy(xpath = "//li/a[@title='İzmir Satılık Ev İlanları']")
    public WebElement izmirRadioButton;

    @FindBy(xpath = "//div[@class='he-select-base__container']/span[contains(text(),'İlçe Seçiniz')]")
    public WebElement selectİlçeSeçinizMenu;

    @FindBy(xpath = "//div[@class='he-select-base__container']/span[contains(text(),'İlçe Seçiniz')]")
    public WebElement selectCountyMenu;

    @FindBy(xpath = "//div/input[@placeholder='İlçe ara']")
    public WebElement searchCountyInput;



    @FindBy(xpath = "//li/a[contains(text(),'Bornova')]")
    public WebElement bornovaCheckbox;

    @FindBy(xpath = "//li/div/a[@title='Satılık İşyeri']")
    public WebElement işYeriRadioButton;

    @FindBy(id = "priceMin")
    public WebElement priceMinInput;

    @FindBy(id = "priceMax")
    public WebElement priceMaxInput;

    @FindBy(xpath = "//div[@class='custom-select']//*[contains(text(),'Bina Yaşı')]")
    public WebElement buildingAgeSecBox;


    @FindBy(xpath = "//section[@class='buildingAgeSec']/section/div/div/div/div/ul/li/label/span[text()='Sıfır Bina']")
    public WebElement sıfırBinaCheckBox;


    @FindBy(css = "section.floorCountSec div.custom-select")
    public WebElement selectFloorCount;

    @FindBy(xpath = "(//section[@class='floorCountSec']/section/div/div/div/div/ul/li/label/span)[1]")
    public WebElement birBeşArasıCheckBox;

    @FindBy(xpath = "(//section[@class='floorCountSec']/section/div/div/div/div/ul/li/label/span)[2]")
    public WebElement altıOnArasıCheckBox;

    @FindBy(css = "a.btn.btn-red.btn-large")
    public WebElement searchButton;

    @FindBy(xpath = "//li/a[@title='Ankara Kiralık Ev İlanları']")
    public WebElement cityAnkaraButton;

    @FindBy(xpath = "//li/a[contains(text(),'Çankaya')]")
    public WebElement countyÇankayaButton;

    @FindBy(xpath = "//ul[@class='filter-list']/li/div[@class='md-radio']/a/label[contains(text(),'Konut')]")
    public  WebElement konutRadioButton;

    @FindBy(xpath = "//*[contains(text(),'Oda Seçiniz')]")
    public WebElement roomTypeMenu;

    @FindBy(xpath = "//ul[@class='dropdown-list']/li/label/span[contains(text(),'2+1')]")
    public WebElement ikiArtıBirCheckBox;


    @FindBy(xpath = "//div[@class='js-within-site-filter']/div//div/div[@class='he-select-base']")
    public WebElement withinSiteMenu;

    @FindBy(xpath = "//ul[@class='he-select__list']/li/span[contains(text(),'Evet')]")
    public WebElement evetRadioButton;


    public void getSelectCity(String cityName){
        selectCityMenu.click();
        searchCityInput.sendKeys(cityName);
    }

    public void getSelectCount(String countyName){

        selectCountyMenu.click();
        searchCountyInput.sendKeys(countyName);
    }



}
