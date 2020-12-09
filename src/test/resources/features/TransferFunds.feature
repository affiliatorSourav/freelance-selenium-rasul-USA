Feature: Transfer Funds Features

  @Regression
  Scenario: Validate Transfer Funds Page Title
    Given I am on Parabank application login page
    And I enter valid username and password
    And I click on LOG IN button
    And I click on Transfer Funds service on Home Page
    Then I validate I am on Transfer Funds page

