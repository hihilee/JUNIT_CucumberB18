@smartBearScenario
Feature: Order

  Scenario Outline: Order Verification

    Given User is logged into SmartBear Tester account and on Order page
    Then User fills out the form as followed
    When User selects "<product>" from product dropdown
    Then User enters "<quantity>" to quantity
    When User enters "<customerName>" to costumer name
    Then User enters "<street>" to street
    When User enters "<city>" to city
    Then User enters "<state>" to state
    And User enters "<zip>" to zipcode
    When User selects "<cardType>" as card type
    Then User enters "<cardNumber>" to card number
    And User enters "<expireDate>" to expiration date
    Then User clicks process button
    And User verifies "<expectedName>" is in the list

    Examples:example test data for smartbear order
      | product     | quantity | customerName    | street      | city        | state | zip   | cardNumber   | expireDate | expectedName    | cardType   |
      | MyMoney     | 1        | Ken Adams       | Kinzie st   | Chicago     | IL    | 60004 | 123456789315 | 12/22      | Ken Adams       | Visa       |
      | FamilyAlbum | 4        | Joey Tribbiani  | State st    | Chicago     | IL    | 60656 | 123456789316 | 11/22      | Joey Tribbiani  | MasterCard |
      | ScreenSaver | 5        | RachelGreen     | Michigan st | Chicago     | IL    | 60056 | 123456789317 | 10/22      | RachelGreen     | Visa       |
      | MyMoney     | 5        | Chandler Bing   | Erie st     | Chicago     | IL    | 60666 | 123456789318 | 10/22      | Chandler Bing   | Visa       |
      | FamilyAlbum | 9        | Dr DrakeRamoray | Dale st     | Arl Hgths   | IL    | 60452 | 123456789319 | 10/22      | Dr DrakeRamoray | Visa       |
      | ScreenSaver | 10       | Monica Geller   | Euclid ave  | Arl Hgths   | IL    | 60312 | 123456789320 | 10/22      | Monica Geller   | Visa       |
      | MyMoney     | 3        | Ross Geller     | River rd    | Des Plaines | IL    | 60666 | 123456789321 | 10/22      | Ross Geller     | Visa       |
      | MyMoney     | 1        | Ken Adams       | Kinzie st   | Chicago     | IL    | 60312 | 123456789322 | 12/22      | Ken Adams       | Visa       |
