@wiki
Feature: Wikipedia title and search verifications
  As a user, I should be able to I should be able to search when I am on the Wikipedia home page.

  Background: User is on Wikipedia home page
    Given User is on Wikipedia home page


  Scenario: Wikipedia search title verification
    When User types "Steve Jobs" in the wiki search box
    Then User clicks wiki search button
    And User sees "Steve Jobs" is in the wiki title

  Scenario:Wikipedia Search Header Verification
    When User types "Steve Jobs" in the wiki search box
    Then User clicks wiki search button
    And User sees "Steve Jobs" is in the main header

  @a
  Scenario:Wikipedia Search Functionality Image Header Verification
    When User types "Steve Jobs" in the wiki search box
    Then User clicks wiki search button
    And User sees "huhh" is in the image header

  @wikiScenarioOutline
  Scenario Outline:Wikipedia Search Functionality Image Header Verification
    When User types "<searchValue>" in the wiki search box
    Then User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    And User sees "<expectedMainHeader>" is in the main header
    And User sees "<expectedImageHeader>" is in the image header

   Examples:example test data for wikipedia search
     | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
     | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
     | John Travolta   | John Travolta   | John Travolta      | John Travolta       |
     | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |
     | Keanu Reeves    | Keanu Reeves    | Keanu Reeves       | Keanu Reeves        |
     | Bruce Lee       | Bruce Lee       | Bruce Lee          | Bruce Lee           |
     | Dua Lipa        | Dua Lipa        | Dua Lipa           | Dua Lipa            |
     | Thomas Edison   | Thomas Edison   | Thomas Edison      | Thomas Edison       |
     | Sam Heughan     | Sam Heughan     | Sam Heughan        | Sam Heughan         |

