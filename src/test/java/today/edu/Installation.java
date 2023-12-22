package today.edu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Installation {
    public MyAppT obj;
    String uname, dateee , cname;
    public Installation(MyAppT iobj){
        super();
        this.obj = iobj;
        User u1= new User("haya","123","7\3\2004");
        obj.addUser(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        obj.addUser(u2);
        Car c1 = new Car("motor","Interior",5000,1,"essintial part");
        obj.addCar(c1);
        Car c2 = new Car("motor-v2","Interior",5000,100,"essintial part");
        obj.addCar(c2);
        c2.setAvailab(100);
    }

    @And("My name is {string}")
    public void myNameIs(String name) {
        uname = name;
    }
    @And("I'm on the installation request page")
    public void iMOnTheInstallationRequestPage() {
        obj.setInstallation(true);
    }

    @When("the customer fills in the following details: model is {string} and date {string}")
    public void theCustomerFillsInTheFollowingDetailsModelIsAndDate(String model, String datee) {
        obj.fillModelAndDate(model,datee);
        cname=obj.getCname();
        dateee=obj.getDateee();
    }

    @And("submits the form")
    public void submitsTheForm() {
        obj.setSubmit(true);
        obj.addOrder(new Order(uname, cname,dateee));
    }

    @Then("the request should be successfully submitted if the date available")
    public void theRequestShouldBeSuccessfullySubmittedIfTheDateAvailable() {
        assertTrue("The Installation request submitted", obj.getInstallation() && obj.getAvailable1() && obj.getAvailable2() && obj.getSubmit());
    }


    @Then("the request should not be submitted if the date is not available")
    public void theRequestShouldNotBeSubmittedIfTheDateIsNotAvailable() {
        assertTrue("The Installation request didn't submit", obj.getInstallation() && (!obj.getAvailable1() || !obj.getAvailable2()) && obj.getSubmit());
    }

}
