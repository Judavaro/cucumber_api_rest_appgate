package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import model.User;

public class UserValidateEmailsSteps extends User {

  private DataTable emailDT;
  private String emailToEvaluate;

  @Given("I create a new user with many emails")
  public void iCreateANewUserWithManyEmails() {
  }

  @When("I send the {string}")
  public void i_send_the(String email) {
    emailToEvaluate =  email;
  }

  @Then("I want to know if the email send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat() {
    System.out.println(">>> "+User.validateEmail(emailToEvaluate));
    assertTrue(User.validateEmail(emailToEvaluate),"The email < "+emailToEvaluate+" > has an invalid format. Error: ");
    ///List<List<String>> rows = emailDT.asLists(String.class);

    //for (List<String> columns : rows) {
      //assertTrue(User.validateEmail(columns.get(0)),"The email < "+columns.get(0)+" > has an invalid format. Error: ");
    //}
  }
}