package Item;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.Scanner;
import Item.Category;
import Catalog.Catalog;
enum UniteType
{
    kilo,
    pieces;
}
enum Status
{   InStock,
    OutOfStock,
    unavailable
}
public class Item
{
    private String name;
    private static int  idCounter;
    private int id;
    private int amount;
    private String brand;
    private String description;
    private double price;
    private UniteType uniteType;
    private float discount;
    private Status status;
    private int[] CategoryId;

    public Item(String name,  int amount, String brand, String description, double price, float discount)
    {
        this.name = name;
        this.amount = amount;
        this.brand = brand;
        this.description = description;
        this.price = price;
        // this.uniteType = uniteType;
        this.discount = discount;
        // this.status = status;
        this.idCounter+=1;
        this.id=this.idCounter;
        Catalog.viewCategories();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Category Number to assign : ");

        int i = myObj.nextInt();  // Read user input
        assign_to_category(i);


    }


    public void assign_to_category (int i){
        for(HashMap.Entry<Category,HashMap<Integer,Item>> y : Category.Categories.entrySet()){
            if(y.getKey().get_id() == i){
                y.getValue().put(this.id,this);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int  getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public UniteType getUniteType() {
        return uniteType;
    }

    public float getDiscount() {
        return discount;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUniteType(UniteType uniteType) {
        this.uniteType = uniteType;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", amount=" + amount +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", uniteType=" + uniteType +
                ", discount=" + discount +
                ", status=" + status +
                '}';
    }
}
