package src;

public class Armor extends Item {
    
    public String name;
    public int room;
    public int serial;

    public Armor(String _name){
        name = _name;
        System.out.println("Armor: " + name);
    }

    public void setName(String _name){
        name = _name;
        System.out.println("Armor name set to " + name);
    }

    public void setId(int _room, int _serial){
        room = _room;
        serial = _serial;
        System.out.println("   room: " + room + "\n   serial: " + serial);
    }
}
