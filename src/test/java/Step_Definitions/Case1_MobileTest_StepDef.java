package Step_Definitions;

import Pages.MobileFilterPage;
import Pages.MobileForSalePage;
import Pages.MobileHomePage;
import Utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class Case1_MobileTest_StepDef {
    
    
    MobileHomePage mobileHomePage = new MobileHomePage();
    MobileFilterPage mobileFilterPage = new MobileFilterPage();

    MobileForSalePage mobileForSalePage = new MobileForSalePage();







    @When("User can click Satılık")
    public void userCanClickSatılık() {

        mobileHomePage.mobileSatılıkbutton.click();
        BrowserUtils.waitFor(2);


    }

    @And("user can click filtrele button")
    public void userCanClickFiltreleButton() {

        mobileFilterPage.mobileFilterButton.isDisplayed();
        mobileFilterPage.mobileFilterButton.click();



    }

    @When("user can select il İzmir")
    public void userCanSelectIlİzmir() {


        mobileFilterPage.mobileSelectCityMenu.click();
        mobileFilterPage.mobileSearchCityInput.sendKeys("İzmir");
        mobileFilterPage.mobileIzmirCheckBox.click();

    }

    @When("user can click Tamam Button")
    public void user_can_click_tamam_button() {

        mobileFilterPage.mobileFilterConfirmButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("user can write {string}")
    public void user_can_write(String bornovaText) {

        BrowserUtils.waitForVisibility(mobileFilterPage.mobileSelectCountyMenu, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileSelectCountyMenu);
        //BrowserUtils.waitFor(3);
        mobileFilterPage.mobileSearchCountyInput.sendKeys(bornovaText);

    }

    @When("user can click ilçe Bornova")
    public void user_can_click_ilçe_bornova() {

        BrowserUtils.waitForClickability(mobileFilterPage.mobileBornovaCheckbox, 10);
        mobileFilterPage.mobileBornovaCheckbox.click();

    }

    @When("user can click İşyeri")
    public void user_can_click_işyeri() {

        BrowserUtils.scrollToElement(mobileFilterPage.mobileIşyeriRadioButton);
        mobileFilterPage.mobileIşyeriRadioButton.click();
        BrowserUtils.waitFor(3);
    }


    @And("user can write low price")
    public void userCanWriteLowPrice() {

        BrowserUtils.scrollToElement(mobileFilterPage.mobileLowPriceInput);
        mobileFilterPage.mobileLowPriceInput.sendKeys("1000000");


    }

    @And("user can write high price")
    public void userCanWriteHighPrice() {

        mobileFilterPage.mobileHighPriceInput.sendKeys("20000000");
    }

    @And("user can select bina yaşı")
    public void userCanSelectBinaYaşı() {
        BrowserUtils.scrollToElement(mobileFilterPage.mobileBuildingAgeMenu);
        mobileFilterPage.mobileBuildingAgeMenu.click();
        BrowserUtils.clickWithJS(mobileFilterPage.mobileSıfırBinaOption);


    }

    @And("user can select  kat sayısı")
    public void userCanSelectKatSayısı() {


        BrowserUtils.scrollToElement(mobileFilterPage.mobilefloorCountMenu);
        mobileFilterPage.mobilefloorCountMenu.click();

        BrowserUtils.waitForClickability(mobileFilterPage.mobileBirBeşArasıCheckbox, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileBirBeşArasıCheckbox);

        BrowserUtils.waitForClickability(mobileFilterPage.mobileAltıOnArasıCheckbox, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileAltıOnArasıCheckbox);

    }

    @Then("user should see result {string}")
    public void userShouldSeeResult(String expectedSearchResult) {
        BrowserUtils.waitForVisibility(mobileForSalePage.mobileResultTitle,10);
        Assert.assertEquals(expectedSearchResult, mobileForSalePage.mobileResultTitle.getText());

    }


    @And("user click search butto")
    public void userClickSearchButto() {
        BrowserUtils.waitForClickability(mobileFilterPage.getResultButton, 4);
        mobileFilterPage.getResultButton.click();
        BrowserUtils.waitFor(5);
    }


    @Then("sonuçları doğrula")
    public void sonuçlarıDoğrula(List<String> expectedResult) {
        BrowserUtils.waitFor(2);




        for (int i = 0; i < mobileForSalePage.mobileResultFilter.size(); i++) {
            String actualResult = mobileForSalePage.mobileResultFilter.get(i).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(expectedResult.get(i), actualResult);


        }
    }


}

