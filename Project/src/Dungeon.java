package src;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {    

    public String name;
    public int width;
    public int gameHeight;
    public List<Room> rooms = new ArrayList<Room>();
    public List<Creature> creatures = new ArrayList<Creature>();
    public List<Passage> passages = new ArrayList<Passage>();
    public List<Item> items = new ArrayList<Item>();

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
        width = _width;
        gameHeight = _gameHeight;

        System.out.println("Dungeon: \n   name: " + name + "\n   width: " + width + "\n   gameHeight: " + gameHeight);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void addCreature(Creature creature){
        creatures.add(creature);
    }

    public void addPassage(Passage passage){
        passages.add(passage);
    }

    public void addItem(Item item){
        items.add(item);
    }
    
}
