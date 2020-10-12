package src;

public class Scroll extends Item {
    
    public Scroll(String name){
        System.out.println("Scroll: " + name);
    }

    public void setId(int room, int serial){
        System.out.println("   room: " + room + "\n   serial: " + serial);
    }
}
