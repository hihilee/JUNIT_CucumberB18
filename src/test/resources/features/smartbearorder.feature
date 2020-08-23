@smartbear
Feature: Order
  Scenario: Order Verification
    Given User is logged into SmartBear Tester account and on Order page
    Then User fills out the form as followed
    When User selects "FamilyAlbum" from product dropdown
    Then User enters "4" to quantity
    When User enters "John Wick" to costumer name
    Then User enters "Kinzie Ave" to street
    When User enters "Chicago" to city
    Then User enters "IL" to state
    And User enters "60056" to zipcode
    When User selects "Visa" as card type
    Then User enters "1111222233334444" to card number
    And User enters "12/22" to expiration date
    Then User clicks process button
    And User verifies "John Wick" is in the list