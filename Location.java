import java.util.*;

public class Location {
    String name;
    ArrayList<Item> inventory;
    String description;
    int x;
    int y;

    public Location(String name, String description, int x, int y){
        this.name = name;
        this.inventory = new ArrayList<Item>();
        this.description = description;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return description;
    }

    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public void removeItem(Item item){
        inventory.remove(item);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
