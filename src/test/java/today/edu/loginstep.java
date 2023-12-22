package today.edu;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstep {
    public MyAppT obj;
    public boolean forget = false;
    public String enteredUsername;
    public String enteredPassword;

    public loginstep(MyAppT iobj) {
        super();
        this.obj = iobj;
        User u1= new User("haya","123","7\3\2004");
        obj.up.add(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        obj.up.add(u2);
    }

    @Given("I am not in system")
    public void mmm()
    {
        obj.iAmNotInSystem(obj);
    }
    @When("set username {string} and pass {string}")
    public void setUsernameAndPassAndPassFromSystem(String user_name, String pass) {
        obj.setUsernameAndPassAndPassFromSystem(user_name,pass);
    }
    @Then("login succeed")
    public void loginSucceed() {
        assertTrue("Login should succeed", obj.getValidation());
    }
    @When("set invalid username {string} and pass {string}")
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        obj.setInvalidUsernameAndPass(user_name,pass);
    }
    @Then("login failed")
    public void loginFailed() {
        assertFalse("Login should fail", obj.getValidation());
    }

    @When("set valid username {string} and invalid pass {string}")
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        obj.setValidUsernameAndInvalidPass(user_name,pass);
    }

    @When("set empty username {string} and pass {string}")
    public void setEmptyUsernameAndPass(String user_name, String pass) {

        obj.setEmptyUsernameAndPass(user_name,pass);
    }

    @When("set valid username {string} and empty pass {string}")
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {

        obj.setValidUsernameAndEmptyPass(user_name,pass);

    }

    @When("set valid username {string} and  pass {string}")
    public void setValidUsernameAndPass(String user_name, String pass) {
        obj.validUserPass(user_name,pass);
        forget=obj.forget;
        enteredUsername= obj.enteredUsername;
    }

    @Then("take new pass {string}")
    public void takeNewPass(String newPass) {
        obj.takePass(newPass);
        assertTrue("New password should be updated", obj.passwordUpdated);
    }

    @And("i don't have an account")
    public void iDonTHaveAnAccount() {
        obj.setLogged(false);
    }

    @When("set new username {string} and pass {string} and bd={string}")
    public void setNewUsernameAndPass(String user_name, String pass,String bd) {
        obj.up.add(new User(user_name, pass,bd));
        enteredUsername = user_name;
        enteredPassword = pass;
    }

    @Then("create succeed")
    public void createSucceed() {
        obj.createAcc(enteredUsername,enteredPassword);
        assertTrue("User creation should succeed", obj.userCreated);
    }
}
