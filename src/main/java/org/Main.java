package org;

import today.edu.MyAppT;
import today.edu.User;
import today.edu.car;
import today.edu.order;

import java.util.Scanner;
import java.util.logging.Logger;
public class Main {
    static MyAppT o = new MyAppT();
    static boolean cm= true;
    static boolean cm2=true;
    static public String genera;
    private static final String ACTION_1 = "|| Description about it:- "; 
    private static final String ACTION_2 = "Name:- ";
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
    public static void printing ()
    {
        logger.info("Sorry no choice as that ...");
        logger.info("Please repeat the process again... ");
    }
    public static void iRequestInformationAboutSpecificProductByEnteringItsName2(String name) {

        for(car c: o.cp ){
            if(name.equals(c.categorie)){
                String k=String.valueOf(c.price);
                String f=String.valueOf(c.availab);
               logger.info(ACTION_2+c.car_name+" || Price:- "+k+" || The num of available pieces:- "+f+ ACTION_1+c.descr);

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
    public static int iRequestInformationAboutSpecificProductByEnteringItsName22(int p) {
        int l=0;
        for(car c: o.cp ){
            if(p==c.price){
                String f=String.valueOf(c.availab);
                logger.info(ACTION_2+c.car_name+" || Category:- "+c.categorie+" || The num of available pieces:- "+f+ACTION_1+c.descr);
                l=1;
            }
            if(l==0)
               logger.info("No product with this price in our company");
        }
        return l;
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
        for(car c : o.cp){
            if (cn.equals(c.car_name)){
                a2=true;
                indexm=counterte;
                break;
            }
            counterte++;
        }
        int fd=o.cp.get(indexm).availab;
        if(a1==false) {

           logger.info("cant buy this product in this day sorry...");
        }
        else if (a2==false) {

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
        for(car c:o.cp)
        {
            String forp=String.valueOf(c.price);
            String forp2=String.valueOf(c.availab);
            logger.info(ACTION_2+c.car_name+" || Category:- "+c.categorie+" || Price:- "+forp+" || The num of available pieces:- "+forp2+ACTION_1+c.descr);
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
    public static boolean corn()
    {
        logger.info("Do you want to do anther thing ??!");
        Scanner input=new Scanner(System.in);
        boolean cm=true;
        String res = input.next();
        if (res.equals("No") || res.equals("no"))
            cm = false;
        return cm;
    }
    public static int theInformationShouldAppear(String name) {
        int a=0;
        for(order o : o.op){
            if(name.equals(o.Uname)){
               logger.info(o.Cname+"\t"+o.date);
                a=1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        logger.info( "The menu of our programme like that:-");
        logger.info("1:sign up to make a new account");
        logger.info("2:log in to your previous account");
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        if (n == 1) {
            logger.info("In order to make a new account you have to enter your information");
            logger.info("Please enter your Gmail");
            String s1;
            s1 = input.next();
            logger.info("Please enter your password");
            String s2;
            s2 = input.next();
            logger.info("Please enter your BirthDate");
            String s3;
            s3=input.next();
            adding(s1, s2, s3);
        }
        if (n == 2) {
            logger.info("Enter the Gmail for your account");
            String s1;
            s1 = input.next();
            genera=s1;
            logger.info("Enter the password for your account");
            String s2;
            s2 = input.next();
            int v = exf(s1, s2);
            if (s1.equals("-"))
                logger.info("You have to write your name cant be empty");
            else if (s2.equals("-"))
                logger.info("You have to write your password cant be empty");
            else if (v == 0)
                logger.info("There's something wrong there's no account with this information");
            else
            {
                logger.info("you have logged successfully");
                logger.info("Now in order to see your permissions you have to enter the specific id for your position");
                int m=input.nextInt();
                if(m==1) {
                    logger.info("This ID means that you are the ADMIN so your permissions like that:-");
                    while (cm)
                    {
                        logger.info("1:-You can manage user account");
                        logger.info("2:-You can manage the products in the company");
                        int Role=input.nextInt();
                        if(Role==1)
                        {
                            logger.info("1:- Change information for previous users");
                            logger.info("2:- adding new user");
                            logger.info("3:- See all user accounts");
                            int koiut = input.nextInt();
                            if(koiut==1)
                            {
                                logger.info("You can change the password for account by giving its gmail");
                                String mg=input.next();
                                logger.info("Write the new password for the email");
                                String npp=input.next();
                                int f=changeInfo(mg,npp);
                                if(f==0)
                                {
                                    logger.info("No account founded with this gmail");
                                }
                                else {
                                    logger.info("Password has changed in successfully way");
                                   
                                    cm=corn();
                                }
                            }
                            else if(koiut==2)
                            {
                                cm=true;
                                logger.info("Please enter the Gmail for the account that you want to creat it ");
                                String s111;
                                s111 = input.next();
                                logger.info("Please enter the password for the account that you want to creat it ");
                                String s211;
                                s211 = input.next();
                                logger.info("Please enter the BirthDate for the user that you want to make account for him");
                                String s333;
                                s333=input.next();
                                adding(s111, s211, s333);
                                
                                cm=corn();
                            }
                            else if(koiut==3)
                            {
                                o.seeUser();
                               
                                cm=corn();
                            }
                            else
                            {
                                printing();
                            }
                        }
                        else if(Role==2) {
                            logger.info("1:- Add a new product .");
                            logger.info("2:- Make a list for all the products in the company .");
                            logger.info("3:- Search on a product by entering it's name .");
                            logger.info("4:- Search on a product by entering it's category .");
                            logger.info("5:- Search on a product by entering it's price .");
                            int k = input.nextInt();
                            if (k == 1) {
                                logger.info("Enter the name of the product that you want to add");
                                String name = input.next();
                                logger.info("Enter the category's name that your product belong to");
                                String category = input.next();
                                logger.info("Enter the price of the product that you want to add");
                                int y = input.nextInt();
                                logger.info("Enter how many pieces from this product you want to add");
                                int a = input.nextInt();
                                logger.info("write a discribtion about the product that you want to add");
                                String de = input.next();
                                o.theNameIsAndCategorieIsAndPriceIsAndAvailabilityIsAndDescriptionsIs(name, category, y, a, de);
                               
                                cm=corn();
                            } else if (k == 2) {
                                cm = true;
                                listting();
                                
                                cm=corn();
                            } else if (k == 3) {
                                cm = true;
                                logger.info("Write the name of the product that you are searching on it??!");
                                String name = input.next();
                                o.iRequestInformationAboutSpecificProductByEnteringItsName(name);
                               
                                cm=corn();
                            } else if (k == 4) {
                                cm = true;
                                logger.info("Write the category that your product that you are searching on it belong to it??!");
                                String name = input.next();
                                iRequestInformationAboutSpecificProductByEnteringItsName2(name);
                                
                                cm=corn();
                            } else if (k == 5) {
                                cm = true;
                                logger.info("Write the price for the product that you are searching on");
                                int kkk = input.nextInt();
                                int j=iRequestInformationAboutSpecificProductByEnteringItsName22(kkk);
                                
                                cm=corn();
                            }
                            else {
                                printing();
                            }
                        }
                        else if (Role==3)
                        {
                            logger.info("Write the date that you want to make it available for buying");
                            String d=input.next();
                            o.date.add(d);
                            logger.info("Done in Successfully way");
                           
                            cm=corn();
                        }
                        else {
                            printing();
                        }
                    }
                }
                else if (m==2)
                {
                    logger.info("This ID means that you are the INSTALLER so your permissions like that:-");
                }
                else if(m==3)
                {
                    while(cm2) {
                        logger.info("This ID means that you are the CUSTOMER so your permissions like that:-");
                        logger.info("1:-you could buy a product so if you want please enter these information");
                        logger.info("2:-you could change your password");
                        int b=input.nextInt();
                        if(b==1) {
                            logger.info("Please enter the name of the product that you want to buy it");
                            String h = input.next();
                            logger.info("write the date for buying this product");
                            String klj = input.next();
                            logger.info("Write the number of peaces that you want to buy it from this product");
                            String fff = input.next();
                            int cv = Integer.parseInt(fff);
                            buying(h, klj, cv);
                           
                            cm2 = corn();
                        }
                        else if(b==2)
                        {
                            logger.info("enter the new password that you want to have it");
                            String np=input.next();
                            int l=o.yourInformationUpdatesSuccessfully(genera,np);
                            if(l==1)
                               logger.info("done in successfully way");
                            
                            cm2 = corn();
                        }
                        else if(b==3)
                        {
                            int ll=theInformationShouldAppear(genera);
                            if(ll==0)
                                logger.info("No previous orders");
                            
                            cm2 = corn();
                        }
                    }
                }
                else
                {
                    logger.info("There's something wrong no number like that");
                }
            }
        }
    }
}
