Feature: User Created with cucumber and api-rest

  #Happy Path with entry parameters
  Scenario: Validate that an user is created correctly
    Given I create a new user
    When I send the first name: "Juan", the last name: "Vanegas", the email: "juanvanegas.automation@gmail.com" and his avatar is: "https://reqres.in/img/faces/2-image.jpg"
    Then I want to validate if this user is created correctly

    #Using Scenario Outline
  Scenario Outline: Validate that user email has valid format ex: username@domainname.xxx
    Given I create a new user
    When I send the first name: <first_name>, the last name: <last_name>, the email: <email> and his avatar is: <avatar>
    Then I want to know if the <email> send has correctly format
    And I want to validate if this user is created correctly
    Examples:
      | first_name | last_name | email                   | avatar |
      | "xxxx"     | "xxxx"    | "@gmail.com"            | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan@"                 | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan@.com"             | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan@com"              | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan"                  | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan@gmail"            | "xxxx" |
      | "xxxx"     | "xxxx"    | "juan@gmail."           | "xxxx" |
      | "xxxx"     | "xxxx"    | "@."                    | "xxxx" |
      | "Juan"     | "Vanegas" | "juanvanegas@gmail.com" | "xxxx" |

  Scenario: Validate that an user doesn't exist before to be created
    Given I create a new user
    When I send the first name: "Janet", the last name: "Weaver", the email: "janet.weaver@reqres.in" and his avatar is: "https://reqres.in/img/faces/2-image.jpg"
    Then I want to check if the user "Janet" exist in the Api server
    And I want to validate if this user is created correctly