package Step_Definitions;

import Pages.SalesPage;
import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

import static Utilities.ConfigurationReader.getProperty;


public class Case1_stepDef {
    SalesPage salesPage = new SalesPage();

    @Given("Navigate to Home Page")
    public void navigate_to_home_page() {
        Driver.getDriver().get(getProperty("url"));


    }

    @When("User can click Satılık button")
    public void userCanClickSatılıkButton() {

        salesPage.satılıkButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("Verify the user {string}")
    public void verify_the_user(String expectedSatılıkUrl) {
       /* String actualSatılıkUrl =Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedSatılıkUrl,actualSatılıkUrl);*/

        BrowserUtils.verifyURLContains(expectedSatılıkUrl);

    }

    @When("user can select il {string}")
    public void userCanSelectIl(String ilText) {
        salesPage.selectİlSeçinizMenu.click();
        salesPage.ilAraInput.sendKeys(ilText);
        salesPage.izmirRadioButton.click();

    }

    @And("user can select ilçe  {string}")
    public void userCanSelectIlçe(String ilçeText) {
        BrowserUtils.waitForClickability(salesPage.selectİlçeSeçinizMenu, 5);
        salesPage.selectİlçeSeçinizMenu.click();
        salesPage.ilçeAraInput.sendKeys(ilçeText);
        salesPage.bornovaCheckbox.click();


    }

    @And("user can select İşyeri")
    public void userCanSelectİşyeri() {

        BrowserUtils.scrollToElement(salesPage.işYeriRadioButton);
        salesPage.işYeriRadioButton.click();
        BrowserUtils.waitFor(2);


    }

    @When("user can write low price {string}")
    public void user_can_write_low_price(String lowPrice) {

        salesPage.priceMinInput.sendKeys("1000000");

     //   BrowserUtils.executeJavaScript(Driver.getDriver(), "arguments[0].value='100000'", salesPage.priceMinInput);


    }

    @And("user can write high price {string}")
    public void userCanWriteHighPrice(String highPrice) {


        salesPage.priceMaxInput.sendKeys("20000000");
        //BrowserUtils.executeJavaScript(Driver.getDriver(), "arguments[0].value='20.000.000'", salesPage.priceMaxInput);

        BrowserUtils.waitFor(2);
    }

    @And("user can select bina yaşı {string}")
    public void userCanSelectBinaYaşı(String binaYaşıText) {

       BrowserUtils.scrollToElement(salesPage.buildingAgeSecBox);
        salesPage.buildingAgeSecBox.click();
       salesPage.sıfırBinaOptions.click();
       BrowserUtils.waitFor(1);
    }

    @When("user can select {string} and {string}")
    public void user_can_select_and(String string, String string2) {

        BrowserUtils.scrollToElement(salesPage.katSeçinizMenu);
        BrowserUtils.waitForClickability(salesPage.katSeçinizMenu,5);
       // salesPage.katSeçinizMenu.click();
        BrowserUtils.clickWithJS(salesPage.katSeçinizMenu);
        salesPage.birBeşArasıOption.click();
        salesPage.altıOnArası.click();
        BrowserUtils.waitFor(1);

    }

    @When("user click search button")
    public void user_click_search_button() {

        BrowserUtils.waitForClickability(salesPage.searchButton,5);
        salesPage.searchButton.click();

    }


    @Then("sonuçlar aynı olacak")
    public void sonuçlarAynıOlacak(List<String> expectedResult) {
        BrowserUtils.waitFor(2);
        for (int i = 0; i< salesPage.resultFilter.size();i++){
            String actualResult =  salesPage.resultFilter.get(i).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(expectedResult.get(i),actualResult);



        }
    }
}
