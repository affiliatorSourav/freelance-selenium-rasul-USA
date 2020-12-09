Feature: Login Page Features

  @Regression @Smoke @AL-12 @Login
  Scenario: Validate user can login to Parabank application using valid credentials
    Given I am on Parabank application login page
    When I enter valid username and password
    And I click on LOG IN button
    Then I validate I am logged in
