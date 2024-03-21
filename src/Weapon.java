public abstract class Weapon extends Item {

    //***ATTRIBUTES***
    private int damage;
    private boolean isRangedWeapon;

    //***CONSTRUCTOR***
    public Weapon(String itemName, String itemDescription, int damage, boolean b){
        super(itemName, itemDescription);
        this.damage = damage;
        this.isRangedWeapon = isRangedWeapon;
    }

    //***GETTER METHODS***
    public int getDamage() {
        return damage;
    }

    public boolean getIsRangedWeapon() {
        return isRangedWeapon;
    }

    //***ABSTRACT METHODS***--------------------------------------------------------------------------------------------
    public abstract int remainingUses();

    public abstract void useWeapon();
}
