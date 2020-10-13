package src;

public class Player extends Creature {

    public Sword sword;
    public Armor armor;
    public String name = "Player";
    public int room = 0;
    public int serial = 0;
    public int posX = 0;
    public int posY = 0;
    public int hp = 0;
    public int maxHit = 0;
    public int hpMoves = 0;

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
