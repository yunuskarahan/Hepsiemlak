package Step_Definitions;

import Pages.*;
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

    WebHomePage webHomePage = new WebHomePage();
    WebForSalePage webForSalePage = new WebForSalePage();
    WebFilterPage webFilterPage = new WebFilterPage();




    @Given("Navigate to Home Page")
    public void navigate_to_home_page() {

        Driver.getDriver().get(getProperty("url"));


    }

    @Then("user should see hepsiemlak logo")
    public void userShouldSeeHepsiemlakLogo() {
        Assert.assertTrue(webHomePage.hepsiEmlakLogo.isDisplayed());
    }

    @When("User can click Satılık button")
    public void userCanClickSatılıkButton() {

        webHomePage.satılıkButton.click();
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
        webFilterPage.selectİlSeçinizMenu.click();
        webFilterPage.ilAraInput.sendKeys(ilText);
        webFilterPage.izmirRadioButton.click();
        BrowserUtils.waitFor(3);

    }

    @And("user can select ilçe  {string}")
    public void userCanSelectIlçe(String ilçeText) {
        BrowserUtils.waitForClickability(webFilterPage.selectİlçeSeçinizMenu, 5);
        webFilterPage.selectİlçeSeçinizMenu.click();
        webFilterPage.ilçeAraInput.sendKeys(ilçeText);
        webFilterPage.bornovaCheckbox.click();


    }

    @And("user can select İşyeri")
    public void userCanSelectİşyeri() {

        BrowserUtils.scrollToElement(webFilterPage.işYeriRadioButton);
        webFilterPage.işYeriRadioButton.click();
        BrowserUtils.waitFor(2);

    }

    @When("user can write low price {string}")
    public void user_can_write_low_price(String lowPrice) {

        webFilterPage.priceMinInput.sendKeys(lowPrice);

    }

    @And("user can write high price {string}")
    public void userCanWriteHighPrice(String highPrice) {

        webFilterPage.priceMaxInput.sendKeys(highPrice);

    }

    @And("user can select bina yaşı {string}")
    public void userCanSelectBinaYaşı(String binaYaşıText) {

        BrowserUtils.scrollToElement(webFilterPage.buildingAgeSecBox);
        webFilterPage.buildingAgeSecBox.click();
        webFilterPage.sıfırBinaOptions.click();
    }

    @When("user can select {string} and {string}")
    public void user_can_select_and(String string, String string2) {

        BrowserUtils.scrollToElement(webFilterPage.katSeçinizMenu);
        BrowserUtils.waitForClickability(webFilterPage.katSeçinizMenu, 5);
        BrowserUtils.clickWithJS(webFilterPage.katSeçinizMenu);
        webFilterPage.birBeşArasıOption.click();
        webFilterPage.altıOnArası.click();


    }

    @When("user click search button")
    public void user_click_search_button() {

        BrowserUtils.waitForClickability(webFilterPage.searchButton, 5);
        webFilterPage.searchButton.click();


    }


    @Then("sonuçlar aynı olacak")
    public void sonuçlarAynıOlacak(List<String> expectedResult) {
        BrowserUtils.waitFor(2);
        for (int i = 0; i < webForSalePage.resultFilter.size(); i++) {
            String actualResult = webForSalePage.resultFilter.get(i).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(expectedResult.get(i), actualResult);


        }
    }


}
