package src;

public class Sword extends Item {

    public int serial;
    
    public Sword(String _name){
        name = _name;
        System.out.println("Sword:\n   name: " + name);
    }

    public void setId(int _room, int _serial){
        room = _room;
        serial = _serial;
        System.out.println("   room: " + room + "\n   serial: " + serial);
    }

    public String toString() {
        return "Sword";
    }
}
