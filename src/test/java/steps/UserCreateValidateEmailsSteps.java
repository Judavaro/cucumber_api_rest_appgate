package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import model.User;

public class UserCreateValidateEmailsSteps extends User {

  @Then("I want to know if the {string} send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat(String email) {
    assertTrue(User.validateEmail(email),
        "The email < " + email + " > has an invalid format. Error: ");
  }
}