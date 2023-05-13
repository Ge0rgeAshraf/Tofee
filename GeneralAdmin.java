package SystemAccounts;
import Item.*;
import Item.Category;
import Catalog.Catalog;
import java.util.HashMap;
public class GeneralAdmin extends User {
    public GeneralAdmin(String s , String n  , String x , String y ){
        super(s,n,x,y);
        if(! (this instanceof Owner)) {
            User.Users.add(this);
        }
    }

    public void addCategories(String Category_Name){
        Category new_one = new Category(Category_Name);
    }

    public void addItem(String Name ,  int amount, String brand, String description, double price, float discount ){
        Item new_one = new Item(Name,amount,brand,description,price,discount);
    }

    public void addCategory(String Name){
        Category c1 = new Category(Name);
    }

    public void deleteItem(int id){
        for( int r =0; r <GeneralAdmin.Users.size(); r++){
            if(GeneralAdmin.Users.get(r).getById() == id){
                GeneralAdmin.Users.remove(r);
            }
        }
    }





    public void suspendCustomer(int id){
        for( int r =0; r <User.Users.size(); r++){
            if(GeneralAdmin.Users.get(r).getById() == id){
                GeneralAdmin.Users.get(r).status = GeneralAdmin.Status.Suspended;
            }
        }
    }

    public void setDiscountOnCategory(int id , int r){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            if(y.getKey().get_id() == id ){
                for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                    x.getValue().setDiscount(r);
                }
            }
        }
    }

    public void setDiscountOnItem(int i , int r){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                if((x.getValue()).getPrice() == i){
                    x.getValue().setDiscount(r);
                }
            }
        }
    }

    public void setDiscount(int r){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                x.getValue().setDiscount(r);

            }
        }
    }



}
