package Cart;
import Item.*;
import java.util.HashMap;
import Item.Item;
public class Cart  {
    public static HashMap<Item , Integer> items=new HashMap<Item,Integer>();
    public Cart(){ }

    public void AddtoCart(Item t1 , int q){
        t1.setAmount(t1.getAmount()-q);
        items.put(t1,q);

    }

    public void displayCart(){
        for(HashMap.Entry<Item,Integer> y : items.entrySet()){
            System.out.println("Item id is : "+ y.getKey().getId());
            System.out.println("Item Name is : "+ y.getKey().getName());
            System.out.println("Item Quantity is : "+ y.getValue());
        }
    }

    public void removeItem(int i){
        for(HashMap.Entry<Item,Integer> X : items.entrySet()){
            if(X.getKey().getId() == i){
                items.remove(X.getKey());
            }
        }
    }
}