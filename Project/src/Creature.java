package src;

public class Creature extends Displayable {

    public int hp;
    public int hpm;
    public CreatureAction da;
    public ItemAction ha;

    public Creature(){}

    public void setHp(int _hp){
        hp = _hp;
        System.out.println("   hp: " + hp);
    }

    public void setHpMoves(int _hpm){
        hpm = _hpm;
        System.out.println("   hpMoves: " + hpm);
    }

    public void setDeathAction(CreatureAction _da){
        da = _da;
        System.out.println("   deathAction: " + da);
    }

    public void setHitAction(ItemAction _ha){
        ha = _ha;
        System.out.println("   itemAction:" + ha);
    }
}
