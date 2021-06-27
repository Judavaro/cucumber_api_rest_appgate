package steps;

import static io.restassured.RestAssured.given;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import java.util.HashMap;

public class CreateUserNumericNameSteps {

  private HashMap<String, String> newUser;
  private String userName;
  private String jobName;

  @Given("I search the user with the numeric name")
  public void iSearchTheUserWithTheNumericName() {
    newUser = new HashMap<>();
  }

  @When("I send the name {string}")
  public void iSendTheName(String name) {
    userName = name;
  }

  @And("I his job is {string}")
  public void iHisJobIs(String job) {
    jobName = job;
  }

  @Then("I want to know if the system does not create the user with numeric name")
  public void iWantToKnowIfTheSystemDoesNotCreateTheUserWithNumericName() {

    newUser.put("name", userName);
    newUser.put("job", jobName);

    if(Utilities.isNumeric(userName)) {

      String response = given()
          .baseUri("https://reqres.in/")
          .contentType(ContentType.JSON)
          .with()
          .body(newUser)
          .when()
          .post("api/users").asString();

        .assertThat()
          .statusCode(400)
          .statusLine("HTTP/1.1 400 Bad Request");

    }
  }
}
