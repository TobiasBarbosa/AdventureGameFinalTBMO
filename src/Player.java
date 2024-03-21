import java.util.ArrayList;

public class Player {

    ///***ATTRIBUTES***-------------------------------------------------------------------------------------------------

    private Room currentRoom;
    private ArrayList<Item> inventoryList;
    private int healthPointsPlayer;
    private Weapon currentWeapon;
    private boolean isPlayerDead;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Player(Room firstRoom){
        this.currentRoom = firstRoom;
        this.inventoryList = new ArrayList<>();
        this.healthPointsPlayer = 100;
        this.isPlayerDead = false;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public ArrayList<Item> getInventoryList(){
        return inventoryList;
    }

    public int getHealthPointsPlayer(){
        return healthPointsPlayer;
    }

    public Weapon getCurrentWeapon(){
        return currentWeapon;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setHealthPointsPlayer(int healthPointsPlayer){
        this.healthPointsPlayer = healthPointsPlayer;
    }

    //***METHODS***(so player can move around in different rooms)-------------------------------------------------------
    public void MovePlayerNorth(){
        if(currentRoom.getNorth() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getNorth(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
            System.out.println("going north");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerSouth(){
        if(currentRoom.getSouth() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getSouth(); //Uses getter method to set the new currentRoom to the Room which is South from CurrentRoom.
            System.out.println("going south");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerEast(){
        if(currentRoom.getEast() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getEast(); //Uses getter method to set the new currentRoom to the Room which is East from CurrentRoom.
            System.out.println("going east");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void MovePlayerWest(){
        if(currentRoom.getWest() != null) {       //This still does not logically make sense to me....
            currentRoom = currentRoom.getWest(); //Uses getter method to set the new currentRoom to the Room which is West from CurrentRoom.
            System.out.println("going west");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    //***METHODS--------------------------------------------------------------------------------------------------------
    public void currentRoomPrint(){
        System.out.println(currentRoom.getRoomName() + " " + currentRoom.getRoomDescription());
    }

    public void directionNotPossible(){
        System.out.println("You cannot go this direction");
    }

    public Item findItemInInventory(String itemName){
        for (Item item : inventoryList) { //For loop checks if the itemName is within the arraylist of inventory
            if (item.getItemName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }

    public void addItemPlayer(Item item){
        inventoryList.add(item);
    }

    public void removeItem(Item item) {
        inventoryList.remove(item);
    }

    public Item dropItem(String itemName) {
        Item pickedItem = findItemInInventory(itemName);
        if (pickedItem != null) {
            removeItem(pickedItem);
            getCurrentRoom().addItemRoom(pickedItem);
        }
        return pickedItem;
    }

    public Item takeItem(String itemName) {
        Item pickedItem = getCurrentRoom().removeItem(itemName);
        addItemPlayer(pickedItem);
        return pickedItem;
    }

    public String eatFood(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item == null) {
            return "You don't have that item";
        } else if (item instanceof Food food) {
            if (healthPointsPlayer + food.getHealthPoints() >= 100) {
                setHealthPointsPlayer(100);
                removeItem(food);
                return "You ate the " + itemName;
            } else {
                removeItem(food);
                healthPointsPlayer += food.getHealthPoints();
                return "You ate the " + itemName;
            }
        } else {
            return "Doesn't exist";
        }
    }

    //Not sure exactly how this works logically/practically...->
    public String equipWeapon(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item == null) {
            return "you don't have that item";
        } else if (item instanceof Weapon) {
            //Change Weapon to Item
            if (((Weapon) item).getIsRangedWeapon()) {
                currentWeapon = (Weapon) item;
                inventoryList.remove(item);
                return "you have equipped " + item.getItemName();
                } else {
                currentWeapon = (Weapon) item;
                inventoryList.remove(item);
                return "you have equipped " + item.getItemName();
            }
            } else {
                return "you can't equip " + item.getItemName();
            }
    }

    public boolean isPlayerDead(){
        return getHealthPointsPlayer() <= 0;
    }

    //------------------------------------------------------------------------------------------------------------------
}
