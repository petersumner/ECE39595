package src;

public class Player extends Creature {

    public Sword sword;
    public Armor armor;
    public String name = "Player";
    
    public void setWeapon(Sword _sword){
        sword = _sword;
        System.out.println("setWeapon: " + sword.name);
    }

    public void setArmor(Armor _armor){
        armor = _armor;
        System.out.println("setArmor: " + armor.name);
    }
}
