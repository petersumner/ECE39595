package src;

public class Monster extends Creature {

    public String name = null;
    public int room = 0;
    public int serial = 0;
    public int posX = 0;
    public int posY = 0;
    public char type = 0;

    public Monster(){}

    public void setName(String _name){
        name = _name;
    }

    public void setId(int _room, int _serial){
        room = _room;
        serial = _serial;
    }
}
