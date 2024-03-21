public class Food extends Item {

    //***ATTRIBUTES***
    private int healthPoints;

    public Food(String itemName, String itemDescription, int healthPoints){
        super(itemName, itemDescription);
        this.healthPoints = healthPoints;
    }
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}
