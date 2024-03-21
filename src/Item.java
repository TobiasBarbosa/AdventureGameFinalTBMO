public class Item {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private String itemName;
    private String itemDescription;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    //***GETTER METHODS***----------------------------------------------------------------------------------------------
    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return itemDescription;
    }

    //------------------------------------------------------------------------------------------------------------------
}
