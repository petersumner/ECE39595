package src;

public class DropPack extends CreatureAction {

    public String name;
    
    public DropPack(String _name, Creature owner){
        super(owner);
        name = _name;
    }
}
