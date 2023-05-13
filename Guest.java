package SystemAccounts;
import Catalog.Catalog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;
public class  Guest {
    private boolean logged   ;
    public boolean get_State(){
        return logged;
    }

    public void set_State(boolean y){
        logged= y;
    }

    public Guest(){logged=false;};

    public static boolean isValidEmail(String email) {
        // Email regex pattern
        // String regex = "^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$";

        // Create a pattern object
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

        // Match the input string with the pattern
        Matcher matcher = pattern.matcher(email);
        // Return true if the email matches the pattern, false otherwise
        return matcher.matches();
    }

    public static boolean isValidEgyptianPhoneNumber(String phoneNumber) {
        // Egypt phone number regex pattern
        // String regex ="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" ;

        // Create a pattern object
        Pattern pattern = Pattern.compile("^01[0-2]\\d{8}$");

        // Match the input string with the pattern
        Matcher matcher = pattern.matcher(phoneNumber);

        // Return true if the phone number matches the pattern, false otherwise
        return matcher.matches();
    }


    public User Register(String Name , String mail , String Password , String p ){
        if(isValidEgyptianPhoneNumber(p) && isValidEmail(mail) ){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Register as : ");
            System.out.println("1.Admin: ");
            System.out.println("2.Owner  ");
            System.out.println("3.Customer ");
            System.out.println("Enter Your Choice : ");
            int choice_role = myObj.nextInt();
            if(choice_role == 1){
                SystemAccounts.GeneralAdmin new_one = new SystemAccounts.GeneralAdmin(Name,Password,mail,p);
                return (User) new_one;
            }
            else if(choice_role== 2){
                SystemAccounts.Owner new_one = new SystemAccounts.Owner(Name,Password,mail,p);
                return (User) new_one;
            }
            else if(choice_role==3){
                SystemAccounts.Customer new_one = new SystemAccounts.Customer(Name,Password,mail,p);
                return (User) new_one;
            }
        }
        else{
            System.out.println("Your data is wrong in format..try again");
        }


        return null;
    }



    public User Login(String Email , String password){
        for(int r=0; r<User.Users.size(); r++){
            if(Objects.equals(User.Users.get(r).getByEmail(),Email) && Objects.equals(User.Users.get(r).getByPassword(), password)){
                return User.Users.get(r);
            }
        }
        return null;
    }

}
