package org;

import today.edu.MyAppT;
import today.edu.User;
import today.edu.Car;
import today.edu.Order;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger =  Logger.getLogger(Main.class.getName());
    static MyAppT o = new MyAppT();
    public static final  String DESCRIPTION = " || Description about it:- ";
    public static final  String NAMES = " Name:- ";
    public static final  String AVAILABLES = " || The num of available pieces:- ";
    public static int exf(String ku,String p)
    {
        int l=0;
        for (User u: o.up)
        {
            if(ku.equals("-")||p.equals("-"))
                l=3;

            else if (ku.equals(u.getUserName()) && u.getPass().equals(p)) {
                l=1;
            }
        }
        return l;
    }
    public static void iRequestInformationAboutSpecificProductByEnteringItsName2(String name) {

        for(Car c: o.cp ){
            if(name.equals(c.getCategorie() )){
                String k=String.valueOf(c.getPrice());
                String f=String.valueOf(c.getAvailab());
                logger.info(NAMES+c.getCarName()+" || Price:- "+k+AVAILABLES+f+DESCRIPTION+c.getDescr());

            }
        }
    }
    public static int changeInfo(String g,String np)
    {
        int f=0;
        for(User c:o.up)
        {
            if(c.getUserName().equals(g)) {
                c.setPass(np);
                f=1;
            }
        }
        return f;
    }
    public static void iRequestInformationAboutSpecificProductByEnteringItsName22(int p) {
        int l=0;
        for(Car c: o.cp ){
            if(p==c.getPrice() ){
                String f=String.valueOf(c.getAvailab());
                logger.info(NAMES+c.getCarName()+" || Category:- "+c.getCategorie() +AVAILABLES+f+DESCRIPTION+c.getDescr());
                l=1;
            }
            if(l==0)
                logger.info("No product with this price in our company");
        }
    }
    public static void buying(String cn,String d,int r)
    {
        boolean a1=false;
        boolean a2=false;
        for(String dd: o.date) {
            if (dd.equals(d)) {
                a1 = true;
                break;
            }
        }
        int indexm=0;
        int counterte=0;
        for(Car c : o.cp){
            if (cn.equals(c.getCarName())){
                a2=true;
                indexm=counterte;
                break;
            }
            counterte++;
        }
        int fd= o.cp.get(indexm).getAvailab();
        if(!a1) {

            logger.info("cant buy this product in this day sorry...");
        }
        else if (!a2) {

            logger.info("There is no product with this name in our company sorry...");
        }
        else if (fd<r) {

            logger.info("We dont have the amount that you need from this product sorry...");
        }
        else {

            int y= o.cp.get(indexm).getAvailab();
            y-=r;
            o.cp.get(indexm).setAvailab(y);
            logger.info("Your installation has done in a successfully way...");
        }

    }

    public static void listting()
    {
        for(Car c:o.cp)
        {
            String forp=String.valueOf(c.getPrice());
            String forp2=String.valueOf(c.getAvailab());
            logger.info(NAMES+c.getCarName()+" || Category:- "+c.getCategorie()+" || Price:- "+forp+AVAILABLES+forp2+DESCRIPTION+c.getDescr());
        }
    }
    public static void adding(String u,String p,String bd)
    {
        if(u.isEmpty())
            logger.info("You can't creat account while your name is empty");
        if(p.isEmpty())
            logger.info("You can't creat account while your password is empty");
        o.up.add(new User(u,p,bd));
        logger.info("Your account created successfully ...");
    }
    public static int theInformationShouldAppear(String name) {
        int a=0;
        for(Order o : o.op){
            if(name.equals(o.getUname())){
                logger.info(o.getCname()+"\t"+o.getDate());
                a=1;
            }
        }
        return a;
    }


    public static void main(String[] args) {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> signUpProcedure(input);
            case 2 -> loginProcedure(input);
            default -> logger.info("Invalid option selected.");
        }
    }

    private static void displayMainMenu() {
        logger.info("The menu of our program like that:-");
        logger.info("1: Sign up to make a new account");
        logger.info("2: Log in to your previous account");
    }

    private static void signUpProcedure(Scanner input) {
        logger.info("In order to make a new account you have to enter your information");
        String email = getInput(input, "Please enter your Gmail");
        String password = getInput(input, "Please enter your password");
        String birthDate = getInput(input, "Please enter your BirthDate");
        adding(email, password, birthDate);
    }

    private static void loginProcedure(Scanner input) {
        String email = getInput(input, "Enter the Gmail for your account");
        String password = getInput(input, "Enter the password for your account");

        int loginStatus = exf(email, password);
        if (email.equals("-"))
            logger.info("You have to write your name cant be empty");
        else if (password.equals("-"))
            logger.info("You have to write your password cant be empty");
        else if (loginStatus == 0) {
            logger.info("There's something wrong; there's no account with this information.");
        } else {
            userLoggedIn(input);
        }
    }

    private static String getInput(Scanner input, String prompt) {
        logger.info(prompt);
        return input.next();
    }

    private static void userLoggedIn(Scanner input) {
        logger.info("You have logged in successfully");
        logger.info("Now, in order to see your permissions you have to enter the specific id for your position");
        int userId = input.nextInt();

        switch (userId) {
            case 1 -> handleAdminActions(input);
            case 2 -> System.out.println("This ID means that you are the INSTALLER so your permissions like that:-");
            case 3 -> handleCustomerActions(input);
            default -> logger.info("Invalid user ID.");
        }
    }
    private static void handleAdminActions(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("You are the ADMIN. Please select an action:");
            logger.info("1: Manage user accounts");
            logger.info("2: Manage products");
            logger.info("3: Manage Availability Date");
            logger.info("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> adminManageUsers(input);
                case 2 -> adminManageProducts(input);
                case 3 -> addAvailabilityDate(input);
                case 4 -> {
                    continueManaging = false;
                    logger.info("Logging out as admin.");
                }
                default -> printing();
            }
        }
    }


    private static void handleCustomerActions(Scanner input) {
        boolean continueShopping = true;
        while (continueShopping) {
            logger.info("You are the CUSTOMER. Please select an action:");
            logger.info("1: Buy a product");
            logger.info("2: Change password");
            logger.info("3: View order history");
            logger.info("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> customerBuyProduct(input);
                case 2 -> customerChangePassword(input);
                case 3 -> customerViewOrderHistory(input);
                case 4 -> {
                    continueShopping = false;
                    logger.info("Logging out as customer.");
                }
                default -> printing();
            }
        }
    }
    private static void adminManageUsers(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            logger.info("Select an action for user management:");
            logger.info("1: Change user information");
            logger.info("2: Add new user");
            logger.info("3: See all user accounts");
            logger.info("4: Return to admin menu");

            int action = input.nextInt();
            switch (action) {
                case 1 -> changeUserInformation(input);
                case 2 -> addUser(input);
                case 3 -> seeAllUsers();
                case 4 -> continueManaging = false;
                default -> printing();
            }
        }
    }
    private static void changeUserInformation(Scanner input) {
        logger.info("Enter the username of the account to update:");
        String username = input.next();
        logger.info("Enter the new password for the account:");
        String newPassword = input.next();

        int result = changeInfo(username, newPassword);
        if (result == 0) {
            logger.info("No account founded with this gmail");
        } else {
            logger.info("Password has changed in successfully way");
        }
    }
    private static void addUser(Scanner input) {
        logger.info("Enter the new username (email):");
        String username = input.next();
        logger.info("Enter the password for the new account:");
        String password = input.next();
        logger.info("Enter the birth date for the new account (format DD/MM/YYYY):");
        String birthDate = input.next();
        adding(username, password, birthDate);
    }
    private static void seeAllUsers() {
        o.seeUser();
    }
    private static void printing() {
        logger.info("Invalid choice, please try again.");
    }

    private static void adminManageProducts(Scanner input) {
        boolean continueManaging=true;
        while (continueManaging) {
            logger.info("Select an action for product management:");
            logger.info("1: Add a new product");
            logger.info("2: List all products");
            logger.info("3: Search for a product by name");
            logger.info("4: Search for a product by category");
            logger.info("5: Search for a product by price");
            logger.info("6: Return to admin menu");

            int action = input.nextInt();
            switch (action) {
                case 1 -> addProduct(input);
                case 2 -> listAllProducts();
                case 3 -> searchProductByName(input);
                case 4 -> searchProductByCategory(input);
                case 5 -> searchProductByPrice(input);
                case 6 -> continueManaging = false;
                default -> printing();
            }
        }
    }
    private static void addProduct(Scanner input) {
        logger.info("Enter the name of the product:");
        String name = input.next();
        logger.info("Enter the product's category:");
        String category = input.next();
        logger.info("Enter the price of the product:");
        int price = input.nextInt();
        logger.info("Enter the number of available units:");
        int availability = input.nextInt();
        logger.info("Enter a description for the product:");
        String description = input.next(); // Assuming description is a single word; if not, use input.nextLine()

        o.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(name, category, price, availability, description);
        logger.info("Product added successfully.");
    }
    private static void listAllProducts() {
        listting();
    }
    private static void searchProductByName(Scanner input) {
        logger.info("Enter the name of the product to search:");
        String name = input.next();
        o.iRequestInformationAboutSpecificProductByEnteringItsName(name);
    }
    private static void searchProductByCategory(Scanner input) {
        logger.info("Enter the category of the products to search:");
        String category = input.next();
        iRequestInformationAboutSpecificProductByEnteringItsName2(category);
    }
    private static void searchProductByPrice(Scanner input) {
        logger.info("Enter the price of the product to search:");
        int price = input.nextInt();
        iRequestInformationAboutSpecificProductByEnteringItsName22(price);
    }


    private static void addAvailabilityDate(Scanner input) {
        logger.info("Write the date that you want to make it available for buying (format DD/MM/YYYY):");
        String date = input.next();
        o.date.add(date);
        logger.info("Date added successfully.");
    }



    private static void customerBuyProduct(Scanner input) {
        logger.info("Please enter the name of the product you wish to purchase:");
        String productName = input.next();
        logger.info("Enter the desired date for purchase:");
        String purchaseDate = input.next();
        logger.info("Enter the quantity you wish to purchase:");
        int quantity = input.nextInt();
        buying(productName, purchaseDate, quantity);
    }

    private static void customerChangePassword(Scanner input) {
        logger.info("Enter your current email:");
        String email = input.next();
        logger.info("Enter your new password:");
        String newPassword = input.next();
        int result = o.yourInformationUpdatesSuccessfully(email, newPassword);
        if (result == 1) {
            logger.info("Password changed successfully.");
        } else {
            logger.info("Failed to change password. User not found.");
        }
    }

    private static void customerViewOrderHistory(Scanner input) {
        logger.info("Enter your email to view order history:");
        String email = input.next();
        int result = theInformationShouldAppear(email);
        if (result == 0) {
            logger.info("No orders found for this email.");
        }
    }


}
