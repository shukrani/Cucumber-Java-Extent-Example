Feature: Verify all the scenarios related with login
Given I am on home page
When Click on login button
Then login form gets open

  @LoginTest
  Scenario: Verify login with correct credentials
    When I enter login details
    Then I am successfully logged in