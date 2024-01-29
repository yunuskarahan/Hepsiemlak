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

public class Case1mobileWeb_stepDef {
    
    
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


        mobileFilterPage.mobileFiltreleButton.isDisplayed();
        mobileFilterPage.mobileFiltreleButton.click();


    }

    @When("user can select il İzmir")
    public void userCanSelectIlİzmir() {
        mobileFilterPage.selectİlSeçinizMenu.click();


        mobileFilterPage.mobileIlAraInput.sendKeys("İzmir");
        mobileFilterPage.mobileİzmirCheckBox.click();

    }

    @When("user can click Tamam Button")
    public void user_can_click_tamam_button() {
        mobileFilterPage.mobileFilterConfirmButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("user can write {string}")
    public void user_can_write(String bornovaText) {
        BrowserUtils.waitForVisibility(mobileFilterPage.mobileİlçeSeçinizMenu, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileİlçeSeçinizMenu);
        //BrowserUtils.waitFor(3);
        //  mobileFilterPage.mobileIlçeAraInput.sendKeys(bornovaText);

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

        BrowserUtils.scrollToElement(mobileFilterPage.mobileLowPrice);
        mobileFilterPage.mobileLowPrice.sendKeys("1000000");


    }

    @And("user can write high price")
    public void userCanWriteHighPrice() {
        mobileFilterPage.mobileHighPrice.sendKeys("20000000");
    }

    @And("user can select bina yaşı")
    public void userCanSelectBinaYaşı() {
        BrowserUtils.scrollToElement(mobileFilterPage.mobileBuildingAgeMenu);
        mobileFilterPage.mobileBuildingAgeMenu.click();
        BrowserUtils.clickWithJS(mobileFilterPage.mobileSıfırBinaOption);


    }

    @And("user can select  kat sayısı")
    public void userCanSelectKatSayısı() {
        //  mobileFilterPage.mobileBirBeşArasıOption.click();
        // mobileFilterPage.mobileAltıOnArasıOption.click();

        // boolean check;
       /* BrowserUtils.selectCheckBox(mobileFilterPage.mobileBirBeşArasıOption,false);
        BrowserUtils.waitFor(3);
        BrowserUtils.selectCheckBox(mobileFilterPage.mobileAltıOnArasıOption,false);
        BrowserUtils.waitFor(4);*/


        BrowserUtils.scrollToElement(mobileFilterPage.mobilefloorCountMenu);
        mobileFilterPage.mobilefloorCountMenu.click();

        BrowserUtils.waitForClickability(mobileFilterPage.mobileBirBeşArasıOption, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileBirBeşArasıOption);

        BrowserUtils.waitForClickability(mobileFilterPage.mobileAltıOnArasıOption, 5);
        BrowserUtils.clickWithJS(mobileFilterPage.mobileAltıOnArasıOption);
        //  BrowserUtils.waitFor(4);
    }

    @Then("user should see result {string}")
    public void userShouldSeeResult(String expectedSearchResult) {
        Assert.assertEquals(expectedSearchResult, mobileForSalePage.mobileResultTitle.getText());

    }


    @And("user click search butto")
    public void userClickSearchButto() {
        BrowserUtils.waitForClickability(mobileForSalePage.getResultButton, 4);
        mobileForSalePage.getResultButton.click();
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

