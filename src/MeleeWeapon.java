public class MeleeWeapon extends Weapon{

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public MeleeWeapon(String itemName, String itemDescription, int damage){
        super(itemName, itemDescription, damage, false);
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    // Returner 1, da den altid vil have 1 angreb tilbage (løber aldrig ud)
    @Override
    public int remainingUses(){
        return 1;

    }

    //er tom da den ikke skal fjerne ammo...
    @Override
    public void useWeapon(){
    }

}
