import java.util.ArrayList;

public class Player {

    ///***ATTRIBUTES***-------------------------------------------------------------------------------------------------

    private Room currentRoom;
    private ArrayList<Item> inventoryList;
    private int healthPoints;
    private Weapon currentWeapon;
    private boolean isPlayerDead;

    //***CONSTRUCTOR***
    public Player(Room firstRoom){
        this.currentRoom = firstRoom;
        this.inventoryList = new ArrayList<>();
        this.healthPoints = 100;
        isPlayerDead = false;
    }


    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    public int getHealthPointsPlayer() {
        return healthPoints;
    }

    public Weapon getCurrentWeapon(){
        return currentWeapon;
    }

    //***SETTER METHODS***----------------------------------------------------------------------------------------------
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    //***METHODS (so player can move around in different rooms)---------------------------------------------------------
    public void goNorth(){
        if(currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
            System.out.println("going north");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void goSouth(){
        if(currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
            System.out.println("going south");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void goEast(){
        if(currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
            System.out.println("going east");
            currentRoomPrint();
        } else {
            directionNotPossible();
        }
    }

    public void goWest(){
        if(currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest(); //Uses getter method to set the new currentRoom to the Room which is North from CurrentRoom.
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
        for (Item item : inventoryList) {
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
            if (healthPoints + food.getHealthPoints() >= 100) {
                setHealthPoints(100);
                removeItem(food);
                return "You ate the " + itemName;
            } else {
                removeItem(food);
                healthPoints += food.getHealthPoints();
                return "You ate the " + itemName;
            }
        } else {
            return "Doesn't exist";
        }
    }

    //Er i tvivl om hvad der sker her....
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

    //------------------------------------------------------------------------------------------------------------------

}
