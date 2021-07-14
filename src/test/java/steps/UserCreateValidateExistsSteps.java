package steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

public class UserCreateValidateExistsSteps {

  @Then("I want to check if the user {string} exist in the Api server")
  public void iWantToCheckIfTheUserExistInTheApiServer(String first_name) {

    given()
        .baseUri("https://reqres.in/")
        .basePath("api/users/2")
        .contentType(ContentType.JSON)
        .when()
        .get()
        .then()
        .assertThat()
        .statusCode(200)
        .statusLine("HTTP/1.1 200 OK")
        .body("data.first_name", equalTo(first_name));
  }
}
