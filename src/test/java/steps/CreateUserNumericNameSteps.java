package steps;

import Util.Utilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import model.User;

public class CreateUserNumericNameSteps extends User{
  private String first_name;
  private String last_name;
  private String email;
  private String avatar;

  private List<List<String>> emailList;

  @Given("I create a new use with many emails")
  public void iCreateANewUseWithManyEmails() {
  }

  @When("I send the name <email>")
  public void iSendTheNameEmail(DataTable emails) {
    emailList = emails.asLists(String.class);
  }

  @Then("I want to know if the email send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat() {

    /*newUser.put("name", userName);
    newUser.put("job", jobName);

    //if(Utilities.isNumeric(userName)) {

      //= new User(first_name, last_name, email, avatar);



      /*Utilities.createUser(newUser).assertThat()
          .statusCode(400)
          .statusLine("HTTP/1.1 400 Bad Request");*/

    }
  }
}