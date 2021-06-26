Feature: Create users with cucumber and api-rest

  Scenario:  Validate that an user is created correctly, happy path
    Given I create a new user
      When I send the name of the user "Juan"
        And I send the job of the user "Tester"
    Then I want to validate if this user is created correctly


