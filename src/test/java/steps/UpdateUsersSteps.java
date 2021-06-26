package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import java.util.HashMap;

public class UpdateUsersSteps {

  private HashMap<String, String> newUser;
  private String userName;
  private String jobName;

  @Given("I update an user")
  public void iUpdateAnUser() {
    newUser = new HashMap<>();
  }

  @When("I send the name of the user {string} for update")
  public void iSendTheNameOfTheUserForUpdate(String name) {
    userName = name;
  }

  @And("I send the job of the user {string} for update")
  public void iSendTheJobOfTheUserForUpdate(String job) {
    jobName = job;
  }

  @Then("I want to validate if this user is updated correctly")
  public void iWantToValidateIfThisUserIsUpdatedCorrectly() {

    newUser.put("name", userName);
    newUser.put("job", jobName);

    given()
      .baseUri("https://reqres.in/")
      .contentType(ContentType.JSON)
      .with()
        .body(newUser)
      .when()
        .put("api/users")
      .then()
        .assertThat()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .body("name", equalTo(userName));
  }
}
