package src;

public class Room extends Structure {

    public String name;
    public int posX = 8;
    public int posY;
    public int width;
    public int height;
    
    public Room(String room){        
        name = room;    
        System.out.println("Room:\n   room: " + name);
    }

    public void setId(String room){
        name = room;
    }

    public void setCreature(Creature monster){
        
    }
}
