package src;

public class UpdateDisplay extends CreatureAction {

    public String name;
    
    public UpdateDisplay(String _name, Creature owner){
        super(owner);
        name = _name;
    }
}
