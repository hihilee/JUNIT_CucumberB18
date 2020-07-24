package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage {

    public GasMileageCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "uscodreading")
    public WebElement currentOdometerReading;

    @FindBy(id = "uspodreading")
    public WebElement previousOdometerReading;

    @FindBy(id = "usgasputin")
    public WebElement gasAmount;

    @FindBy(xpath = "//input[@alt='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//b[contains(text(),'mpg')]")
    public WebElement result;






}
