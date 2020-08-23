package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EtsySearchPage {

    public EtsySearchPage(){
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

   @FindBy(xpath = "//span[@class='etsy-icon wt-nudge-b-1']")
    public WebElement searchButton;


}
