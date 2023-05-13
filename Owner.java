package SystemAccounts;
import Catalog.Catalog;
import SystemAccounts.GeneralAdmin;

public class Owner extends GeneralAdmin {
    public Owner(String s , String n  , String x , String y ){
        super(s,n,x,y);
        User.Users.add(this);
    }

    public void addAdmin(String s , String n , String x , String y){
        GeneralAdmin new_one = new GeneralAdmin(s,n,x,y);
    }

    public void removeAdmin(int id){
        for( int r =0; r <GeneralAdmin.Users.size(); r++){
            if(User.Users.get(r).getById() == id){
                User.Users.remove(r);
            }
        }
    }


}
