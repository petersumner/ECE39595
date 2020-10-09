package src;

public class Dungeon {    

    public String name;
    public int width;
    public int gameHeight;

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
        width = _width;
        gameHeight = _gameHeight;

        System.out.println("Dungeon: " + name);
    }

    public void addRoom(Room room){
        System.out.println("addRoom: " + room.name );
    }

    public void addCreature(Creature creature){
        System.out.println("addCreature: ");
        
    }

    public void addPassage(Passage passage){
        System.out.println("addPassage");
    }

    public void addItem(Item item){
        System.out.println("addItem");
    }
    
}
