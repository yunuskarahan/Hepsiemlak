package Step_Definitions;



import Pages.*;
import Utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Case2mobileWeb_stepDef {




    MobileForRentPage mobileForRentPage = new MobileForRentPage();
    
    MobileHomePage mobileHomePage = new MobileHomePage();
    MobileFilterPage mobileFilterPage = new MobileFilterPage();

    @When("user can click kiralık button")
    public void userCanClickKiralıkButton() {


        mobileHomePage.mobileKiralıkbutton.click();
        BrowserUtils.waitFor(2);

    }

    @And("user can select mobile il  Ankara")
    public void userCanSelectMobileIlAnkara() {
        mobileFilterPage.selectİlSeçinizMenu.click();
        mobileFilterPage.mobileIlAraInput.sendKeys("Ankara");
        mobileFilterPage.mobileIlAnkaraButton.click();
        BrowserUtils.waitFor(2);
    }

    @And("user can click ilçe Çankaya")
    public void userCanClickIlçeÇankaya() {
        mobileFilterPage.mobileİlçeSeçinizMenu.click();
       // salesPage.mobileIlçeAraInput.sendKeys("Çankaya");
        BrowserUtils.waitForClickability(mobileFilterPage.mobileIlçeÇankayaButton,15);

      mobileFilterPage.mobileIlçeÇankayaButton.click();

    }

    @And("user can click Konut")
    public void userCanClickKonut() {
        BrowserUtils.scrollToElement(mobileFilterPage.mobileKonutRadioButton);

        if (mobileFilterPage.mobileKonutRadioButton.isSelected()){
            System.out.println("Konut seçili");
        }else {
            mobileFilterPage.mobileKonutRadioButton.click();
        }

        BrowserUtils.waitFor(2);
    }

    @And("user can click oda sayısı iki artı bir")
    public void userCanClickOdaSayısıIkiArtıBir() {
        BrowserUtils.scrollToElement(mobileFilterPage.mobileRoomTypeMenu);

        mobileFilterPage.mobileRoomTypeMenu.click();
        BrowserUtils.clickWithJS(mobileFilterPage.mobileIkıArtıBirCheckbox);
        //BrowserUtils.waitFor(2);

    }

    @And("user can click site içerisinde yes")
    public void userCanClickSiteIçerisindeYes() {
        BrowserUtils.scrollToElement(mobileFilterPage.mobileWithinSiteMenu);
        mobileFilterPage.mobileWithinSiteMenu.click();
        BrowserUtils.clickWithJS(mobileFilterPage.mobileEvetRadioButton);
       // BrowserUtils.waitFor(2);
    }


    @Then("user should see {string} in the mobile")
    public void userShouldSeeInTheMobile(String expectedResultTitle) {

        Assert.assertEquals(expectedResultTitle,mobileForRentPage.mobileResultSearchText.getText());


    }

    @Then("user should see show phone number in the mobile")
    public void userShouldSeeShowPhoneNumberInTheMobile() {
        Assert.assertTrue(mobileForRentPage.mobileShowCallButton.isDisplayed());

    }

    @And("user can clik show phone number in the mobile")
    public void userCanClikShowPhoneNumberInTheMobile() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(mobileForRentPage.mobileCallButton.size());
        mobileForRentPage.mobileCallButton.get(randomIndex).click();
       // BrowserUtils.waitFor(5);
    }

    @Then("user should see phone number and verify validate phone number in the mobile")
    public void userShouldSeePhoneNumberAndVerifyValidatePhoneNumberInTheMobile() {
        for (WebElement element : mobileForRentPage.mobileListPhoneNumber){
            String actualListPhoneNumber = element.getAttribute("href");
            System.out.println("actualListPhoneNumber = " + actualListPhoneNumber);

            String phoneRegex = "^tel://+90(//d{10})$";

            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(actualListPhoneNumber);

            if (!matcher.find()){
                Assert.assertFalse(matcher.matches());
                System.out.println("telefon numarası doğru formatta " + actualListPhoneNumber);
            }else {
                System.out.println("telefon numarası yanlış formatta :" + actualListPhoneNumber);
            }
        }


    }
}
