Feature: Accounts Overview Page Features

  @Regression
  Scenario: Validate Accounts Overview Page Title
    Given I am on Parabank application login page
    When I enter valid username and password
    And I click on LOG IN button
    Then I validate Accounts Overview table title