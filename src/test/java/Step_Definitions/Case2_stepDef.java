package Step_Definitions;

import Pages.KiralıkPage;
import Pages.SalesPage;
import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Case2_stepDef {
    KiralıkPage kiralıkPage = new KiralıkPage();
    SalesPage salesPage = new SalesPage();

    @When("User can click Kiralık button")
    public void user_can_click_kiralık_button() {
        kiralıkPage.kiralıkButton.click();
        BrowserUtils.waitFor(3);




    }

    @When("user can select il Ankara")
    public void user_can_select_il_ankara() {
        kiralıkPage.ilseçinizButton.click();
        salesPage.ilAraInput.sendKeys("Ankara");
        kiralıkPage.ankaraButton.click();




    }

    @When("user can select ilçe Çankaya")
    public void user_can_select_ilçe_çankaya() {
     BrowserUtils.clickWithJS(salesPage.selectİlçeSeçinizMenu);
      // salesPage.selectİlçeSeçinizMenu.click();
       salesPage.ilçeAraInput.sendKeys("Çankaya");
       kiralıkPage.çankayaButton.click();
       BrowserUtils.waitFor(1);

    }

    @When("user can select Konut")
    public void user_can_select_konut() {
        BrowserUtils.scrollToElement(kiralıkPage.konutRadioButton);

        if (kiralıkPage.konutRadioButton.isSelected()){
            System.out.printf("Konut Otomatik Seçili");
        }else{
            kiralıkPage.konutRadioButton.click();
        }
        BrowserUtils.waitFor(3);


    }

    @And("user can select iki artı bir")
    public void userCanSelectIkiArtıBir() {
        BrowserUtils.scrollToElement(kiralıkPage.odaSayısıSeçiniz);
        kiralıkPage.odaSayısıSeçiniz.click();
        kiralıkPage.ikiArtıBir.click();
    }

    @When("user can select evet in site içerisinde")
    public void user_can_select_evet_in_site_içerisinde() {
        BrowserUtils.scrollToElement(kiralıkPage.siteİçerisindeMenu);
        kiralıkPage.siteİçerisindeMenu.click();
        kiralıkPage.evetRadioButton.click();

    }

    @When("user can click search button")
    public void user_can_click_search_button() {
        salesPage.searchButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("user should see {string}")
    public void user_should_see(String expectedResultFilter) {
        String actualResultfilter = kiralıkPage.resultSearchText.getText();
        System.out.println("actualResultfilter = " + actualResultfilter);
        Assert.assertEquals(expectedResultFilter,actualResultfilter);

    }

    @Then("user can click page {int}")
    public void user_can_click_page(Integer int1) {

        BrowserUtils.scrollToElement(kiralıkPage.pageUçLink);
        BrowserUtils.clickWithJS(kiralıkPage.pageUçLink);
        BrowserUtils.waitFor(2);

    }

    @Then("user should see page {string}")
    public void user_should_see_page(String expectedPageUrl) {
        String actualPageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualPageUrl.contains(expectedPageUrl));

    }

    @Then("user should see show phone number")
    public void user_should_see_show_phone_number() {
        Assert.assertTrue(kiralıkPage.showPhoneNumberButton.isDisplayed());

    }

    @Then("user can clik show phone number")
    public void user_can_clik_show_phone_number() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(kiralıkPage.phoneNumberButton.size());
        kiralıkPage.phoneNumberButton.get(randomIndex).click();
        BrowserUtils.waitFor(5);


    }

    @Then("user should see phone number and verify validate phone number")
    public void user_should_see_phone_number_and_verify_validate_phone_number() {
       for (WebElement element : kiralıkPage.listPhoneNumber){
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
