public class Enemy {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
private String enemyName;
private String enemyDescription;
private int healthPoints;
private boolean isEnemyDead;
private Weapon weapon;
private Room room;
private int roomNumber;


    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
public Enemy(String enemyName, String enemyDescription, int healthPoints, Weapon weapon){
    this.enemyName = enemyName;
    this.enemyDescription = enemyDescription;
    this.healthPoints = healthPoints;
    this.weapon = weapon;
    isEnemyDead = false;

}


    //***GETTER METHODS***----------------------------------------------------------------------------------------------

    public String getEnemyName() {
        return enemyName;
    }

    public int getHealthPointsEnemy(){
    return healthPoints;
}

public Weapon getWeapon(){
      return weapon;
}

    //***METHODS***-----------------------------------------------------------------------------------------------------
public boolean isEnemyDead(){
    return getHealthPointsEnemy() <= 0;
}

@Override
    public String toString(){
    return enemyName;
}


}
