package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import model.User;

public class UserCreateSteps {

  private User newUser;

  @Given("I create a new user")
  public void iCreateNewUser() {
    newUser = new User();
  }

  @When("I send the first name: {string}, the last name: {string}, the email: {string} and his avatar is: {string}")
  public void iSendTheFirstNameTheLastNameTheEmailAndHisAvatarIs(String first_name, String last_name,
      String email, String avatar) {

    newUser.setFirst_name(first_name);
    newUser.setLast_name(last_name);
    newUser.setEmail(email);
    newUser.setAvatar(avatar);
  }

  @Then("I want to validate if this user is created correctly")
  public void iWantToValidateIfThisUserIsCreatedCorrectly() {

    given()
        .baseUri("https://reqres.in/")
        .basePath("api/users")
        .contentType(ContentType.JSON)
        .body(newUser)
        .post()
        .then()
        .statusCode(201)
        .statusLine("HTTP/1.1 201 Created")
        .assertThat()
        .body("first_name", equalTo(newUser.first_name));
  }
}