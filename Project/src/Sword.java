package src;

public class Sword extends Item {

    public String name;
    public int room;
    public int serial;
    
    public Sword(String _name){
        name = _name;
        System.out.println("Sword:\n   name: " + name);
    }

    public void setId(int room, int serial){
        System.out.println("   room: " + room + "\n   serial: " + serial);
    }
}
