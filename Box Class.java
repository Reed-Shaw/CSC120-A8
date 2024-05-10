/**
 * A class Box that is only needed for the box that will be on the cliffs and hold the wings that let the player
 * escape the game.
 * @author Reed Shaw
 * @version 5/10/2024
 */
public class Box {
    String name;
    String description;
    boolean open;
    int x;
    int y;

    public Box(){
        this.name = "box";
        this.description = "A large locked wooden box. It seems you can't open it without a key.";
        this.open = false;
        this.x = 1;
        this.y = 0;
    }

    /**
     * a getter that will retrieve the x position of the box
     * @return an int containing the x position of the box
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * a getter that will retrieve the y position of the box
     * @return an int containing the y position of the box
     */
    public int getY(){
        return this.y;
    }

    /**
     * a method that will be able to tell if the box is locked or not.
     */
    public boolean getLocked(){
        if(this.open == false){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * a method that will unlock the box.
     */
    protected void unlock(){
        this.open = true;
    }

}
