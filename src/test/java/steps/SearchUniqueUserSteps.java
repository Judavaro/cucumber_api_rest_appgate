package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import java.util.HashMap;

public class SearchUniqueUserSteps {

  private String userId;
  private String userEmail;

  @Given("I have an userId {string}")
  public void iHaveAnUserId(String userIdParam) {
    userId = userIdParam;
  }

  @And("I have his email {string}")
  public void iHaveHisEmail(String email) {
    userEmail = email;
  }

  @Then("I want to search the user with his userId and userEmail correctly")
  public void iWantToSearchTheUserWithHisUserIdAndUserEmailCorrectly() {

    given()
      .baseUri("https://reqres.in/")
      .contentType(ContentType.JSON)
      .when()
        .get("api/users/"+userId)
      .then()
        .assertThat()
        .body("data.email", equalTo(userEmail))
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK");
  }
}