import java.util.*;

/**
 * a Class location holding all the info needed for the places in the game
 * @author Reed Shaw
 * @version 5/10/2024
 */
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

    /**
     * a getter that will return the name of the location
     * @return a String containing the name of the locaiton
     */
    public String getName(){
        return name;
    }

    /**
     * a getter that will return the description of the location
     * @return a String containing the description of the location
     */
    public String getDesc(){
        return description;
    }

    /**
     * a getter that will return the contents of the location's inventory. 
     * @return An array list containing the contents of the location's inventory.
     */
    public ArrayList<Item> getInventory(){
        return this.inventory;
    }

    /**
     * a method that allows an item to be added to the location's inventory
     * @param item an Item that will be added to the location's inventory.
     */
    public void addItem(Item item){
        inventory.add(item);
    }

    /**
     * a method that will remove an item from the location's inventory.
     * @param item an Item that will be removed fromt he location's inventory.
     */
    public void removeItem(Item item){
        inventory.remove(item);
    }

    /**
     * a getter that will retrieve the x position of the location
     * @return an int containing the x position of the location
     */
    public int getX(){
        return x;
    }

    /**
     * a getter that will retrieve the y position of the location
     * @return an int containing the y position of the location
     */
    public int getY(){
        return y;
    }

}
