Feature: User Administration with cucumber and api-rest

  Scenario:  Validate that an user is created correctly, happy path
    Given I create a new user
    When I send the name of the user "Juan"
    And I send the job of the user "Tester"
    Then I want to validate if this user is created correctly

      | first_name    | last_name          | email                            | avatar                                  |
      | Juan          | Vanegas            | juanvanegas.automator.@gmail.com | https://reqres.in/img/faces/7-image.jpg |

  Scenario:  Validate that user email has valid format username@domainname.xxx
    Given I create a new use with many emails
    When I send the name <email>

      | first_name    | last_name  | email        | avatar                                            |
      | Juan          | Vanegas    | @gmail.com   | https://reqres.in/img/faces/7-image.jpg           |
      | Carlos        | Martinez   | juan@        | https://reqres.in/img/faces/7-image.jpg           |
      | Camila        | Guzman     | juan@.com    | https://reqres.in/img/faces/7-image.jpg           |
      | Alejandro     | Almiro     | juan@com     | https://reqres.in/img/faces/7-image.jpg           |
      | Ramiro        | Soto       | juan         | https://reqres.in/img/faces/7-image.jpg           |
      | Alonso        | Arango     | juan@gmail   | https://reqres.in/img/faces/7-image.jpg           |
      | Bety          | Munera     | juan@gmail.  | https://reqres.in/img/faces/7-image.jpg           |
      | Carla         | mina       | @.           | https://reqres.in/img/faces/7-image.jpg           |

    Then I want to know if the email send has correctly format
      And I want to validate if this user is created correctly



# validar que el correo del usuario sea valido formato
# validar que el usuario a registrar no exista