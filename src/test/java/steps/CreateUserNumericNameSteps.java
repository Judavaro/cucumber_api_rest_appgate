package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import model.User;

public class CreateUserNumericNameSteps extends User {

  private DataTable userDataTable;

  @Given("I create a new user with many emails")
  public void iCreateANewUserWithManyEmails() {
  }

  @When("I send the <email>")
  public void iSendTheEmail(DataTable users) {
    userDataTable = users;
  }

  @Then("I want to know if the email send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat() {

    List<List<String>> rows = userDataTable.asLists(String.class);

    int i = 0;
    for (List<String> columns : rows) {

      if (i > 0) {
        assertTrue(User.validateEmail(columns.get(0)),"The email has an invalid format. Error: ");
      }
      i++;
    }
  }
}