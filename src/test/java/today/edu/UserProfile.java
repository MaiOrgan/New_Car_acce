package today.edu;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfile {
    public MyAppT obj;
    public String name;
    public  String pass;

    public UserProfile(MyAppT iobj){
        super();
        this.obj = iobj;
    }

    @And("my name is {string}")
    public void myNameIs(String name1) {
        name = name1;
    }

    @When("I entered new password {string}")
    public void iEnteredNewPassword(String pass1) {
        pass = pass1;
    }

      @Then("Your information Updates successfully")
    public void yourInformationUpdatesSuccessfully() {
       obj.updatesSuccessfully(name,pass);
        assertTrue("Your information Updates successfully", obj.getUpdates());
    }

    @Then("The information should appear")
    public void theInformationShouldAppear() {
        obj.appearInformation(name);
        assertTrue("Your information appear successfully", obj.getApear());
    }
}
