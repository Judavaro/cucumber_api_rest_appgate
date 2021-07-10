package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import model.User;

public class UserCreateCorrectlySteps {

  private User newUser;

  @Given("I create a new user")
  public void iCreateNewUser() {
    newUser = new User();
  }

  @When("I send the {string}, the {string}, the {string} and his {string}")
  public void iSendTheTheTheAndHis(String first_name, String last_name, String email, String avatar) {

    newUser.setFirst_name(first_name);
    newUser.setLast_name(last_name);
    newUser.setEmail(email);
    newUser.setAvatar(avatar);
  }

  @Then("I want to validate if this user is created correctly")
  public void iWantToValidateIfThisUserIsCreatedCorrectly() {

    given()
        .baseUri("https://reqres.in/")
        .contentType(ContentType.JSON)
        .with()
        .body(newUser)
        .when()
        .post("api/users")
        .then()
        .assertThat()
        .statusCode(201)
        .statusLine("HTTP/1.1 201 Created")
        .body("name", equalTo(newUser.first_name));
  }
}