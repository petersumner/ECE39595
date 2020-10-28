package src;

public class Room extends Structure {

    public String name;
    
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
