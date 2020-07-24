package com.cybertek.step_definitions;

import com.cybertek.pages.WikipediaSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikipediaSearchStepDefinitions {

    WikipediaSearchPage wikipediaSearchPage=new WikipediaSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");

    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String string) {
        wikipediaSearchPage.searchBox.sendKeys(string);

    }

    @Then("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchButton.click();

    }

    @And("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String string) {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle=string;
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @And("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String string) {
        String actualHeader=wikipediaSearchPage.header.getText();
        Assert.assertTrue(actualHeader.contains(string));
    }

    @And("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String string) {
        String actualImageHeader=wikipediaSearchPage.imageHeader.getText();
        Assert.assertTrue(actualImageHeader.contains(string));
    }
}
