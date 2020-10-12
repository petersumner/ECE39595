package src;

public class Passage extends Structure {

    public String name;
    public int room1;
    public int room2;
    
    public Passage(){}

    public void setName(String _name){
        name = _name;
        System.out.println("   name: " + name);
    }

    public void setId(int _room1, int _room2){
        room1 = _room1;
        room2 = _room2;
        System.out.println("   room1: " + room1 + "\n   room2: " + room2);
    }
}
