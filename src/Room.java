import java.util.ArrayList;

public class Room {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String roomName;
    private String roomDescription;

    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> itemList = new ArrayList<>();
    private ArrayList<Enemy> enemyList = new ArrayList<>();



    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Room (String roomName, String roomDescription){
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }


    //***SETTER METHODS (to set the value)***
    public void setNorth(Room north){
        this.north = north;
    }
    public void setSouth(Room south){
        this.south = south;
    }
    public void setEast(Room east){
        this.east = east;
    }
    public void setWest(Room west){
        this.west = west;
    }

    //***GETTER METHODS (so we can retrieve the value in other classes)-------------------------------------------------
    public Room getNorth() {
        return north;
    }
    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Enemy> getEnemyList(String enemyName) {
        return enemyList;
    }

    //***METHODS THAT RELATES TO ROOM***--------------------------------------------------------------------------------

    //ADDS AN ITEM TO AN ARRAYLIST
    public void addItemRoom(Item item){
        itemList.add(item);
    }

    public Item searchItemRoom(String itemName) {
        for (Item item : itemList) {
            if(item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    public Item removeItem(String itemName) {
        Item itemToRemove = searchItemRoom(itemName);
        itemList.remove(itemToRemove);
        return itemToRemove;
    }

    public void addEnemyRoom(Enemy enemyName){
        enemyList.add(enemyName);
    }



}
