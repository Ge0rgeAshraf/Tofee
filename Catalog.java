package Catalog;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;
import Item.Category;
import Item.Item;
public class  Catalog {
    public Catalog(){

    }

    public static void ShowAll (){
        if(Category.Categories.isEmpty()){
            System.out.println("Empty Store");
        }
        else{
            for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
                for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                    System.out.println("--------------------------------------");
                    System.out.println("Item id "+x.getValue().getId());
                    System.out.println("Item Name "+x.getValue().getName());
                    System.out.println("Item Brand "+x.getValue().getBrand());
                    System.out.println("Item Quantity Available "+x.getValue().getAmount());
                    System.out.println("--------------------------------------");
                }
            }
        }
    }

    public static boolean   SearchByName (String S){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                if(Objects.equals((x.getValue()).getName(), S)){
                    System.out.println("--------------------------------------");
                    System.out.println("Item id "+x.getValue().getId());
                    System.out.println("Item Name "+x.getValue().getName());
                    System.out.println("Item Brand "+x.getValue().getBrand());
                    System.out.println("Item Quantity Available "+x.getValue().getAmount());
                    System.out.println("--------------------------------------");
                    return true;
                }

            }

        }
        return false;

    }


    public static boolean  SearchByBrand(String B){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                if(Objects.equals((x.getValue()).getBrand(), B)){
                    System.out.println("--------------------------------------");
                    System.out.println("Item id "+x.getValue().getId());
                    System.out.println("Item Name "+x.getValue().getName());
                    System.out.println("Item Brand "+x.getValue().getBrand());
                    System.out.println("Item Quantity Available "+x.getValue().getAmount());
                    System.out.println("--------------------------------------");
                    return true;
                }
            }

        }
        return false;
    }


    public static boolean SearchByPrice(double p){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            for( HashMap.Entry<Integer,Item> x : y.getValue().entrySet()){
                if((x.getValue()).getPrice() == p){
                    System.out.println("--------------------------------------");
                    System.out.println("Item id "+x.getValue().getId());
                    System.out.println("Item Name "+x.getValue().getName());
                    System.out.println("Item Brand "+x.getValue().getBrand());
                    System.out.println("Item Quantity Available "+x.getValue().getAmount());
                    System.out.println("--------------------------------------");
                    return true;
                }
            }

        }
        return false;
    }

    public static Category SearchByCategory(int g){

        for(Category y : Category.Categories.keySet()){
            if(y.get_id() == g ){
                return y;
            }

        }
        return null;
    }



    public static void viewCategories() {
        if (Category.Categories.isEmpty()) {
            System.out.println("Store is Empty");
        } else {
            for (Category y : Category.Categories.keySet()) {
                System.out.println("Category Id : " + y.get_id());
                System.out.println("Category Name : " + y.get_name());
            }
        }
    }

}