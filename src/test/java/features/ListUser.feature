Feature: List users with cucumber and api-rest

  Scenario:  Validate that the users is listed correctly, happy path
    Given I search the users list
    Then I want to validate that the user list is listed correctly