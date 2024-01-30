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
import static config.ConfigFactory.getConfig;


public class Case1_WebTest_StepDef {

    WebHomePage webHomePage = new WebHomePage();
    WebForSalePage webForSalePage = new WebForSalePage();
    WebFilterPage webFilterPage = new WebFilterPage();
    MobileForSalePage mobileForSalePage = new MobileForSalePage();




    @Given("Navigate to Home Page")
    public void navigate_to_home_page() {

        Driver.getDriver().get(getProperty("url"));


    }

    @Then("user should see hepsiemlak logo")
    public void userShouldSeeHepsiemlakLogo() {

        if (webHomePage.cookieCloseButton.isDisplayed()){
            webHomePage.cookieCloseButton.click();
            Assert.assertTrue(webHomePage.hepsiEmlakLogo.isDisplayed());
        }else{
            Assert.assertTrue(webHomePage.hepsiEmlakLogo.isDisplayed());
        }

    }

    @When("User can click Satılık button")
    public void userCanClickSatılıkButton() {

        webHomePage.satılıkButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("Verify the user {string}")
    public void verify_the_user(String expectedSatılıkUrl) {

        BrowserUtils.verifyURLContains(expectedSatılıkUrl);

    }

    @When("user can select il {string}")
    public void userCanSelectIl(String ilText) {

        webFilterPage.getSelectCity(ilText);

        if (ilText.equalsIgnoreCase("İzmir")){
        webFilterPage.izmirRadioButton.click();
        } else if (ilText.equalsIgnoreCase("Ankara")) {
            webFilterPage.cityAnkaraButton.click();
        }else {
            System.out.println("İl text Boş");
        }
        BrowserUtils.waitFor(2);

    }

    @And("user can select ilçe  {string}")
    public void userCanSelectIlçe(String ilçeText) {
        BrowserUtils.waitForClickability(webFilterPage.selectİlçeSeçinizMenu, 5);

       webFilterPage.getSelectCount(ilçeText);
       if (ilçeText.equalsIgnoreCase("Bornova")) {
           webFilterPage.bornovaCheckbox.click();
       } else if (ilçeText.equalsIgnoreCase("Çankaya")) {
           webFilterPage.countyÇankayaButton.click();
       }else {
           System.out.println("ilçe text boş");
       }




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
        webFilterPage.sıfırBinaCheckBox.click();
    }

    @When("user can select {string} and {string}")
    public void user_can_select_and(String string, String string2) {

        BrowserUtils.scrollToElement(webFilterPage.selectFloorCount);
        BrowserUtils.waitForClickability(webFilterPage.selectFloorCount, 5);
        BrowserUtils.clickWithJS(webFilterPage.selectFloorCount);
        webFilterPage.birBeşArasıCheckBox.click();
        webFilterPage.altıOnArasıCheckBox.click();


    }

    @When("user click search button")
    public void user_click_search_button() {

        BrowserUtils.waitForClickability(webFilterPage.searchButton, 5);
        webFilterPage.searchButton.click();


    }


    @Then("the user should see that the search results are accurate")
    public void theUserShouldSeeThatTheSearchResultsAreAccurate(List<String> expectedResult) {

        BrowserUtils.waitFor(2);

        String mobileAgent = getConfig().status();

        if (mobileAgent != null && mobileAgent.equalsIgnoreCase("true")){
            for (int i = 0; i < webForSalePage.resultFilter.size(); i++) {
                String actualResult = webForSalePage.resultFilter.get(i).getText();
                System.out.println("actualResult = " + actualResult);
                Assert.assertEquals(expectedResult.get(i), actualResult);


            }
        } else {


            for (int i = 0; i < mobileForSalePage.mobileResultFilter.size(); i++) {
                String actualResult = mobileForSalePage.mobileResultFilter.get(i).getText();
                System.out.println("actualResult = " + actualResult);
                Assert.assertEquals(expectedResult.get(i), actualResult);


            }

        }


    }





}
