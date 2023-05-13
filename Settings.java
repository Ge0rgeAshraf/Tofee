package SystemAccounts;

public class  Settings {
    private User obj;

    public Settings(User c){obj=c;}

    public void set_Name(String h){
        obj.Name=h;
    }

    public void set_Password(String h){
        obj.password=h;
    }

    public void set_Email(String h){
        obj.Email=h;
    }

    public void set_Phone(String h){
        obj.phoneNumber=h;
    }


}
