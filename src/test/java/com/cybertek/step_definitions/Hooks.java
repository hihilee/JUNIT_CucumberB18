package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

   @Before(order = 2)
    public void setUpScenario(){
        System.out.println("--> Before annotation: Setting up the browser");
    }

   @Before(value = "@db", order = 1)
    public void setUpDataBaseConnection(){
        System.out.println("------> Before annotation: DB Connection is created <------");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario){

       //System.out.println("--> After annotation: Closing the browser");
       //System.out.println("scenario.getName() = " + scenario.getName());
       //System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
       //System.out.println("scenario.isFailed() = " + scenario.isFailed());

        //#1 we need to take a screen shot using SELENIUM -->
        // getScreenshotAs: to be able to use this method we have to cast our driver type to TakesScreenshot

        //#2 we are going to attach it into our report: using attach method
        //attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's

        if(scenario.isFailed()){
            byte [] screenshot= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }

    }


   @After (value = "@db", order = 4)
    public void tearDownBaseConnection(){
      //  System.out.println("------> After annotation: DB Connection is closed <------")


   }


    @BeforeStep
    public void setUpStep(){
        System.out.println("======>Before Step: Taking ScreenShot<======");
    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("======>After Step: Taking ScreenShot<======");
    }

}
