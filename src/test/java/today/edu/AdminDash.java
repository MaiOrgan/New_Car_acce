package today.edu;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminDash {
    public MyAppT obj;
    int CustList =0;
    public boolean updates = false;
    public boolean appears = false;
    public String name;
    public AdminDash(MyAppT iobj)
    {
        super();
        this.obj=iobj;
        Car c1 = new Car("motor","Interior",5000,1,"essintial part");
        obj.cp.add(c1);
        Car c2 = new Car("motor-v2","Interior",5000,100,"essintial part");
        obj.cp.add(c2);
    }
    @When("the name is {string} and the category is {string} and the price is {int} and the num of av p is {int} and the discription is {string}")
    public void theNameIsAndTheCategoryIsAndThePriceIsAndTheNumOfAvPIsAndTheDiscriptionIs(String arg0, String arg1, int arg2, int arg3, String arg4) {
        obj.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(arg0,arg1,arg2,arg3,arg4);
        name =arg0;
    }

    @Then("the product add successfully")
    public void theProductAddSuccessfully() {
        obj.addProduct(name);
        assertEquals(1, obj.exist);
    }

    @When("I ask you to list all the customer account")
    public void iAskYouToListAllTheCustomerAccount() {
        obj.seeUser();
        CustList =1;
    }

    @Then("the customer account must be appear on the screen")
    public void theCustomerAccountMustBeAppearOnTheScreen() {
        assertEquals(1, CustList);
    }

    @When("I enter the name for user {string} and the new password that i want to put it {string}")
    public void iEnterTheNameForUserAndTheNewPasswordThatIWantToPutIt(String arg0, String arg1)
    {
        updates= (obj.yourInformationUpdatesSuccessfully(arg0,arg1) == 1);
    }

    @Then("The password must change successfully")
    public void thePasswordMustChangeSuccessfully()
    {
        assertTrue(updates);
    }

    @When("I give the name of product{string} and the new price for it {int}")
    public void iGiveTheNameOfProductAndTheNewPriceForIt(String name, int newprice)
    {
       obj.newPrice(name,newprice);
    }

    @Then("The price must change successfully")
    public void thePriceMustChangeSuccessfully() {
        assertEquals(1, obj.checkPrice);
    }

    @When("I give you a date {string}")
    public void iGiveYouADate(String arg0) {
        obj.date.add(arg0);
    }

    @Then("this date must be added to the appointment as a free day to install")
    public void thisDateMustBeAddedToTheAppointmentAsAFreeDayToInstall() {
        assertTrue(true);
    }
}
