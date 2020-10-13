package src;

public class Teleport extends CreatureAction {

    public String name;
    
    public Teleport(String _name, Creature owner){
        super(owner);
        name = _name;
    }
}
