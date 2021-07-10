Feature: User Administration with cucumber and api-rest

  Scenario:  Validate that an user is created correctly, happy path
    Given I create a new user
    When I send the name of the user "Juan"
    And I send the job of the user "Tester"
    Then I want to validate if this user is created correctly

      | first_name    | last_name          | email                            | avatar                                  |
      | Juan          | Vanegas            | juanvanegas.automator.@gmail.com | https://reqres.in/img/faces/7-image.jpg |

  Scenario:  Validate that user email has valid format ex: username@domainname.xxx
    and the test should fail
    Given I create a new user with many emails
    When I send the <email>

      | email                |
      | carlina@gmail.com    |
      | @gmail.com           |
      | juan@                |
      | juan@.com            |
      | juan@com             |
      | xiomi@gmail.com      |
      | juan                 |
      | juan@gmail           |
      | juan@gmail.          |
      | @.                   |

    Then I want to know if the email send has correctly format
      And I want to validate if this user is created correctly




# validar que el usuario a registrar no exista