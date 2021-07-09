package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.security.KeyStore.Entry;
import java.util.List;
import model.User;

public class CreateUserNumericNameSteps extends User{
  private String first_name;
  private String last_name;
  private String email;
  private String avatar;

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

    userDataTable.rows(.)forEach(aDataModel -> {
      String username = aDataModel.user;
      String password = aDataModel.password;
    });

    for (String user : usersList) {

      System.out.println(">>>> "+user.);

    }


      //assertTrue(User.validateEmail((String) user.toArray()[2]));
      //System.out.println(">>>> "+User.validateEmail((String) user.toArray()[2]));



    /*newUser.put("name", userName);
    newUser.put("job", jobName);

    //if(Utilities.isNumeric(userName)) {

      //= new User(first_name, last_name, email, avatar);



      /*Utilities.createUser(newUser).assertThat()
          .statusCode(400)
          .statusLine("HTTP/1.1 400 Bad Request");*/


  }
}