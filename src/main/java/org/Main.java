package org;

import today.edu.MyAppT;
import today.edu.User;
import today.edu.Car;
import today.edu.order;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static MyAppT o = new MyAppT();
    static final public String Description = " || Description about it:- ";
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static int exf(String ku,String p)
    {
        int l=0;
        for (User u: o.up)
        {
            if(ku.equals("-")||p.equals("-"))
                l=3;

            else if (ku.equals(u.getUser_name()) && u.getPass().equals(p)) {
                l=1;
            }
        }
        return l;
    }
    public static void iRequestInformationAboutSpecificProductByEnteringItsName2(String name) {

        for(Car c: o.cp ){
            if(name.equals(c.categorie)){
                String k=String.valueOf(c.price);
                String f=String.valueOf(c.availab);
                logger.info("Name:- "+c.car_name+" || Price:- "+k+" || The num of available pieces:- "+f+Description+c.descr);

            }
        }
    }
    public static int changeInfo(String g,String np)
    {
        int f=0;
        for(User c:o.up)
        {
            if(c.user_name.equals(g)) {
                c.setPass(np);
                f=1;
            }
        }
        return f;
    }
    public static void iRequestInformationAboutSpecificProductByEnteringItsName22(int p) {
        int l=0;
        for(Car c: o.cp ){
            if(p==c.price){
                String f=String.valueOf(c.availab);
                System.out.println("Name:- "+c.car_name+" || Category:- "+c.categorie+" || The num of available pieces:- "+f+Description+c.descr);
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
            if (cn.equals(c.car_name)){
                a2=true;
                indexm=counterte;
                break;
            }
            counterte++;
        }
        int fd=o.cp.get(indexm).availab;
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

            int y=o.cp.get(indexm).availab;
            y-=r;
            o.cp.get(indexm).setAvailab(y);
            logger.info("Your installation has done in a successfully way...");
        }

    }

    public static void listting()
    {
        for(Car c:o.cp)
        {
            String forp=String.valueOf(c.price);
            String forp2=String.valueOf(c.availab);
           logger.info("Name:- "+c.car_name+" || Category:- "+c.categorie+" || Price:- "+forp+" || The num of available pieces:- "+forp2+Description+c.descr);
        }
    }
    public static void adding(String u,String p,String bd)
    {
        if(u.isEmpty())
            logger.info("You can't creat account while your name is empty");
        if(p.isEmpty())
            System.out.println("You can't creat account while your password is empty");
        o.up.add(new User(u,p,bd));
        logger.info("Your account created successfully ...");
    }
    public static int theInformationShouldAppear(String name) {
        int a=0;
        for(order o : o.op){
            if(name.equals(o.Uname)){
                System.out.println(o.Cname+"\t"+o.date);
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
            default -> System.out.println("Invalid option selected.");
        }
    }

    private static void displayMainMenu() {
        System.out.println("The menu of our program like that:-");
        System.out.println("1: Sign up to make a new account");
        System.out.println("2: Log in to your previous account");
    }

    private static void signUpProcedure(Scanner input) {
        System.out.println("In order to make a new account you have to enter your information");
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
            System.out.println("You have to write your name cant be empty");
        else if (password.equals("-"))
            System.out.println("You have to write your password cant be empty");
        else if (loginStatus == 0) {
            System.out.println("There's something wrong; there's no account with this information.");
        } else {
            userLoggedIn(input);
        }
    }

    private static String getInput(Scanner input, String prompt) {
        System.out.println(prompt);
        return input.next();
    }

    private static void userLoggedIn(Scanner input) {
        System.out.println("You have logged in successfully");
        System.out.println("Now, in order to see your permissions you have to enter the specific id for your position");
        int userId = input.nextInt();

        switch (userId) {
            case 1 -> handleAdminActions(input);
            case 2 -> System.out.println("This ID means that you are the INSTALLER so your permissions like that:-");
            case 3 -> handleCustomerActions(input);
            default -> System.out.println("Invalid user ID.");
        }
    }
    private static void handleAdminActions(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("You are the ADMIN. Please select an action:");
            System.out.println("1: Manage user accounts");
            System.out.println("2: Manage products");
            System.out.println("3: Manage Availability Date");
            System.out.println("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> adminManageUsers(input);
                case 2 -> adminManageProducts(input);
                case 3 -> addAvailabilityDate(input);
                case 4 -> {
                    continueManaging = false;
                    System.out.println("Logging out as admin.");
                }
                default -> printing();
            }
        }
    }


    private static void handleCustomerActions(Scanner input) {
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("You are the CUSTOMER. Please select an action:");
            System.out.println("1: Buy a product");
            System.out.println("2: Change password");
            System.out.println("3: View order history");
            System.out.println("4: Log out");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> customerBuyProduct(input);
                case 2 -> customerChangePassword(input);
                case 3 -> customerViewOrderHistory(input);
                case 4 -> {
                    continueShopping = false;
                    System.out.println("Logging out as customer.");
                }
                default -> printing();
            }
        }
    }
    private static void adminManageUsers(Scanner input) {
        boolean continueManaging = true;
        while (continueManaging) {
            System.out.println("Select an action for user management:");
            System.out.println("1: Change user information");
            System.out.println("2: Add new user");
            System.out.println("3: See all user accounts");
            System.out.println("4: Return to admin menu");

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
        System.out.println("Enter the username of the account to update:");
        String username = input.next();
        System.out.println("Enter the new password for the account:");
        String newPassword = input.next();

        int result = changeInfo(username, newPassword);
        if (result == 0) {
            System.out.println("No account founded with this gmail");
        } else {
            System.out.println("Password has changed in successfully way");
        }
    }
    private static void addUser(Scanner input) {
        System.out.println("Enter the new username (email):");
        String username = input.next();
        System.out.println("Enter the password for the new account:");
        String password = input.next();
        System.out.println("Enter the birth date for the new account (format DD/MM/YYYY):");
        String birthDate = input.next();
        adding(username, password, birthDate);
    }
    private static void seeAllUsers() {
        o.seeUser();
    }
    private static void printing() {
        System.out.println("Invalid choice, please try again.");
    }

    private static void adminManageProducts(Scanner input) {
        boolean continueManaging=true;
        while (continueManaging) {
            System.out.println("Select an action for product management:");
            System.out.println("1: Add a new product");
            System.out.println("2: List all products");
            System.out.println("3: Search for a product by name");
            System.out.println("4: Search for a product by category");
            System.out.println("5: Search for a product by price");
            System.out.println("6: Return to admin menu");

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
        System.out.println("Enter the name of the product:");
        String name = input.next();
        System.out.println("Enter the product's category:");
        String category = input.next();
        System.out.println("Enter the price of the product:");
        int price = input.nextInt();
        System.out.println("Enter the number of available units:");
        int availability = input.nextInt();
        System.out.println("Enter a description for the product:");
        String description = input.next(); // Assuming description is a single word; if not, use input.nextLine()

        o.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(name, category, price, availability, description);
        System.out.println("Product added successfully.");
    }
    private static void listAllProducts() {
        listting();
    }
    private static void searchProductByName(Scanner input) {
        System.out.println("Enter the name of the product to search:");
        String name = input.next();
        o.iRequestInformationAboutSpecificProductByEnteringItsName(name);
    }
    private static void searchProductByCategory(Scanner input) {
        System.out.println("Enter the category of the products to search:");
        String category = input.next();
        iRequestInformationAboutSpecificProductByEnteringItsName2(category);
    }
    private static void searchProductByPrice(Scanner input) {
        System.out.println("Enter the price of the product to search:");
        int price = input.nextInt();
        iRequestInformationAboutSpecificProductByEnteringItsName22(price);
    }


    private static void addAvailabilityDate(Scanner input) {
        System.out.println("Write the date that you want to make it available for buying (format DD/MM/YYYY):");
        String date = input.next();
        o.date.add(date);
        System.out.println("Date added successfully.");
    }



    private static void customerBuyProduct(Scanner input) {
        System.out.println("Please enter the name of the product you wish to purchase:");
        String productName = input.next();
        System.out.println("Enter the desired date for purchase:");
        String purchaseDate = input.next();
        System.out.println("Enter the quantity you wish to purchase:");
        int quantity = input.nextInt();
        buying(productName, purchaseDate, quantity);
    }

    private static void customerChangePassword(Scanner input) {
        System.out.println("Enter your current email:");
        String email = input.next();
        System.out.println("Enter your new password:");
        String newPassword = input.next();
        int result = o.yourInformationUpdatesSuccessfully(email, newPassword);
        if (result == 1) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Failed to change password. User not found.");
        }
    }

    private static void customerViewOrderHistory(Scanner input) {
        System.out.println("Enter your email to view order history:");
        String email = input.next();
        int result = theInformationShouldAppear(email);
        if (result == 0) {
            System.out.println("No orders found for this email.");
        }
    }


}
