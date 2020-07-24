package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {
    //creating the page object
    GoogleSearchPage googleSearchPage= new GoogleSearchPage();

   @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com/");
    }


   @Then("User should see tittle is Google")
    public void user_should_see_tittle_is_google() {
        String actualTitle=Driver.getDriver().getTitle();
        String expected="Google";

        Assert.assertEquals("Actual title doesnt match",actualTitle,expected);
      // Assert.assertTrue(actualTitle.equals(expected));

    }


    @When("User searches apple")
    public void userSearchesApple() {
         //creating the page object
        GoogleSearchPage googleSearchPage= new GoogleSearchPage();
        //sending value into search box using the page object
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }


    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
       String expected="apple - Google Search";
       String actual=Driver.getDriver().getTitle();

       Assert.assertEquals(actual,expected);

    }

    @When("User searches {string}")
    public void userSearches(String searchValue) {

        //sending value into search box using the page object
        googleSearchPage.searchBox.sendKeys(searchValue+ Keys.ENTER);

    }

    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String searchValue) {

        String expected=searchValue+" - Google Search";
        String actual=Driver.getDriver().getTitle();

        Assert.assertEquals(actual,expected);

    }


    @Then("User should see About link")
    public void userShouldSeeAboutLink() {
       //asserting that aboutlink is displayed
       Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());

    }

    @And("User clicks to About link")
    public void userClicksToAboutLink() {
       googleSearchPage.aboutLink.click();

    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {
       String expectedTitle="Google - About Google, Our Culture & Company News";
       String actualTitle=Driver.getDriver().getTitle();

       Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Then("user should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linkStrings) {
       System.out.println("linkStrings = " + linkStrings.size());

       int expectedSize=linkStrings.size();
       int actualSize=googleSearchPage.footerLinks.size();

       System.out.println(linkStrings);

       Assert.assertEquals(actualSize,expectedSize);

   }

}

