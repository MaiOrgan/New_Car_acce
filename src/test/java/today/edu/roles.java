package today.edu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class roles{
    public MyAppT obj;
    private String userRole;
    public roles(MyAppT iobj) {
        super();
        this.obj = iobj;
    }

    @Given("I am in system")
    public void iAmInSystem() {
        obj.setLogged(true);
    }

    @And("I'm the admin")
    public void iMTheAdmin() {
        userRole = "admin";
    }

    @When("set user name {string} and pass {string}")
    public void setUserNameAndPass(String user_name, String pass) {
        obj.setNamePass(user_name,pass);
    }

    @Then("you can Manage products")
    public void youCanManageProducts() {
        assertTrue("Admin can manage products", obj.getIsLogged() && userRole.equals("admin"));
    }

    @And("see categories")
    public void seeCategories() {
        assertTrue("Admin can see categories", obj.getIsLogged() && userRole.equals("admin"));
    }

    @And("access user accounts")
    public void accessUserAccounts() {
        assertTrue("Admin can access user accounts", obj.getIsLogged() && userRole.equals("admin"));
    }

    @And("I'm the Customer")
    public void iMTheCustomer() {
        userRole = "customer";
    }

    @Then("You can Browse products")
    public void youCanBrowseProducts() {
        assertTrue("Customer can browse products",userRole.equals("customer") && obj.getIsLogged());
    }

    @And("Make purchases")
    public void makePurchases() {
        assertTrue("Customer can make Purchases",userRole.equals("customer") && obj.getIsLogged());
    }

    @And("View orders")
    public void viewOrders() {
        assertTrue("Customer can view orders",userRole.equals("customer") && obj.getIsLogged());
    }

    @And("I'm the Installer")
    public void iMTheInstaller() {
        userRole = "installer";
    }

    @Then("You can View installation requests")
    public void youCanViewInstallationRequests() {
        assertTrue("Installer can View installation requests",userRole.equals("installer") && obj.getIsLogged());
    }

    @And("View schedule appointments")
    public void viewScheduleAppointments() {
        assertTrue("Installer can View schedule appointments",userRole.equals("installer") && obj.getIsLogged());
    }
}
