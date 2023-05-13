
import java.util.Scanner;
import java.util.Objects;
import java.util.Vector;
import Item.Category;
import SystemAccounts.Customer;
import SystemAccounts.Guest;
import SystemAccounts.Owner;
import SystemAccounts.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.security.SecureRandom;

public class Engine {

    public  Guest g1 = new Guest();
    public  User user1=null;
    public static  int OTP_LENGTH=6;
    public static String OTP_CHARACTERS="0123456789";
    public boolean flow=true;

    public static String generateOTP() {
        StringBuilder sb = new StringBuilder(OTP_LENGTH);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < OTP_LENGTH; i++) {
            int randomIndex = random.nextInt(OTP_CHARACTERS.length());
            sb.append(OTP_CHARACTERS.charAt(randomIndex));
        }
        return sb.toString();
    }



    public  void Admin_menu() {
        System.out.println("1.addItem");
        System.out.println("2.addCategory");
        System.out.println("3.View Categories");
        System.out.println("4.viewAllItems");
        System.out.println("5.SearchByName");
        System.out.println("6.SearchByBrand:");
        System.out.println("7.SearchByPrice");
        System.out.println("8.setDiscount");
    }

    public void load_users(){
        User.Users.clear();
        try {
            File myObj = new File("C:\\Users\\iTECH\\OneDrive\\Desktop\\sendEmail\\sendEmail\\src\\main\\java\\Accounts.txt");
            Scanner myReader = new Scanner(myObj);
            Vector<String>data=new Vector<String>(); int x=1;
            while (myReader.hasNextLine()) {
                String t = myReader.nextLine();
                data.add(t);
                if(x%5==0 ) {
                    if (Objects.equals(data.get(0) , "1")) {
                        Owner new_one = new Owner(data.get(1), data.get(4), data.get(2), data.get(3));
                        // User.Users.add((User) new_one);
                    }
                    else if(Objects.equals(data.get(0) , "2")){
                        SystemAccounts.GeneralAdmin new_one = new SystemAccounts.GeneralAdmin(data.get(1), data.get(4), data.get(2), data.get(3));
                        //User.Users.add((User) new_one);
                    }
                    else{
                        Customer new_one = new Customer(data.get(1), data.get(4), data.get(2), data.get(3));
                        // User.Users.add((User) new_one);
                    }
                    data.clear();
                }


                //System.out.println(data);
                x++;
            }
            myReader.close();
        }


        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public  void Owner_menu() {
        System.out.println("1.addItem");
        System.out.println("2.addCategory");
        System.out.println("3.View Categories");
        System.out.println("4.viewAllItems");
        System.out.println("5.SearchByName");
        System.out.println("6.SearchByBrand:");
        System.out.println("7.SearchByPrice");
        System.out.println("8.setDiscount");
        System.out.println("9.Add Admin");
        System.out.println("9.Remove Admin");
    }

    public void Admin_flow(){
        SystemAccounts.GeneralAdmin A1 = (SystemAccounts.GeneralAdmin) user1;
        Scanner myObj = new Scanner(System.in);
        int i = myObj.nextInt();
        myObj.nextLine();
        switch (i) {
            case (1):
                //myObj.nextLine();
                System.out.println("Enter Item Name : ");
                String n = myObj.nextLine();
                System.out.println("Enter Item Description : ");
                String d = myObj.nextLine();
                System.out.println("Enter Brand Name : ");
                String b = myObj.nextLine();
                System.out.println("Enter Amount Number : ");
                int a = myObj.nextInt();
                System.out.println("Enter discount Number : ");
                float dis = myObj.nextFloat();
                System.out.println("Enter Price Number : ");
                double prc = myObj.nextDouble();
                A1.addItem(n,a,b,d,prc,dis);

                break;
            case (2):
                System.out.println("Enter Category Name : ");
                String e = myObj.nextLine();
                A1.addCategory(e);
                break;
            case (3):
                Catalog.Catalog.viewCategories();
                break;
            case (4):
                Catalog.Catalog.ShowAll();
                break;
            case (5):
                System.out.println("Enter Item Name : ");
                String N1 = myObj.nextLine();
                Catalog.Catalog.SearchByName(N1);
                break;
            case (6):
                myObj.nextLine();
                System.out.println("Enter Item Brand : ");
                String B1 = myObj.nextLine();
                Catalog.Catalog.SearchByBrand(B1);
                break;
            case (7):
                //myObj.nextLine();
                System.out.println("Enter Item Price : ");
                double P1 = myObj.nextDouble();
                Catalog.Catalog.SearchByPrice(P1);
                break;


            default:
                flow = false;
                break;
        }
    }


    public  void Guest_menu() {
        System.out.println("1.Signup");
        System.out.println("2.Login");
        System.out.println("3.View Categories");
        System.out.println("4.viewAllItems");
        System.out.println("5.SearchByName");
        System.out.println("6.SearchByBrand:");
        System.out.println("7.SearchByPrice");
    }



    public  void Customer_menu() {
        System.out.println("1.add Item to cart");
        System.out.println("2.view order history");
        System.out.println("3.View Categories");
        System.out.println("4.viewAllItems");
        System.out.println("5.SearchByName");
        System.out.println("6.SearchByBrand:");
        System.out.println("7.SearchByPrice");
        System.out.println("8.view Cart");
        System.out.println("9.remove Item from cart");
        System.out.println("10.Make Order");
    }

    public void Customer_flow(){
        Customer c1 = (Customer)user1;
        Scanner myObj = new Scanner(System.in);
        int i = myObj.nextInt();
        myObj.nextLine();
        switch (i) {
            case (1):
                //myObj.nextLine();
                System.out.println("Enter Item Id : ");
                int n = myObj.nextInt();
                System.out.println("Enter amount : ");
                int w = myObj.nextInt();
                c1.AddtoCart(n,w);
                System.out.println("--------------------------------");
                System.out.println("Added Successfully to your Cart");
                System.out.println("--------------------------------");
                break;
            case (2):
                c1.OrderHistory();
                break;
            case (3):
                Catalog.Catalog.viewCategories();
                break;
            case (4):
                Catalog.Catalog.ShowAll();
                break;
            case (5):
                System.out.println("Enter Item Name : ");
                String N1 = myObj.nextLine();
                if(Catalog.Catalog.SearchByName(N1) == false){
                    System.out.println("--------------");
                    System.out.println("Item Not Found");
                    System.out.println("---------------");
                };
                break;
            case (6):
                myObj.nextLine();
                System.out.println("Enter Item Brand : ");
                String B1 = myObj.nextLine();
                if(Catalog.Catalog.SearchByBrand(B1)==false){
                    System.out.println("--------------");
                    System.out.println("Item Not Found");
                    System.out.println("---------------");
                };
                break;
            case (7):
                //myObj.nextLine();
                System.out.println("Enter Item Price : ");
                double P1 = myObj.nextDouble();
                if(Catalog.Catalog.SearchByPrice(P1)==false){
                    System.out.println("--------------");
                    System.out.println("Item Not Found");
                    System.out.println("---------------");
                };
                break;
            case(8) :
                c1.cart.displayCart();
                break;
            case(9) :
                System.out.println("Enter Item Id : ");
                int r_ = myObj.nextInt();
                c1.RemovefromCart(r_);
                break;

            case(10)  :
                c1.make_order();
                break;

            default:
                flow = false;
                break;
        }
    }


    public  void Guest_flow() {
        Customer c1 = (Customer)user1;

        Scanner myObj = new Scanner(System.in);
        int i = myObj.nextInt();
        myObj.nextLine();
        switch (i) {
            case (1):
                //myObj.nextLine();
                System.out.println("Your Name : ");
                String Name = myObj.nextLine();
                System.out.println("password : ");
                String Password = myObj.nextLine();
                System.out.println(" mail : ");
                String mail = myObj.nextLine();
                System.out.println("phone : ");
                String phone = myObj.nextLine();

                user1 = g1.Register(Name, mail, Password, phone);
                    EmailSender new_one = new EmailSender("otpSenderverification@outlook.com","otpSender");
                    String otp = Engine.generateOTP();
                    new_one.sendEmail(otp,mail);
                    System.out.print("Enter otp : ");
                    String otp1 = myObj.nextLine();
                    if(Objects.equals(otp1,otp)) {

                        try {
                            File Obj = new File("C:\\Users\\iTECH\\OneDrive\\Desktop\\sendEmail\\sendEmail\\src\\main\\java\\Accounts.txt");
                            if (Obj.exists()) {
                                FileWriter Objw = new FileWriter("C:\\Users\\iTECH\\OneDrive\\Desktop\\sendEmail\\sendEmail\\src\\main\\java\\Accounts.txt", true);
                                if (user1 instanceof Owner) {
                                    Objw.append("2");
                                    Objw.append("\n");
                                } else if (user1 instanceof SystemAccounts.GeneralAdmin) {
                                    Objw.append("1");
                                    Objw.append("\n");
                                } else {
                                    Objw.append("3");
                                    Objw.append("\n");
                                }

                                Objw.append(user1.getByName());
                                Objw.append("\n");
                                Objw.append(user1.getByEmail());
                                Objw.append("\n");
                                Objw.append(user1.getByPhone());
                                Objw.append("\n");
                                Objw.append(user1.getByPassword());
                                Objw.append("\n");
                                Objw.close();
                            } else {
                                FileWriter Objw = new FileWriter("Accounts.txt", true);
                                if (user1 instanceof Owner) {
                                    Objw.append("2");
                                    Objw.append("\n");
                                } else if (user1 instanceof SystemAccounts.GeneralAdmin) {
                                    Objw.append("1");
                                    Objw.append("\n");
                                } else {
                                    Objw.append("3");
                                    Objw.append("\n");
                                }

                                Objw.append(user1.getByName());
                                Objw.append("\n");
                                Objw.append(user1.getByEmail());
                                Objw.append("\n");
                                Objw.append(user1.getByPhone());
                                Objw.append("\n");
                                Objw.append(user1.getByPassword());
                                Objw.append("\n");
                                Objw.close();
                            }

                        } catch (IOException e) {

                        }
                    }
                    else{
                        System.out.println("Wrong otp !!");
                        user1=null;
                    }
                break;
            case (2):
                String e = myObj.nextLine();
                String p = myObj.nextLine();
                user1 = g1.Login(e, p);
                System.out.println(SystemAccounts.User.Users.size());
                break;
            case (3):
                Catalog.Catalog.viewCategories();
                break;
            case (4):
                Catalog.Catalog.ShowAll();
                break;
            case (5):
                System.out.println("Enter Item Name : ");
                String N1 = myObj.nextLine();
                Catalog.Catalog.SearchByName(N1);
                break;
            case (6):
                myObj.nextLine();
                System.out.println("Enter Item Brand : ");
                String B1 = myObj.nextLine();
                Catalog.Catalog.SearchByBrand(B1);
                break;
            case (7):
                //myObj.nextLine();
                System.out.println("Enter Item Price : ");
                double P1 = myObj.nextDouble();
                Catalog.Catalog.SearchByPrice(P1);
                break;


            default:
                flow = false;
                break;
        }
    }

}

