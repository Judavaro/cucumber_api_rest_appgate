Feature: Delete users with cucumber and api-rest

  Scenario:  Validate that an user is deleted correctly, happy path
    Given I delete an user
    When I send the user Id "2"
    Then I want to validate if this user is deleted correctly

