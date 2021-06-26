package steps;

import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

public class ListUsersSteps {

  @Given("I search the users list")
  public void iSearchTheUsersList() {
  }

  @Then("I want to validate that the user list is listed correctly")
  public void iWantToValidateThatTheUserListIsListedCorrectly() {
    
    given()
      .baseUri("https://reqres.in/")
      .contentType(ContentType.JSON)
      .when()
      .get("api/users")
      .then()
        .assertThat()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK");
  }
}