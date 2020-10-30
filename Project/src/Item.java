package src;

public class Item extends Displayable {

    public Creature owner;
    public int room;

    public void setOwner(Creature _owner){
        owner = _owner;
    }

    public void setRoom(int _room){
        room = _room;
    }
    
}