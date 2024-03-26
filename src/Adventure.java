//ADVENTURE CLASS - CONTROLLER OF THE CLASSES (INFORMATION EXPERT)
public class Adventure {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Player player;
    private Map map;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Adventure(){
        map.mapCreator();
        player = new Player(map.getStarterRoom());
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------

     public Player getPlayer() {
         return player;
     }

     public void getPlayerCurrentRoomPrint(){
        player.currentRoomPrint();
     }

     public Room getCurrentRoom() {
        return player.getCurrentRoom();
     }

     //Not sure why this doesn't work...
//     public String getAddItemPlayer(String itemName) {
//        return player.addItemPlayer(itemName);
//     }

//     public String getPlayerEat(String itemName) {
//        return player.eatFood(itemName);
//     }

     public String getEquipWeapon(String itemName) {
        return player.equipWeapon(itemName);
     }

     public Item getDropItemPlayer(String itemName) {
        return player.dropItem(itemName);
     }

     public boolean getIsPlayerDead() {
        return player.isPlayerDead();
     }



   //***METHODS*** (that makes the player move to a given direction)----------------------------------------------------
    public void goNorth(){
        player.MovePlayerNorth();
    }

    public void goSouth(){
        player.MovePlayerSouth();
    }

    public void goEast(){
        player.MovePlayerEast();
    }

    public void goWest(){
        player.MovePlayerWest();
    }

    //------------------------------------------------------------------------------------------------------------------
}
