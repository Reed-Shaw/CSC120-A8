public class Item {
    String name;
    String description;
    boolean limitedUse;
    int numUses;

    /**
     * A class Item that holds all the information needed for any item.
     * @param name a String name holding the name of the Item
     * @param description a String description holding the description of the item
     * @param limitedUse A boolean that is marked true if the item can only be ussed a limited number of times
     * @param numUses An int that holds the number of uses an item can have
     * @author Reed Shaw
     * @version 5/10/2024
     */
    public Item(String name, String description, boolean limitedUse, int numUses){
        this.name = name;
        this.description = description;
        this.limitedUse = limitedUse;
        this.numUses = numUses;
    }

    /**
     * a method that allows an item to be used.
     * @return a String reporting that the item has been used.
     */
    protected String use(){
        return this.name + " has been used.";
    }


    /**
     * a getter that will return the name of the item
     * @return a String contianing the name of the item
     */
    public String getName(){
        return name;
    }

    /**
     * a getter that will return the descripiton of the item.
     * @return a String containing the description of the item.
     */ 
    public String getDesc(){
        return description;
    }

}
