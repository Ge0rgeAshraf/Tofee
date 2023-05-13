
import Item.Category;
import Item.Item;
import SystemAccounts.Customer;
import SystemAccounts.Guest;
import SystemAccounts.Owner;
import SystemAccounts.User;

import SystemAccounts.GeneralAdmin;
import SystemAccounts.User;
import Catalog.Catalog;
//import Engine.Engine;
import java.util.Scanner;
import javax.mail.*;
public class Main {

    public static void main(String[] args) {
        Engine Gn = new Engine();

        System.out.println("Welcome to Toffee App ");
        Category G1 = new Category("Sweets");
        Category G2 = new Category("sours");
        Item t1 = new Item("candies",56,"toffee","pretty awesome sweets for you",127,3);

        while (Gn.flow) {
            Gn.load_users();

            if (Gn.user1 instanceof GeneralAdmin) {
                Gn.Admin_menu();
                Gn.Admin_flow();
            } else if (Gn.user1 == null) {
                Gn.Guest_menu();
                Gn.Guest_flow();
            }
            else if(Gn.user1 instanceof Customer){
                Gn.Customer_menu();
                Gn.Customer_flow();
            }
            System.out.println("Enter Any Other Number to exit...");
            System.out.println("Enter Your Choice : ");
        }

    }
}