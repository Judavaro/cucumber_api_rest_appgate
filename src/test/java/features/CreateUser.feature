Feature: Create users with cucumber and api-rest

  Scenario:  Validate that a user is created correctly, happy path
    Given I create a new user with this api services "https://reqres.in/api/users"
      When I send the name of the user "Juan"
        And I send the job of the user "Tester"
    Then I want to validate if this user is created correctly


