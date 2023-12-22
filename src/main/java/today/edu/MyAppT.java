package today.edu;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class MyAppT
{
    private boolean isLogged;
    private boolean validation;
    private   boolean isInstallation=false;
    private boolean submit = false;
    private boolean available1 = false;
    private boolean available2 = false;
    private   List<User> up=new  ArrayList<>();
    private  List<Car> cp = new  ArrayList<>();
    private   List<Order> op = new  ArrayList<>();
    private  List<String>date = new  ArrayList<>();

    public List<User> getUp() {
        return up;
    }
    public void addUser(User user) {
        up.add(user);
    }
    public List<Car> getCp() {
        return cp;
    }
    public void addCar(Car car) {
        cp.add(car);
    }
    public List<Order> getOp() {
        return op;
    }
    public void addOrder(Order order) {
        op.add(order);
    }
    public List<String> getDate() {
        return date;
    }
    public void addDate(String dates) {
        date.add(dates);
    }
    private static final Logger logger = Logger.getLogger(MyAppT.class.getName());
    public boolean getIsLogged(){
       return  isLogged;
    }
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public boolean getValidation(){
        return validation;
    }
    public boolean getInstallation(){
        return isInstallation;
    }
    public void setInstallation(boolean installation){
        this.isInstallation=installation;
    }
    public boolean getSubmit(){
        return submit;
    }
    public void setSubmit(boolean submit){
        this.submit=submit;
    }
    public boolean getAvailable1(){
        return available1;
    }
    public boolean getAvailable2(){return available2;}
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
        Order o1 = new Order(u3.getUserName(), c2.getCarName(), "20-10-2023");
        op.add(o1);
        date.add("20-10-2023");
        date.add("22-10-2023");
        date.add("5-11-2023");
    }
    public void setUsernameAndPassAndPassFromSystem(String name, String pass) {

        for (User u: up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;
            }}
    }
    public void setInvalidUsernameAndPass(String name, String pass) {
        // Write code here that turns the phrase above into concrete actions
        for (User u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setValidUsernameAndInvalidPass(String name, String pass) {
        for (User u: up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true; break;
            }
        }
    }
    public void setEmptyUsernameAndPass(String name, String pass) {
        if (name.isEmpty() && !pass.isEmpty())
            validation = false;
    }
    public void setValidUsernameAndEmptyPass(String name, String pass) {
        if (pass.isEmpty()&& !name.isEmpty())
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
            if(name.equals(c.getCarName())){
                String k=String.valueOf(c.getPrice());
                String f=String.valueOf(c.getAvailab());

                logger.info("Category:- "+c.getCategorie()+" || Price:- "+k+" || The num of available pieces:- "+f+" || Discribtion about it:- "+c.getDescr());
            }
        }
    }
    public void seeUser()
    {
        for(User c:up)
        {

            logger.info("Gmail:- "+c.getUserName() +"\t"+"Password:- "+c.getPass()+"\t"+"BirthDate:- "+c.getB());
        }
    }
    int yuy=0;
    public int yourInformationUpdatesSuccessfully(String name,String pass) {
        for (User u : getUp()) {
            if (name.equals(u.getUserName())) {
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
    public void validUserPass(String userName, String pass){
        forget = false;
        for (User u: up) {
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
                forget = true;
                enteredUsername = userName;
                break;
            }}
    }
    public void takePass(String newPass){
        for (User user : up) {
            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
            }
        }
        for (User user : up) {
            if (user.getUserName().equals(enteredUsername) && user.getPass().equals(newPass)) {
                passwordUpdated = true;
                break;
            }}
    }
    public void createAcc(String enteredUsernam,String enteredPasswor){
        for (User user : up) {
            if (user.getUserName().equals(enteredUsernam) && user.getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }
        }
    }
    public void setNamePass(String userName, String pass){
        for (User u: up) {
            if (userName.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;
                break;
            }
        }
    }
    public String dateee ;
    public String cname;
    public void fillModelAndDate(String model,String datee){
        for(String d: getDate()){
            if (d.equals(datee)) {
                available1 = true;
                dateee = datee;
                break;
            }
        }
        for(Car c : cp){
            if (model.equals(c.getCarName())){
                available2 = true;
                cname = model;
                break;
            }
        }
    }
    public void printCatalog(Car cc){
        logger.info(cc.getDescr());
        String k=String.valueOf(cc.getPrice());
        logger.info(k);
        String kk=String.valueOf(cc.getAvailab());
        logger.info(kk);
        logger.info(cc.getCategorie());
    }
    public List<Car> carArrayList = new ArrayList<>();
    public void enterCategory(String categ){
        for(Car c: cp ){
            if(categ.equals(c.getCategorie())){
                carArrayList.add(new Car(c.getCarName(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public void printCarList(int choose){
        if(choose==1){
            for(Car c:carArrayList){
                logger.info(c.getCarName());
                String kk=String.valueOf(c.getPrice());
                logger.info(kk);
                String kkk=String.valueOf(c.getAvailab());
                logger.info(kkk) ;
                logger.info(c.getDescr());
            }}
        else{
            for(Car c:carArrayList){
                logger.info(c.getCarName());
                logger.info(c.getCategorie());
                String kkk=String.valueOf(c.getAvailab());
                logger.info(kkk) ;
                logger.info(c.getDescr());
            }
        }
    }
    public void requestByPrice(int price){
        for(Car c: getCp() ){
            if(price==c.getPrice()){
                carArrayList.add(new Car(c.getCarName(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public void filterPrice(int price1, int price2,String categorie){
        for(Car c: cp){
            if(c.getPrice()>=price1 && c.getPrice()<=price2 && categorie.equals(c.getCategorie())){
                carArrayList.add(new Car(c.getCarName(),c.getCategorie(),c.getPrice(),c.getAvailab(),c.getDescr()));
            }
        }
    }
    public boolean updates = false;
    public boolean appear = false;
    public void updatesSuccessfully(String name,String pass){
        for(User u: up){
            if(name.equals(u.getUserName())){
                u.setPass(pass);
                updates = true;
                break;
            }
        }
    }
    public void appearInformation(String name){
        for(Order o : getOp()){
            if(name.equals(o.getUname())){
                logger.info(o.getCname());
                logger.info(o.getDate());
                appear = true;
            }
        }
    }
    private int exist=0;
    public void setE(){exist=1;}
    public int getE(){return exist;}
    public void addProduct(String name){
        for(Car c:cp)
        {
            if ((c.getCarName()).equals(name)) {
                setE();
                break;
            }
        }
    }
    private int checkPrice =0;
    public int getCheck(){return checkPrice;}
    public void setCheck(){checkPrice=1;}
    public void newPrice(String name, int newprice){
        for(Car c: cp)
        {
            if((c.getCarName()).equals(name)) {
                c.setPrice(newprice);
                setCheck();
            }
        }
    }
}
