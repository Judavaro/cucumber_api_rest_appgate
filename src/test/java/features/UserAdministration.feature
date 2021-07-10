Feature: User Administration with cucumber and api-rest

  Scenario: Validate that an user is created correctly, happy path
    Given I create a new user
    When I send the "Juan", the "Vanegas", the "juanvanegas.automation@gmail.com" and his "www.google.com"
    Then I want to validate if this user is created correctly

  Scenario Outline: Validate that user email has valid format ex: username@domainname.xxx
    Given I create a new user with many emails
    When I send the <email>
    Then I want to know if the email send has correctly format
    And I want to validate if this user is created correctly
    Examples:
      | email |
      | carlina@gmail.com |
      | @gmail.com        |
      | juan@             |
      | juan@.com         |
      | juan@com          |
      | xiomi@gmail.com   |
      | juan              |
      | juan@gmail        |
      | juan@gmail.       |
      | @.                |


# validar que el usuario a registrar no exista