package steps;

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

  private List<List<String>> usersList;

  @Given("I create a new user with many emails")
  public void iCreateANewUserWithManyEmails() {
  }

  @When("I send the <email>")
  public void iSendTheEmail(DataTable users) {
    usersList = users.asLists(String.class);
  }

  @Then("I want to know if the email send has correctly format")
  public void iWantToKnowIfTheEmailSendHasCorrectlyFormat() {

    int index = 0;
    for (List<String> user: usersList) {

      //

      assertTrue(User.validateEmail(user.toArray()[2]));
      System.out.println(">>>>");
    }

    /*newUser.put("name", userName);
    newUser.put("job", jobName);

    //if(Utilities.isNumeric(userName)) {

      //= new User(first_name, last_name, email, avatar);



      /*Utilities.createUser(newUser).assertThat()
          .statusCode(400)
          .statusLine("HTTP/1.1 400 Bad Request");*/


  }
}