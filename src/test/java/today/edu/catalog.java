package today.edu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class catalog {
    public MyAppT obj;
    public boolean added = false;
    public Car cc=new Car();
    public String Categorie;

    public catalog(MyAppT iobj){
        super();
        this.obj = iobj;
        Car c1 = new Car("motor","Interior",5000,1,"essintial part");
        obj.cp.add(c1);
        Car c2 = new Car("motor-v2","Interior",5000,100,"essintial part");
        obj.cp.add(c2);
    }

    @When("the name is {string} and categorie is {string} and price is {int} and availability is {int} and descriptions is {string}")
    public void theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(String name, String categorie, int price, int ava, String desc) {
        //obj.cp.add(new car(name,categorie,price,ava,desc));
        obj.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(name,categorie,price,ava,desc);
        added=true;
    }

    @Then("the product is added to the Interior section")
    public void theProductIsAddedToTheInteriorSection() {
        assertTrue("The product is added",added);
    }

    @When("I request information about specific product by entering its name {string}")
    public void iRequestInformationAboutSpecificProductByEnteringItsName(String name) {
        obj.iRequestInformationAboutSpecificProductByEnteringItsName(name);
    }

    @Then("Make the product descriptions, prices, and availability appear")
    public void makeTheProductDescriptionsPricesAndAvailabilityAppear() {
        assertNotNull(cc);
        obj.printCatalog(cc);
    }

    @When("I request information about products by entering there categories {string}")
    public void iRequestInformationAboutProductsByEnteringThereCategories(String categ) {
       obj.enterCategory(categ);
    }

    @Then("List all the products name, prices, availability and descriptions")
    public void listAllTheProductsNamePricesAvailabilityAndDescriptions() {
        assertNotNull(obj.carArrayList);
        obj.printCarList(1);
    }

    @When("I request information about products by entering there price {int}")
    public void iRequestInformationAboutProductsByEnteringTherePrice(int price) {
        obj.requestByPrice(price);
    }

    @Then("List all the products name, categories, availability and descriptions")
    public void listAllTheProductsNameCategoriesAvailabilityAndDescriptions() {
        assertNotNull(obj.carArrayList);
        obj.printCarList(2);
    }

    @And("the product categories is loaded {string}")
    public void theProductCategoriesIsLoaded(String categorie) {
        Categorie=categorie;
    }

    @When("I filter products by a price range of {int} to {int}")
    public void iFilterProductsByAPriceRangeOfTo(int price1, int price2) {
        obj.filterPrice(price1,price2,Categorie);
    }
}
