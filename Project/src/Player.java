package src;

public class Player extends Creature {

    public Sword sword;
    public Armor armor;
    public String name = "Player";
    public int serial;
    public int hp;
    public int hpMoves;

    public Player(){
        System.out.println("Player:");
    }
    
    public void setWeapon(Sword _sword){
        sword = _sword;
        System.out.println("   weapon: " + sword.name);
    }

    public void setArmor(Armor _armor){
        armor = _armor;
        System.out.println("   armor: " + armor.name);
    }
}
