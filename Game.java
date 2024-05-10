import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Game implements Contract{
    //player's inventory
    protected ArrayList<Item> inventory;
    //player's energy level
    protected int energy;
    //player's size
    protected String size;
    //player's location
    protected int placeNorth;
    protected int placeEast;
    protected int placeSouth;
    protected int placeWest;
    private boolean playingGame = true;

    public Game(){
        this.inventory = new ArrayList<Item>();
        this.energy = 10;
        this.size = "medium";
        this.placeNorth = 0;
        this.placeEast = 0;
        this.placeSouth = 0;
        this.placeWest = 0;
    }

    /**
     * a method allowing the player to move north east south or west. 
     * @param direction a string saying either "North", "East", "South", or "West".
     */
    public boolean walk(String direction){
        if(direction.contains("NORTH")){
            this.placeNorth += 1;
            System.out.println("You walked north");
            return true;
        }
        else if(direction.contains("EAST")){
            this.placeEast += 1;
            System.out.println("You walked east");
            return true;
        }
        else if(direction.contains("SOUTH")){
            this.placeSouth += 1;
            System.out.println("You wallked south.");
            return true;
        }
        else if(direction.contains("WEST")){
            this.placeWest += 1;
            System.out.println("You walked west.");
            return true;
        }
        else{
            System.out.println("That wasn't a valid direction. Trying writing \"NORTH\", \"EAST\", \"SOUTH\", or \"WEST\".");
            return false;
        }
    }

    public void grab(String item){
        System.out.println(item + " was grabbed.");
    }

    public String drop(String item){
        return item + " was dropped";
    }

    public void use(String item){
        System.out.println("use item.");
    }

    public void examine(String item){
        System.out.println("examine item.");
    }

    public boolean fly(int x, int y){
        return true;
    }

    public Number shrink(){
        return 1;
    }

    public Number grow(){
        return 3;
    }

    public void rest(){
        this.energy = 11;
    }

    public void undo(){
        System.out.println("Literally how though.");
    }

    private void exhuast(){
        this.energy -= 1;
        System.out.println(energy);
    }

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
        else if(action.contains("SHRINK")){
            this.shrink();
        }
        else if(action.contains("GROW")){
            this.grow();
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
                this.exhuast();
            }
        } while(playingGame);

        sc.close();
    }


    public static void main(String args[]){
        Game game = new Game();
        Item potion = new Item("Potion", "A glittering gold potion.");
        game.play();

    }
}

