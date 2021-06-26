Feature: List users with cucumber and api-rest

  Scenario:  Validate that the users is listed correctly, happy path
    Given I search the users list
    Then I want to validate that the user list is listed correctly

  Scenario: Search unique user by id and validate his email
    Given I have an userId "2"
    And I have his email "janet.weaver@reqres.in"
    Then I want to search the user with his userId and userEmail correctly