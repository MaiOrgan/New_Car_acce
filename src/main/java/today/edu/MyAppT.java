package today.edu;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class MyAppT
{
    public boolean isLogged=false;
    public boolean validation =false;
    public  boolean isInstallation=false;
    public boolean submit = false;
    public boolean available1 = false;
    public boolean available2 = false;
    public  List<User> up=new  ArrayList<User>();
    public  List<Car> cp = new  ArrayList<Car>();
    public  List<order> op = new  ArrayList<order>();
    public  List<String>date = new  ArrayList<String>();

    private static final Logger logger = Logger.getLogger(MyAppT.class.getName());
    public MyAppT()
    {
        User u1= new User("haya","123","7\3\2004");
        up.add(u1);
        User u2= new User("Asma@gmail.com","1234","7\3\2004");
        up.add(u2);
        this.isLogged = false;
        this.validation = false;
        Car c1 = new Car("motor","Interior",5000,1,"essintial part");
        cp.add(c1);
        Car c2 = new Car("motor-v2","Interior",5000,100,"essintial part");
        cp.add(c2);
        User u3= new User("Fatina","1234","2\4\2004");
        up.add(u3);
        order o1 = new order(u3.getUser_name(), c2.getCar_name(), "20-10-2023");
        op.add(o1);
        date.add("20-10-2023");
        date.add("22-10-2023");
        date.add("5-11-2023");
    }
    public void setUsernameAndPassAndPassFromSystem(String user_name, String pass) {
        
        for (User u: up) {

            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                validation = true;
                
                logger.info("hi");
                break;
            }}
    }
    public void setInvalidUsernameAndPass(String user_name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (User u: up) {
            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String user_name, String pass) {
        for (User u: up) {
            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setEmptyUsernameAndPass(String user_name, String pass) {
        if (user_name.isEmpty())
            validation = false;
    }
    public void setValidUsernameAndEmptyPass(String user_name, String pass) {
        if (pass.isEmpty())
            validation = false;
    }
    public void iAmNotInSystem(MyAppT obj)
    {
        obj.isLogged=false;
    }

    public void theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(String name, String categorie, int price, int ava, String desc) {
        cp.add(new Car(name, categorie, price, ava, desc));
        
        logger.info("You have added this product in a successfully way");
    }

    public void iRequestInformationAboutSpecificProductByEnteringItsName(String name) {
        for(Car c: cp ){
            if(name.equals(c.car_name)){
                String k=String.valueOf(c.price);
                String f=String.valueOf(c.availab);
                
                logger.info("Category:- "+c.categorie+" || Price:- "+k+" || The num of available pieces:- "+f+" || Discribtion about it:- "+c.descr);
            }
        }
    }
    public void seeUser()
    {
        for(User c:up)
        {
            
           logger.info("Gmail:- "+c.user_name+"\t"+"Password:- "+c.pass+"\t"+"BirthDate:- "+c.BD);
        }
    }
    int yuy=0;
    public int yourInformationUpdatesSuccessfully(String name,String pass) {
        for (User u : up) {
            if (name.equals(u.getUser_name())) {
                u.setPass(pass);
                yuy=1;
                break;
            }
        }
        return yuy;
    }
    public boolean forget = false;
    public String enteredUsername;
    public boolean passwordUpdated = false;
    public  boolean userCreated = false;
    public void validUserPass(String user_name, String pass){
        forget = false;
        for (User u: up) {
            if (user_name.equals(u.getUser_name()) && pass.equals("Forget")) {
                forget = true;
                enteredUsername = user_name;
                break;
            }
        }
    }
    public void takePass(String newPass){
        for (User user : up) {
            if (user.getUser_name().equals(enteredUsername)) {
                user.setPass(newPass);
            }
         }
        for (User user : up) {
            if (user.getUser_name().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;
            }
        }
    }
    public void createAcc(String enteredUsernam,String enteredPasswor){
        for (User user : up) {
            if (user.getUser_name().equals(enteredUsernam) && user.getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }
        }
    }
    public void setNamePass(String user_name, String pass){
        for (User u: up) {
            if (user_name.equals(u.getUser_name()) && u.getPass().equals(pass)) {
                validation = true;
                break;
            }
        }
    }
    public String dateee , cname;
    public void fillModelAndDate(String model,String datee){
        for(String d: date){
            if (d.equals(datee)) {
                available1 = true;
                dateee = datee;
                break;
            }
        }
        for(Car c : cp){
            if (model.equals(c.car_name)){
                available2 = true;
                cname = model;
                break;
            }
        }
    }
    public void printCatalog(Car cc){
        System.out.println(cc.getDescr());
        System.out.println(cc.getPrice());
        System.out.println(cc.getAvailab());
        System.out.println(cc.getCategorie());
    }
    public ArrayList<Car> carArrayList = new ArrayList<Car>();
    public void enterCategory(String categ){
        for(Car c: cp ){
            if(categ.equals(c.categorie)){
                carArrayList.add(new Car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public void printCarList(int choose){
        if(choose==1){
        for(Car c:carArrayList){
            System.out.println(c.getCar_name());
            System.out.println(c.getPrice());
            System.out.println(c.getAvailab());
            System.out.println(c.getDescr());
        }}
        else{
            for(Car c:carArrayList){
                System.out.println(c.getCar_name());
                System.out.println(c.getCategorie());
                System.out.println(c.getAvailab());
                System.out.println(c.getDescr());
            }
        }
    }
    public void requestByPrice(int price){
        for(Car c: cp ){
            if(price==c.price){
                carArrayList.add(new Car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public void filterPrice(int price1, int price2,String Categorie){
        for(Car c: cp){
            if(c.price>=price1 && c.price<=price2 && Categorie.equals(c.categorie)){
                carArrayList.add(new Car(c.getCar_name(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public boolean updates = false;
    public boolean appear = false;
    public void updatesSuccessfully(String name,String pass){
        for(User u: up){
            if(name.equals(u.getUser_name())){
                u.setPass(pass);
                updates = true;
                break;
            }
        }
    }
    public void appearInformation(String name){
        for(order o : op){
            if(name.equals(o.Uname)){
                System.out.println(o.Cname);
                System.out.println(o.date);
                appear = true;
            }
        }
    }
    public int exist=0;
    public void addProduct(String name){
        for(Car c:cp)
        {
            if (c.car_name.equals(name)) {
                exist = 1;
                break;
            }
        }
    }
    public int checkPrice =0;
   public void newPrice(String name, int newprice){
       for(Car c: cp)
       {
           if(c.car_name.equals(name)) {
               c.setPrice(newprice);
               checkPrice =1;
           }
       }
   }
}
