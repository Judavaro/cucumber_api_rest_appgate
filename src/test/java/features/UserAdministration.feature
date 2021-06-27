Feature: User Administration with cucumber and api-rest

  Scenario:  Validate that does not create an user a numeric name
    Given I search the user with the numeric name
    When I send the name 1223
      And I his job is "Tester"
    Then I want to know if the system does not create the user with numeric name

  Scenario:  Validate that an user is created correctly, happy path
    Given I create a new user
      When I send the name of the user "Juan"
        And I send the job of the user "Tester"
    Then I want to validate if this user is created correctly


