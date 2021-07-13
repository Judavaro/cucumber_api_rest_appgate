package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.User;

public class UserValidateEmailsSteps extends User {

  private DataTable emailDT;
  private String emailToEvaluate;

  @Given("I create a new user with many emails")
  public void iCreateANewUserWithManyEmails() {
  }

  @When("I send the {string}")
  public void i_send_the(String email) {
    emailToEvaluate = email;
  }

  @Then("I want to know if the email send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat() {
    assertTrue(User.validateEmail(emailToEvaluate),
        "The email < " + emailToEvaluate + " > has an invalid format. Error: ");
  }
}