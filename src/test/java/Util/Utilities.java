package Util;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.HashMap;

public class Utilities {

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  //Allow create new users
  public static Response createUser(HashMap<String, String> user){

     return given()
      .baseUri("https://reqres.in/")
      .contentType(ContentType.JSON)
      .with()
      .body(user)
      .when()
      .post("api/users");
  }

}
