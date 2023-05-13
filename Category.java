package Item;
import java.util.HashMap;
public class  Category {
    public  static HashMap<Category , HashMap<Integer,Item>> Categories= new HashMap<Category,HashMap<Integer,Item>>();
    private int id;
    private String Name;
    private static int  CounterId=0;

    public Category(String Name){
        this.Name = Name;
        this.id=CounterId;
        Categories.put(this,new HashMap<Integer,Item>());
        CounterId++;

    }

    public int get_id(){
        return id;
    }

    public String get_name(){
        return Name;
    }

    public String get_category(){
        return Name;
    }

}

