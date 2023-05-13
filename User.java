package SystemAccounts;
import Catalog.Catalog;
import java.util.Vector;


public   class User extends Guest {
    protected String Name , password , Email , phoneNumber    ;
    protected int UserId  ;
    public static enum Status {
        Active,
        Suspended
    }
    protected Status status ;
    //private int Loyality_Points;
    public static Vector<User>  Users= new Vector<User>();
    public Settings settings;
    public int role;
    private static int CounterId=0;

    public User(){
        set_State(true);
        this.role=role;

        settings = new Settings(this);
    };
    public User(String s , String n  , String x , String y){
        Name=s; password=n; Email=x; phoneNumber=y;
        //this.cart = new Cart.Cart();
        //User.Users.add(this);
    }

    public String getByName(){
        return Name;
    }

    public int getById(){
        return UserId;
    }

    public String getByEmail(){
        return Email;
    }

    public String getByPassword(){
        return password;
    }

    public String getByPhone(){
        return phoneNumber;
    }






}
