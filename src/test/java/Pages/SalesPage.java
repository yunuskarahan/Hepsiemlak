package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SalesPage extends BasePage {



    @FindBy(xpath = "//*[contains(text(),'İl Seçiniz')]")
    public WebElement selectİlSeçinizMenu;

    @FindBy(xpath = "//div/input[@placeholder='İl ara']")
    public WebElement ilAraInput;

    @FindBy(xpath = "//li/a[@title='İzmir Satılık Ev İlanları']")
    public WebElement izmirRadioButton;

    @FindBy(xpath = "//div[@class='he-select-base__container']/span[contains(text(),'İlçe Seçiniz')]")
    public WebElement selectİlçeSeçinizMenu;

    @FindBy(xpath = "//div/input[@placeholder='İlçe ara']")
    public WebElement ilçeAraInput;

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

    @FindBy(xpath = "//section[@class='buildingAgeSec']/section/div/div/div/div/ul/li")
    public WebElement buildingAgeDropdownMenu;

    @FindBy(xpath = "//section[@class='buildingAgeSec']/section/div/div/div/div/ul/li/label/span[text()='Sıfır Bina']")
    public WebElement sıfırBinaOptions;

    @FindBy(css = "section.floorCountSec div.custom-select")
    public  WebElement katSeçinizMenu;

    @FindBy(xpath = "(//section[@class='floorCountSec']/section/div/div/div/div/ul/li/label/span)[1]")
    public WebElement birBeşArasıOption;

    @FindBy(xpath = "(//section[@class='floorCountSec']/section/div/div/div/div/ul/li/label/span)[2]")
    public WebElement altıOnArası;

    @FindBy(css = "a.btn.btn-red.btn-large")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@class='applied-filters-list-item' or @class='applied-filters-list-item last--item']")
    public List<WebElement> resultFilter;



     @FindBy(xpath = "//button/span[contains(text(),'Filtrele')]")
    public WebElement mobileFiltreleButton;

    @FindBy(xpath = "//div/input[@placeholder='İlçe Ara']")
    public WebElement mobileIlçeAraInput;


     @FindBy(xpath = "//div[@class='action-btn action-btn__confirm']")
    public WebElement mobileFilterConfirmButton;

     @FindBy(xpath = "//li/div/label[contains(text(),'İşyeri')]")
    public WebElement mobileIşyeriRadioButton;

     @FindBy(xpath = "//span[contains(text(), 'Bornova')]/ancestor::div[@class='he-checkbox']")
    public WebElement mobileBornovaCheckbox;

     @FindBy(xpath = "//div/input[@placeholder='İl Ara']")
    public WebElement mobileIlAraInput;

     @FindBy(xpath = "(//div[@class='he-select__item']/div/div[contains(text(),'İzmir')])[2]")
    public WebElement mobileİzmirCheckBox;

     @FindBy(xpath = "//div[@class='he-select-base__control' and contains(text(),'İlçe Seçiniz')]")
    public WebElement mobileİlçeSeçinizMenu;

     @FindBy(xpath = "(//section[@class='price']/div/div/input)[1]")
    public WebElement mobileLowPrice;

     @FindBy(xpath ="(//section[@class='price']/div/div/input)[2]")
    public WebElement mobileHighPrice;

     @FindBy(xpath = "//section[@class='floor-count']//*[@class='he-select-base__control']")
    public WebElement mobilefloorCountMenu;

     @FindBy(xpath = "//span[contains(text(), '1-5 Arası')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileBirBeşArasıOption;

    @FindBy(xpath = "//span[contains(text(), '6-10 Arası')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileAltıOnArasıOption;

    @FindBy(xpath = "//button[@class='btn btn-red get-result']")
    public WebElement getResultButton;

    @FindBy(xpath = "//section[@class='building-age']//*[@class='he-select-base__control']")
    public WebElement mobileBuildingAgeMenu;

    @FindBy(xpath = "//span[contains(text(), 'Sıfır Bina')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileSıfırBinaOption;

    @FindBy(xpath = "//div[@class='val']/p")
    public List<WebElement> mobileResultFilter;

    @FindBy(xpath = "//div[@class='listing-title']/h1")
    public WebElement mobileResultTitle;














}
