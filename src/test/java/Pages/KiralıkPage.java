package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KiralıkPage extends BasePage{


    @FindBy(xpath = "//div[@class='he-select-base__container']/span[contains(text(),'İl Seçiniz')]")
    public WebElement ilseçinizButton;

    @FindBy(xpath = "//li/a[@title='Ankara Kiralık Ev İlanları']")
    public WebElement ankaraButton;

    @FindBy(xpath = "//li/a[contains(text(),'Çankaya')]")
    public WebElement çankayaButton;

    @FindBy(xpath = "//ul[@class='filter-list']/li/div[@class='md-radio']/a/label[contains(text(),'Konut')]")
    public  WebElement konutRadioButton;

    //*[contains(text(),'Oda Seçiniz')]
    @FindBy(xpath = "//*[contains(text(),'Oda Seçiniz')]")
    public WebElement odaSayısıSeçiniz;

    @FindBy(xpath = "//ul[@class='dropdown-list']/li/label/span[contains(text(),'2+1')]")
    public WebElement ikiArtıBir;

    @FindBy(xpath = "//div[@class='js-within-site-filter']/div//div/div[@class='he-select-base']")
    public WebElement siteİçerisindeMenu;

    @FindBy(xpath = "//ul[@class='he-select__list']/li/span[contains(text(),'Evet')]")
    public WebElement evetRadioButton;


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


    @FindBy(xpath = "(//div[@class='he-select__item']/div/div[contains(text(),'Ankara')])[2]")
    public WebElement mobileIlAnkaraButton;

    @FindBy(xpath = "//span[contains(text(), 'Çankaya')]/../..")
    public WebElement mobileIlçeÇankayaButton;

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



    @FindBy(xpath = "//div[@class='listing-title']/h1")
    public WebElement mobileResultSearchText;

    @FindBy(id = "call-owner")
    public WebElement mobileShowCallButton;

    @FindBy(id = "call-owner")
    public List<WebElement> mobileCallButton;

    @FindBy(xpath = "//div[@class='phone-list']/ul/li/a")
    public List<WebElement> mobileListPhoneNumber;




























}
