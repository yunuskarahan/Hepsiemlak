package Step_Definitions;

import Pages.KiralıkPage;
import Pages.SalesPage;
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

    KiralıkPage kiralıkPage = new KiralıkPage();
    SalesPage salesPage = new SalesPage();

    @When("user can click kiralık button")
    public void userCanClickKiralıkButton() {
        kiralıkPage.mobileKiralıkbutton.click();
        BrowserUtils.waitFor(2);

    }

    @And("user can select mobile il  Ankara")
    public void userCanSelectMobileIlAnkara() {
        salesPage.selectİlSeçinizMenu.click();
        salesPage.mobileIlAraInput.sendKeys("Ankara");
        kiralıkPage.mobileIlAnkaraButton.click();
        BrowserUtils.waitFor(4);
    }

    @And("user can click ilçe Çankaya")
    public void userCanClickIlçeÇankaya() {
        salesPage.mobileİlçeSeçinizMenu.click();
       // salesPage.mobileIlçeAraInput.sendKeys("Çankaya");
        BrowserUtils.waitForClickability(kiralıkPage.mobileIlçeÇankayaButton,15);

      kiralıkPage.mobileIlçeÇankayaButton.click();

    }

    @And("user can click Konut")
    public void userCanClickKonut() {
        BrowserUtils.scrollToElement(kiralıkPage.mobileKonutRadioButton);

        if (kiralıkPage.mobileKonutRadioButton.isSelected()){
            System.out.println("Konut seçili");
        }else {
            kiralıkPage.mobileKonutRadioButton.click();
        }

        BrowserUtils.waitFor(3);
    }

    @And("user can click oda sayısı iki artı bir")
    public void userCanClickOdaSayısıIkiArtıBir() {
        BrowserUtils.scrollToElement(kiralıkPage.mobileRoomTypeMenu);

        kiralıkPage.mobileRoomTypeMenu.click();
        BrowserUtils.clickWithJS(kiralıkPage.mobileIkıArtıBirCheckbox);
        BrowserUtils.waitFor(2);

    }

    @And("user can click site içerisinde yes")
    public void userCanClickSiteIçerisindeYes() {
        BrowserUtils.scrollToElement(kiralıkPage.mobileWithinSiteMenu);
        kiralıkPage.mobileWithinSiteMenu.click();
        BrowserUtils.clickWithJS(kiralıkPage.mobileEvetRadioButton);
        BrowserUtils.waitFor(2);
    }


    @Then("user should see {string} in the mobile")
    public void userShouldSeeInTheMobile(String expectedResultTitle) {

        Assert.assertEquals(expectedResultTitle,kiralıkPage.mobileResultSearchText.getText());


    }

    @Then("user should see show phone number in the mobile")
    public void userShouldSeeShowPhoneNumberInTheMobile() {
        Assert.assertTrue(kiralıkPage.mobileShowCallButton.isDisplayed());

    }

    @And("user can clik show phone number in the mobile")
    public void userCanClikShowPhoneNumberInTheMobile() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(kiralıkPage.mobileCallButton.size());
        kiralıkPage.mobileCallButton.get(randomIndex).click();
        BrowserUtils.waitFor(5);
    }

    @Then("user should see phone number and verify validate phone number in the mobile")
    public void userShouldSeePhoneNumberAndVerifyValidatePhoneNumberInTheMobile() {
        for (WebElement element : kiralıkPage.mobileListPhoneNumber){
            String actualListPhoneNumber = element.getAttribute("href");
            System.out.println("actualListPhoneNumber = " + actualListPhoneNumber);

            String phoneRegex = "^tel://+90(//d{10})$";

            Pattern pattern = Pattern.compile(phoneRegex);
            Matcher matcher = pattern.matcher(actualListPhoneNumber);

            if (matcher.find()){
                Assert.assertTrue(matcher.matches());
                System.out.println("telefon numarası doğru formatta " + actualListPhoneNumber);
            }else {
                System.out.println("telefon numarası yanlış formatta :" + actualListPhoneNumber);
            }
        }


    }
}
