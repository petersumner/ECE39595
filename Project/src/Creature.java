package src;

public class Creature extends Displayable {

    public Creature(){}

    public void setHp(int h){
        System.out.println("   hp: " + h);
    }

    public void setHpMoves(int hpm){
        System.out.println("   hpMoves: " + hpm);
    }

    public void setDeathAction(CreatureAction da){
        System.out.println("   deathAction: " + da);
    }

    public void setHitAction(ItemAction ha){
        System.out.println("   itemAction:" + ha);
    }
    
}
