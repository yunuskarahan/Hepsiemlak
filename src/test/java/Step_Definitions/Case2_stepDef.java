package Step_Definitions;

import Pages.*;
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

    WebHomePage webHomePage = new WebHomePage();
    WebFilterPage webFilterPage = new WebFilterPage();

    WebForRentPage webForRentPage = new WebForRentPage();



    @When("User can click Kiralık button")
    public void user_can_click_kiralık_button() {



        webHomePage.kiralıkButton.click();
        BrowserUtils.waitFor(2);


    }

    @When("user can select il Ankara")
    public void user_can_select_il_ankara() {
        webFilterPage.selectİlSeçinizMenu.click();
        webFilterPage.ilAraInput.sendKeys("Ankara");
        webFilterPage.ankaraButton.click();




    }

    @When("user can select ilçe Çankaya")
    public void user_can_select_ilçe_çankaya() {
     BrowserUtils.clickWithJS(webFilterPage.selectİlçeSeçinizMenu);
       webFilterPage.ilçeAraInput.sendKeys("Çankaya");
       webFilterPage.çankayaButton.click();
       BrowserUtils.waitFor(2);


    }

    @When("user can select Konut")
    public void user_can_select_konut() {
        BrowserUtils.scrollToElement(webFilterPage.konutRadioButton);

        if (webFilterPage.konutRadioButton.isSelected()){
            System.out.printf("Konut Otomatik Seçili");
        }else{
            webFilterPage.konutRadioButton.click();
        }
        BrowserUtils.waitFor(2);


    }

    @And("user can select iki artı bir")
    public void userCanSelectIkiArtıBir() {
        BrowserUtils.scrollToElement(webFilterPage.odaSayısıSeçiniz);
        webFilterPage.odaSayısıSeçiniz.click();
        webFilterPage.ikiArtıBir.click();
    }

    @When("user can select evet in site içerisinde")
    public void user_can_select_evet_in_site_içerisinde() {
        BrowserUtils.scrollToElement(webFilterPage.siteİçerisindeMenu);
        webFilterPage.siteİçerisindeMenu.click();
        webFilterPage.evetRadioButton.click();

    }

    @When("user can click search button")
    public void user_can_click_search_button() {
        webFilterPage.searchButton.click();


    }

    @Then("user should see {string}")
    public void user_should_see(String expectedResultFilter) {
        BrowserUtils.waitFor(2);
        String actualResultfilter = webForRentPage.resultSearchText.getText();
        System.out.println("actualResultfilter = " + actualResultfilter);
        Assert.assertEquals(expectedResultFilter,actualResultfilter);

    }

    @Then("user can click page {int}")
    public void user_can_click_page(Integer int1) {

        BrowserUtils.scrollToElement(webForRentPage.pageUçLink);
        BrowserUtils.clickWithJS(webForRentPage.pageUçLink);
        BrowserUtils.waitFor(1);

    }

    @Then("user should see page {string}")
    public void user_should_see_page(String expectedPageUrl) {
        String actualPageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualPageUrl.contains(expectedPageUrl));

    }

    @Then("user should see show phone number")
    public void user_should_see_show_phone_number() {
        Assert.assertTrue(webForRentPage.showPhoneNumberButton.isDisplayed());

    }

    @Then("user can clik show phone number")
    public void user_can_clik_show_phone_number() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(webForRentPage.phoneNumberButton.size());
        webForRentPage.phoneNumberButton.get(randomIndex).click();
        BrowserUtils.waitFor(2);


    }

    @Then("user should see phone number and verify validate phone number")
    public void user_should_see_phone_number_and_verify_validate_phone_number() {
       for (WebElement element : webForRentPage.listPhoneNumber){
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
