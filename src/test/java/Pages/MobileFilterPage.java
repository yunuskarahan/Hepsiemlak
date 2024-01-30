package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MobileFilterPage extends BasePage{


    @FindBy(xpath = "//*[contains(text(),'İl Seçiniz')]")
    public WebElement mobileSelectCityMenu;


    @FindBy(xpath = "//button/span[contains(text(),'Filtrele')]")
    public WebElement mobileFilterButton;


    @FindBy(xpath = "//div[@class='action-btn action-btn__confirm']")
    public WebElement mobileFilterConfirmButton;

    @FindBy(xpath = "//li/div/label[contains(text(),'İşyeri')]")
    public WebElement mobileIşyeriRadioButton;

    @FindBy(xpath = "(//span[contains(text(), 'Bornova')]/ancestor::div[@class='he-checkbox'])[2]")
    public WebElement mobileBornovaCheckbox;


    @FindBy(xpath = "//div/input[@placeholder='İl Ara']")
    public WebElement mobileSearchCityInput;


    @FindBy(xpath = "//div/input[@placeholder='İlçe Ara']")
    public WebElement mobileSearchCountyInput;

    @FindBy(xpath = "(//div[@class='he-select__item']/div/div[contains(text(),'İzmir')])[2]")
    public WebElement mobileIzmirCheckBox;


    @FindBy(xpath = "//div[@class='he-select-base__control' and contains(text(),'İlçe Seçiniz')]")
    public WebElement mobileSelectCountyMenu;

    @FindBy(xpath = "(//section[@class='price']/div/div/input)[1]")
    public WebElement mobileLowPriceInput;

    @FindBy(xpath = "(//section[@class='price']/div/div/input)[2]")
    public WebElement mobileHighPriceInput;

    @FindBy(xpath = "//section[@class='floor-count']//*[@class='he-select-base__control']")
    public WebElement mobilefloorCountMenu;


    @FindBy(xpath = "//span[contains(text(), '1-5 Arası')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileBirBeşArasıCheckbox;

    @FindBy(xpath = "//span[contains(text(), '6-10 Arası')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileAltıOnArasıCheckbox;


    @FindBy(xpath = "//button[@class='btn btn-red get-result']")
    public WebElement getResultButton;

    @FindBy(xpath = "//section[@class='building-age']//*[@class='he-select-base__control']")
    public WebElement mobileBuildingAgeMenu;

    @FindBy(xpath = "//span[contains(text(), 'Sıfır Bina')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileSıfırBinaOption;








    @FindBy(xpath = "(//div[@class='he-select__item']/div/div[contains(text(),'Ankara')])[2]")
    public WebElement mobileCityAnkaraButton;


    @FindBy(xpath = "//span[contains(text(), 'Çankaya')]/../..")
    public WebElement mobileCountyÇankayaButton;

    @FindBy(xpath = "//li/div/label[contains(text(),'Konut')]")
    public WebElement mobileKonutRadioButton;

    @FindBy(xpath = "//section[@class='room-type']//*[@class='he-select-base__control']")
    public WebElement mobileRoomTypeMenu;

    @FindBy(xpath = "//span[contains(text(), '2+1')]/ancestor::div[@class='he-checkbox']/div")
    public WebElement mobileIkıArtıBirCheckbox;

    @FindBy(xpath = "//section[@class='within-site']//*[@class='he-select-base']")
    public WebElement mobileWithinSiteMenu;

    @FindBy(xpath = "//div[@class='he-select__item']/div[@class='he-radio-button']/div[contains(text(),'Evet')]")
    public WebElement mobileEvetRadioButton;





}
