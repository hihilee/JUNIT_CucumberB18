@loginWithBackground
Feature: Login
  Agile Story: As a user, I should be able to login with correct credentials
  to different accounts. And dashboard should be displayed.

  Background: Backstory is that user is on the login page
    Given User is on the login page

  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see dashboard

  Scenario: Student login scenario
    When User logs in as student
    Then User should see dashboard

    @db
  Scenario: Admin login scenario
      #BEFORE STEP RUNS HERE
    When User logs in as admin
      #AFTER STEP RUNS HERE

       #BEFORE STEP RUNS HERE
    Then User should see dashboard
       #AFTER STEP RUNS HERE