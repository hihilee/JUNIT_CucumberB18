Feature: Etsy Search feature
  Agile Story: User should be able to enter search terms
  and see relevant results in the page and in the title.


  Background: User is on https://www.etsy.com
    Given User is on https://www.etsy.com

    @etsy1
    Scenario: Etsy Title Verification
      Then User sees title is as expected
       #Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

    @etsy2
    Scenario: Etsy Search Functionality Title Verification (without parameterization)
       When User types Wooden Spoon in the search box
       Then User clicks search button
       And User sees Wooden Spoon is in the title

    @withparam
    Scenario: Etsy Search Title Verification (with parameterization)
      When User types "reusable mask" in the search box
      Then User clicks search button
      And User sees "Reusable mask" is in the title

