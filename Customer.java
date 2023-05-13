package SystemAccounts;
import Cart.Cart;
import Order.Order;
import java.util.HashMap;
import java.util.Vector;

import Item.Category;
import Item.Item;
public class Customer extends User {
    public Cart cart ;
    public Vector<Order> orders=new Vector<Order>();
    public Customer(String s , String n  , String x , String y){
        super(s,n,x,y);
        this.cart = new Cart();
        User.Users.add(this);
    }



    public void AddtoCart(int i,int q){
        for(HashMap.Entry<Category,HashMap<Integer, Item>> y : Category.Categories.entrySet()) {
            for (HashMap.Entry<Integer, Item> x : y.getValue().entrySet()) {
                if(x.getKey() == i){
                    cart.AddtoCart(x.getValue(),q);
                    return ;
                }

            }
        }


        System.out.println("Not Found !");

    }

    public void RemovefromCart(int i){
        this.cart.removeItem(i);
    }

    public void make_order(){
        double price=0;
        if(!cart.items.isEmpty()) {
            for (HashMap.Entry<Item, Integer> y : Cart.items.entrySet()) {
                price += (y.getKey().getPrice()) * (y.getValue());
                orders.add(new Order(price));
            }
        }
        else{
            System.out.println("your cart is empty !!");
        }
    }

    public void OrderHistory(){
        for(Order x : orders){
            System.out.println("Order Id is : "+x.getId());
            System.out.println("Order Price is : "+x.getPrice());
        }
    }




}