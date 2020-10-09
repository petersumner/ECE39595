package src;

public class Creature extends Displayable {

    public Creature(){}

    public void setHp(int h){
        System.out.println("HP = " + h);
    }

    public void setHpMoves(int hpm){
        System.out.println("HP Moves = " + hpm);
    }

    public void setDeathAction(CreatureAction da){
        System.out.println("Death Action = " + da);
    }

    public void setHitAction(ItemAction ha){
        System.out.println("Item Action = " + ha);
    }
    
}
