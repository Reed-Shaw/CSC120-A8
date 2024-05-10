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

    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public boolean getLocked(){
        if(this.open == false){
            return true;
        }
        else{
            return false;
        }
    }

    protected void unlock(){
        this.open = true;
    }

}
