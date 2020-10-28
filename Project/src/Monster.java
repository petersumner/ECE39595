package src;

public class Monster extends Creature {

    public String name;
    public int room;
    public int serial;
    public char type;

    public Monster(){
        System.out.println("Mosnter:");
    }

    public void setName(String _name){
        name = _name;
    }

    public void setId(int _room, int _serial){
        room = _room;
        serial = _serial;
        System.out.println("   room: " + room + "\n   serial: " + serial);
    }
}
