package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.pages.SmartBearOrderPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class SmartBearOrderStepDefinitions {

    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage();
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        smartBearLoginPage.usernameInput.sendKeys("Tester");
        smartBearLoginPage.passwordInput.sendKeys("test");
        smartBearLoginPage.loginButton.click();

        smartBearOrderPage.orderLink.click();
    }

    @Then("User fills out the form as followed")
    public void userFillsOutTheFormAsFollowed() {
        Assert.assertTrue(smartBearOrderPage.orderTable.isDisplayed());
    }


    @When("User selects {string} from product dropdown")
    public void userSelectsFromProductDropdown(String searchValue) {
        Select select=new Select(smartBearOrderPage.productMenu);
        select.selectByVisibleText(searchValue);
    }


    @Then("User enters {string} to quantity")
    public void userEntersToQuantity(String searchValue) {
        smartBearOrderPage.quantity.clear();
        smartBearOrderPage.quantity.sendKeys(searchValue);
    }

    @When("User enters {string} to costumer name")
    public void userEntersToCostumerName(String searchValue) {
        smartBearOrderPage.customerName.sendKeys(searchValue);
    }

    @Then("User enters {string} to street")
    public void userEntersToStreet(String searchValue) {
        smartBearOrderPage.street.sendKeys(searchValue);

    }

    @When("User enters {string} to city")
    public void userEntersToCity(String searchValue) {

        smartBearOrderPage.city.sendKeys(searchValue);
    }

    @Then("User enters {string} to state")
    public void userEntersToState(String searchValue) {

        smartBearOrderPage.state.sendKeys(searchValue);
    }

    @And("User enters {string} to zipcode")
    public void userEntersToZipcode(String searchValue) {

        smartBearOrderPage.zipcode.sendKeys(searchValue);
    }

    @When("User selects {string} as card type")
    public void userSelectsAsCardType(String givenType) {
            if (givenType.equalsIgnoreCase("Visa")){
                smartBearOrderPage.visaCardType.click();
            }else if (givenType.equalsIgnoreCase("MasterCard")){
                smartBearOrderPage.masterCardType.click();
            }else if (givenType.equalsIgnoreCase("American Express")){
                smartBearOrderPage.americanExpressCardType.click();
            }else{
                Assert.assertTrue("INVALID CARD TYPE!",false);
            }
        }

    @Then("User enters {string} to card number")
    public void userEntersToCardNumber(String searchValue) {
        smartBearOrderPage.cardNumber.sendKeys(searchValue);
    }

    @And("User enters {string} to expiration date")
    public void userEntersToExpirationDate(String searchValue) {
        smartBearOrderPage.expireDate.sendKeys(searchValue);
    }

    @Then("User clicks process button")
    public void userClicksProcessButton() {
        smartBearOrderPage.processButton.click();
    }

    @And("User verifies {string} is in the list")
    public void userVerifiesIsInTheList(String searchValue) {

        smartBearOrderPage.viewAllOrdersLink.click();
        String actual=smartBearOrderPage.newOrderName.getText();
        String expected=searchValue;
        Assert.assertTrue(actual.equals(expected));
    }


}
