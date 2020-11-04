package src;

public class Item extends Displayable {

    public Creature owner;
    public int room;
    public String msg;
    public Action action;

    public void setOwner(Creature _owner){
        owner = _owner;
    }

    public void setRoom(int _room){
        room = _room;
    }
    
    public void setMsg(String _msg) {
        msg = _msg;
    }

    public void setAction(Action _action){
        action = _action;
    }
}