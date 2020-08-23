package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class createVehicleStepDefinitions {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Login Page");

    }

    @When("user logs in with {string} and {string} credentials")
    public void user_logs_in_with_and_credentials(String string1, String string2) {
        System.out.printf("User logs in with %s  and %s ", string1, string2);
    }

    @Then("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        System.out.printf("User navigates to %s and %s module", string, string2);
    }

    @Then("user click on the create car button")
    public void user_click_on_the_create_car_button() {
        System.out.println("User click on the create car button");
    }

    @Then("user enter vehicle information:")
    public void user_enter_vehicle_information(List<Map<String, String>>dataTable) {
        System.out.println("Driver is: "+dataTable.get(0).get("Driver"));
        System.out.println("Location is: "+dataTable.get(0).get("Location"));
    }
}
