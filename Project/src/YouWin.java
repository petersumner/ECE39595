package src;

public class YouWin extends CreatureAction {

    public String name;
    
    public YouWin(String _name, Creature owner){
        super(owner);
        name = _name;
    }
}
