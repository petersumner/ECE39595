package src;

public class Room extends Structure {

    public String name;
    public int posX = 0;
    public int posY = 0;
    public int width = 0;
    public int height = 0;
    
    public Room(String room){        
        name = room;    
        System.out.println("Room:\n   room: " + name);
    }

    public void setId(String room){
        name = room;
    }

    public void setCreature(Creature monster){}

}
