package src;

public class Remove extends CreatureAction {

    public String name;
    
    public Remove(String _name, Creature owner){
        super(owner);
        name = _name;
    }
}
