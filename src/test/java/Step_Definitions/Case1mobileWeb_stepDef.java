package Step_Definitions;

import Pages.SalesPage;
import Utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class Case1mobileWeb_stepDef {

    SalesPage salesPage = new SalesPage();

    @When("User can click Satılık")
    public void userCanClickSatılık() {
        salesPage.mobileSatılıkbutton.click();
        BrowserUtils.waitFor(3);


    }

    @And("user can click filtrele button")
    public void userCanClickFiltreleButton() {


            salesPage.mobileFiltreleButton.isDisplayed();
            salesPage.mobileFiltreleButton.click();


    }

    @When("user can select il İzmir")
    public void userCanSelectIlİzmir() {
        salesPage.selectİlSeçinizMenu.click();
        salesPage.mobileIlAraInput.sendKeys("İzmir");
        salesPage.mobileİzmirCheckBox.click();

    }

    @When("user can click Tamam Button")
    public void user_can_click_tamam_button() {
       salesPage.mobileFilterConfirmButton.click();
        BrowserUtils.waitFor(2);
    }
    @When("user can write {string}")
    public void user_can_write(String bornovaText) {
       BrowserUtils.clickWithJS(salesPage.mobileİlçeSeçinizMenu);
       BrowserUtils.waitFor(3);
      //  salesPage.mobileIlçeAraInput.sendKeys(bornovaText);

    }
    @When("user can click ilçe Bornova")
    public void user_can_click_ilçe_bornova() {
        BrowserUtils.waitForClickability(salesPage.mobileBornovaCheckbox,10);
       salesPage.mobileBornovaCheckbox.click();
       BrowserUtils.waitFor(3);
    }
    @When("user can click İşyeri")
    public void user_can_click_işyeri() {
        BrowserUtils.scrollToElement(salesPage.mobileIşyeriRadioButton);
        salesPage.mobileIşyeriRadioButton.click();
        BrowserUtils.waitFor(5);
    }


    @And("user can write low price")
    public void userCanWriteLowPrice() {

        BrowserUtils.scrollToElement(salesPage.mobileLowPrice);
        salesPage.mobileLowPrice.sendKeys("1000000");


    }

    @And("user can write high price")
    public void userCanWriteHighPrice() {
        salesPage.mobileHighPrice.sendKeys("20000000");
    }

    @And("user can select bina yaşı")
    public void userCanSelectBinaYaşı() {
        BrowserUtils.scrollToElement(salesPage.mobileBuildingAgeMenu);
        salesPage.mobileBuildingAgeMenu.click();
        BrowserUtils.clickWithJS(salesPage.mobileSıfırBinaOption);


    }

    @And("user can select  kat sayısı")
    public void userCanSelectKatSayısı() {
      //  salesPage.mobileBirBeşArasıOption.click();
       // salesPage.mobileAltıOnArasıOption.click();

       // boolean check;
       /* BrowserUtils.selectCheckBox(salesPage.mobileBirBeşArasıOption,false);
        BrowserUtils.waitFor(3);
        BrowserUtils.selectCheckBox(salesPage.mobileAltıOnArasıOption,false);
        BrowserUtils.waitFor(4);*/


        BrowserUtils.scrollToElement(salesPage.mobilefloorCountMenu);
        salesPage.mobilefloorCountMenu.click();

        BrowserUtils.clickWithJS(salesPage.mobileBirBeşArasıOption);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(salesPage.mobileAltıOnArasıOption);
        BrowserUtils.waitFor(4);
    }
    @Then("user should see result {string}")
    public void userShouldSeeResult(String expectedSearchResult) {
        Assert.assertEquals(expectedSearchResult,salesPage.mobileResultTitle.getText());

    }


    @And("user click search butto")
    public void userClickSearchButto() {
        BrowserUtils.waitForClickability(salesPage.getResultButton,4);
        salesPage.getResultButton.click();
        BrowserUtils.waitFor(5);
    }



    @Then("sonuçları doğrula")
    public void sonuçlarıDoğrula(List<String> expectedResult) {
        BrowserUtils.waitFor(2);
        for (int i = 0; i< salesPage.mobileResultFilter.size();i++){
            String actualResult =  salesPage.mobileResultFilter.get(i).getText();
            System.out.println("actualResult = " + actualResult);
            Assert.assertEquals(expectedResult.get(i),actualResult);



        }
    }


}

