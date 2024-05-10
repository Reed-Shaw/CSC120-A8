public class Item {
    String name;
    String description;
    boolean limitedUse;
    int numUses;

    public Item(String name, String description, boolean limitedUse, int numUses){
        this.name = name;
        this.description = description;
        this.limitedUse = limitedUse;
        this.numUses = numUses;
    }

    protected String use(){
        return this.name + " has been used.";
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return description;
    }

}
