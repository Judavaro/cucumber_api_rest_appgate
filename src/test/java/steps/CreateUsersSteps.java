package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import java.util.HashMap;

public class CreateUsersSteps {

  private HashMap<String, String> newUser;
  private String userName;
  private String jobName;

  @Given("I create a new user")
  public void iCreateNewUser() {
    newUser = new HashMap<>();
  }

  @When("I send the name of the user {string}")
  public void iSendTheNameOfTheUser(String name) {
    userName = name;
  }

  @And("I send the job of the user {string}")
  public void iSendTheJobOfTheUser(String job) {
    jobName = job;
  }

  @Then("I want to validate if this user is created correctly")
  public void iWantToValidateIfThisUserIsCreatedCorrectly() {

    newUser.put("name", userName);
    newUser.put("job", jobName);

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
      .body("name", equalTo(userName));
  }
}