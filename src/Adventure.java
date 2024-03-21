import java.util.ArrayList;

//ADVENTURE CLASS - CONTROLLER OF THE CLASSES (INFORMATION EXPERT)
public class Adventure {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private Player player;
    private Map map;


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Adventure(){
        map = new Map();
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

     //public String getAddItemPlayer(String itemName) {
     //   return player.addItemPlayer(itemName);
     //}

     public String getPlayerEat(String itemName) {
        return player.eatFood(itemName);
     }

     public String getEquipWeapon(String itemName) {
        return player.equipWeapon(itemName);
     }

     public Item getDropItemPlayer(String itemName) {
        return player.dropItem(itemName);
     }


   //***METHODS*** (that makes the player move to a given direction)----------------------------------------------------
    public void goNorth(){
        player.goNorth();
    }

    public void goSouth(){
        player.goSouth();
    }

    public void goEast(){
        player.goEast();
    }

    public void goWest(){
        player.goWest();
    }

    public void move(String input){
        switch(input.toLowerCase()){
            case "go north":
            case "north":
            case "n":
                 goNorth();
                 break;
            case "go south":
            case "south":
            case "s":
                 goSouth();
                 break;
            case "go east":
            case "east":
            case "e":
                 goEast();
                 break;
            case "go west":
            case "west":
            case "w":
                 goWest();
                 break;
        }
    }




}
