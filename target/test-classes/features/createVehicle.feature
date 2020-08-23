@createCar
Feature: Create Vehicle
  As a user, I should be able to create vehicles

  Scenario: Create a vehicle
    Given user is on the login page
    When user logs in with "storemanager85" and "UserUser123" credentials
    Then user navigates to "Fleet" and "Vehicles"
    And user click on the create car button
    Then  user enter vehicle information:

      | licencePlate | Driver | Location     | Model Year |
      | test_plate   | SDET   | WashingtonDc | 2020       |


