Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search page.

  Background: User should be on google search page
    Given User is on the google search page

  Scenario: Google default title verification
    Then User should see title is Google


  Scenario: Google title verification after search
    When User searches apple
    Then User should see apple in the title


  Scenario: Google title verification after search
    When User searches "broccoli"
    Then User should see "broccoli" in the title


  Scenario: Google -About- Link page title verification
    Then User should see About link
    And User clicks to About link
    Then User should see title Google - About Google, Our Culture & Company News

    #for Mac option+Enter
    # Windows alt+Enter Allows to generate step definitions
  @google
  Scenario: Google search page footer links verification
    Then user should see six links in the footer

      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |


    #command+D or
    #ctrl+ D for auto generate lines!!!
