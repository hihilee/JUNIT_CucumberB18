package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsySearchStepDefinitions {

    EtsySearchPage etsySearchPage=new EtsySearchPage();

    @Given("User is on https://www.etsy.com")
    public void user_is_on_https_www_etsy_com() {
        Driver.getDriver().get("https://www.etsy.com/");
    }

    @Then("User sees title is as expected")
    public void user_sees_title_is_as_expected() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsySearchPage.searchBox.sendKeys("Wooden Spoon");

    }

    @Then("User clicks search button")
    public void userClicksSearchButton() {
        etsySearchPage.searchButton.click();
    }


    @And("User sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Wooden spoon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchValue) {

        etsySearchPage.searchBox.sendKeys(searchValue);
    }

    @And("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String searchValue) {
        String actual=Driver.getDriver().getTitle();
        String expected=searchValue;
        Assert.assertTrue(actual.contains(expected));

    }
}
