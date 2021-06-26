package steps;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import java.util.HashMap;

public class DeleteUsersSteps {
  private HashMap<String, String> newUser;
  private String userId;

  @Given("I delete an user")
  public void iDeleteAnUser() {
    newUser = new HashMap<>();
  }

  @When("I send the user Id {string}")
  public void iSendTheUserId(String id) {
    userId = id;
  }

  @Then("I want to validate if this user is deleted correctly")
  public void iWantToValidateIfThisUserIsDeletedCorrectly() {

    newUser.put("id", userId);

    given()
      .baseUri("https://reqres.in/")
      .contentType(ContentType.JSON)
      .with()
        .body(newUser)
      .when()
        .delete("api/users/")
      .then()
        .assertThat()
        .statusCode(204)
        .statusLine("HTTP/1.1 204 No Content");
  }
}
