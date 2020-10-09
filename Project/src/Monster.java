package src;

public class Monster extends Creature {

    public String name;
    public int room;
    public int serial;

    public Monster(){}

    public void setName(String _name){
        name = _name;
    }

    public void setId(int _room, int _serial){
        room = _room;
        serial = _serial;
    }
}
