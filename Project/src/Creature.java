package src;

import java.util.ArrayList;
import java.util.List;

public class Creature extends Displayable {

    public int hp;
    public int hpm;
    public CreatureAction da;
    public List<CreatureAction> creatureActions = new ArrayList<CreatureAction>();
    public ItemAction ha;
    public int room;


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

    public void setRoom(int _room){
        room = _room;
    }

    public void addCreatureAction(CreatureAction _ca){
        creatureActions.add(_ca);
    }
}
