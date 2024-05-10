import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/**
 * A class Game that holds all the player's information and the loop to run the game.
 * @author Reed Shaw
 * @version 5/10/2024
 */
public class Game implements Contract{
    //player's inventory
    protected ArrayList<Item> inventory;
    //player's energy level
    protected int energy;
    //player's size
    protected String size;
    //player's location
    protected int placeX;
    protected int placeY;
    protected Location currentLocation;
    //Boolean describing is the game is still going. 
    private boolean playingGame = true;
    //making an ArrayList of all the places
    Location forest = new Location("Forest", "A large forest. Next to you is a rusty key.", 0, 0); 
    Location desert = new Location("Desert", "An expansive desert. Next to you is a blue potion.", 0, 1);
    Location beach = new Location("Beach", "A pretty beach. Next to you is a gold potion.", 1, 1);
    Location cliffs = new Location("Cliffs", "Rocky cliffs streaching as far as the eye can see. Next to you is box.", 1, 0);
    protected ArrayList<Location> places;
    Item potionGrow = new Item("Potion", "A glittering gold potion. A note attatched to it says \"BIG CHANGES\".", true, 1);
    Item potionShrink = new Item("Potion", "A foggy blue potion. A note attatched to it says \"little changes\".", true, 1);
    Item wings = new Item("Wings", "Like what Icarus had, but with altitude control.", false, 0);
    Item rustyKey = new Item("Rusty Key", "A rusty key. Maybe it goes with a box?", false, 0);
    
    public Game(){
        this.inventory = new ArrayList<Item>();
        this.energy = 10;
        this.size = "medium";
        this.placeX = 0;
        this.placeY = 0;
        this.places = new ArrayList<Location>();
        this.places.add(forest);
        this.places.add(desert);
        this.places.add(beach);
        this.places.add(cliffs);
        for(Location place : places){
            if("forest".contains(place.getName())){
                forest.addItem(rustyKey);
                forest.getInventory();
            }
            if("desert".contains(place.getName())){
                desert.addItem(potionShrink);
            }
            if("cliffs".contains(place.getName())){
                cliffs.addItem(wings);
            }
            if("beach".contains(place.getName())){
                beach.addItem(potionGrow);
            }
        }

        
    }

    /**
     * a method allowing the player to move north east south or west. When they successfully move, they get a
     * description of where they are and their currentLocation changes. 
     * @param direction a string saying either "North", "East", "South", or "West".
     */
    public boolean walk(String direction){
        if(direction.contains("NORTH")){
            if(this.placeY >= 1){
                System.out.println("You can't go North from here.");
                return false;
            }
            else{
            this.placeY += 1;
            System.out.println("You walked north");
            }
            if(this.placeX == beach.getX() && this.placeY == beach.getY()){
                currentLocation = beach;
                System.out.println("You are at a " + beach.getName() + ". " + beach.getDesc());
            }
            else if(this.placeX == desert.getX() && this.placeY == desert.getY()){
                currentLocation = desert;
                System.out.println("You are at a " + desert.getName() + ". " + desert.getDesc());
            }
            return true;
            
        }
        else if(direction.contains("EAST")){
            if(this.placeX >= 1){
                System.out.println("You can't go east from here.");
                return false;
            }
            else{
            this.placeX += 1;
            System.out.println("You walked east");
            }
            if(this.placeX == beach.getX() && this.placeY == beach.getY()){
                currentLocation = beach;
                System.out.println("You are at a " + beach.getName() + ". " + beach.getDesc());
            }
            else if(this.placeX == cliffs.getX() && this.placeY == cliffs.getY()){
                currentLocation = cliffs;
                System.out.println("You are at the " + cliffs.getName() + ". " + cliffs.getDesc());
            }
            else{
                System.out.println("Nothing matches.");
            }
            return true;

        }
        else if(direction.contains("SOUTH")){
            if(this.placeY <= 0){
                System.out.println("You can't go south from here.");
                return false;
            }
            else{
            this.placeY -= 1;
            System.out.println("You wallked south.");
            }
            if(this.placeX == forest.getX() && this.placeY == forest.getY()){
                currentLocation = forest;
                System.out.println("You are at a " + forest.getName() + ". " + forest.getDesc());
            }
            else if(this.placeX == cliffs.getX() && this.placeY == cliffs.getY()){
                currentLocation = cliffs;
                System.out.println("You are at the " + cliffs.getName() + ". " + cliffs.getDesc());
            }
            else{
                System.out.println("Nothing matches.");
            }
            return true;
        }
        else if(direction.contains("WEST")){
            if(this.placeX <= 0){
                System.out.println("You can't go west from here.");
                return false;
            }
            else{
            this.placeX -= 1;
            System.out.println("You walked west.");
            }
            if(this.placeX == forest.getX() && this.placeY == forest.getY()){
                currentLocation = forest;
                System.out.println("You are at a " + forest.getName() + ". " + forest.getDesc());
            }
            else if(this.placeX == desert.getX() && this.placeY == desert.getY()){
                currentLocation = desert;
                System.out.println("You are at the " + desert.getName() + ". " + desert.getDesc());
            }
            else{
                System.out.println("Nothing matches.");
            }
            return true; 
        }
        else{
            System.out.println("That wasn't a valid direction. Trying writing \"NORTH\", \"EAST\", \"SOUTH\", or \"WEST\".");
            return false;
        }
    }

    /**
     * A grab method that should allow the player to pick up an object that's in the player's current location
     * and add it to their inventory. 
     */
    public void grab(String item){
        for(Item object : currentLocation.getInventory()){
            if(item.contains("gold potion") && object == potionGrow){
                this.inventory.add(object);
                this.printInventory();
            }
            else{
                System.out.println("Couldn't complete action.");
            }
        }
    }

    /**
     * A method that shows the player what is in their inventory.
     */
    private void printInventory() {
        System.out.println("You have the following items in your inventory:");
        for (Item item : this.inventory) {
            System.out.println(item.description);
        }
    }


    /**
     * A method that should allow the player to drop an item from their inventory. 
     * @param item String contianing the item that the user wants to drop.
     * @return a String communicating either that the item was dropped or that it couldn't be dropped.
     */
    public String drop(String item){
        for(Item object : this.inventory){
            if(object.getName().contains(item)){
                this.inventory.remove(object);
                return item + " was dropped";
            }
        }
        return item + " could not be dropped.";  
    }

    /**
     * A method that should allow the player to use an item for it's intended purpose.
     * @param item a String containing the name of the item they want to use.
     */
    public void use(String item){
        for(Item object : this.inventory){
            if(item.contains(object.getName())){
                if(item.contains("Grow")){
                    this.grow();
                }
                else if(item.contains("Shrink")){
                    this.shrink();
                }
                else if(item.contains("Key") && this.placeX == 1 && this.placeY == 0){
                    System.out.println("Opening the box reveals a pair of wings.");

                }
                else{
                    System.out.println("Make sure you GRAB the item before you use it.");
                }
            }
        }
    }


    /**
     * A method that should allow the user to examine an item in their inventory
     * @param item a String containing the name of the item they want to use.
     */
    public void examine(String item){
        for(Item object : this.inventory){
            if(item.contains(object.getName())){
                System.out.println(object.getDesc());
            }
            else{
                System.out.println("That item is not in your inventory. Make sure you've grabbed it before examining.");
            }
        }
    }

    /**
     * a method that should allow the user to fly. 
     * @param x an int x containing where the user wants to go on the x-axis
     * @param y an int y containing where the user wants to go on the y-axis
     */
    public boolean fly(int x, int y){

        return true;
    }

    /**
     * a method that should allow the user to shrink. Either back to normal size or to a small size depending 
     * on if they have grown beforehand
     * @return a Number indicating the player's size.
     */
    public Number shrink(){
        if(this.size == "big"){
            this.size = "medium";
            System.out.println("You are medium sized.");
            return 2;
        }
        else{
            this.size = "small";
            System.out.println("You are small sized.");
            return 1;
        }
    }

     /**
     * a method that should allow the user to grow. Either back to normal size or to a large size depending 
     * on if they have shrunk beforehand
     * @return a Number indicating the player's size.
     */
    public Number grow(){
        if(this.size == "small"){
            this.size = "medium";
            System.out.println("You are medium sized.");
            return 2;
        }
        else{
            this.size = "big";
            System.out.println("You are large sized.");
            return 3;
        }
    }

    /**
     * a method that allows the user to rest and regain their energy. 
     */
    public void rest(){
        this.energy = 11;
    }

    /**
     * a method that should allow the user to undo their last action.
     */
    public void undo(){
        System.out.println("Literally how though.");
    }

    /**
     * a method that tires out the player
     */
    private void exhuast(){
        this.energy -= 1;
        System.out.println(energy);
    }

    /**
     * a method that takes in what is scanned by the scanner and directs the desired action of the player to the 
     * proper method
     * @param action a String containing what the player wants to do.
     */
    protected void executeAction(String action){
        if(action.contains("WALK")){
            this.walk(action);
        }
        else if(action.contains("GRAB")){
            this.grab(action);
        }
        else if(action.contains("DROP")){
            this.drop(action);
        }
        else if(action.contains("EXAMINE")){
            this.examine(action);
        }
        else if(action.contains("USE")){
            this.use(action);
        }
        else if (action.contains("REST")){
            this.rest();
        }
        else if(action.contains("UNDO")){
            this.undo();
        }
        else{
            System.out.println("That's not an action I can do. Try WALK, GRAB, DROP, EXAMINE, USE, SHRINK, GROW, REST, UNDO, or FLY");
        }
    }

    /**
     * a method that runs a loop allowing the game to run.
     */
    public void play(){
        Scanner sc = new Scanner(System.in);
        do{
            if(this.energy == 0){
                System.out.println("You are too tired to do anything. You should REST.");
            }
            else if(this.energy > 0 && this.energy < 4){
                System.out.println("You are getting tired. You should try to REST.");
                executeAction(sc.nextLine());
                this.exhuast();
            }
            else{
                executeAction(sc.nextLine());
                printInventory();
                System.out.println("Remaining energy:");
                this.exhuast();
            }
        } while(playingGame);

        sc.close();
    }


    public static void main(String args[]){
        Game game = new Game();
        game.play();

    }
}

