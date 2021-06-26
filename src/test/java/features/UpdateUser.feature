Feature: Update users with cucumber and api-rest

  Scenario:  Validate that a user is updated correctly, happy path
    Given I update an user
    When I send the name of the user "Juanda" for update
    And I send the job of the user "Tester Engineer" for update
    Then I want to validate if this user is updated correctly
