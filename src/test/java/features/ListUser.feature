Feature: List users with cucumber and api-rest

  #Happy Path
  Scenario:  Validate that the users is listed correctly
    Given I search the users list
    Then I want to validate that the user list is listed correctly

  Scenario: Search unique user by email
    Given I have an user with the email "janet.weaver@reqres.in"
    Then I want to search the user with his userId and userEmail correctly