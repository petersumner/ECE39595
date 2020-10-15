package src;

import java.util.ArrayList;

public class Dungeon {    

    public String name;
    public int width;
    public int gameHeight;
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Creature> creatures = new ArrayList<Creature>();
    ArrayList<Passage> passages = new ArrayList<Passage>();
    ArrayList<Item> items = new ArrayList<Item>();

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
        width = _width;
        gameHeight = _gameHeight;

        System.out.println("Dungeon: \n   name: " + name + "\n   width: " + width + "\n   gameHeight: " + gameHeight);
    }

    public void addRoom(Room room){
        rooms.add(rooms.size(), room);
    }

    public void addCreature(Creature creature){
        creatures.add(creatures.size(), creature);
    }

    public void addPassage(Passage passage){
        passages.add(passages.size(), passage);
    }

    public void addItem(Item item){
        items.add(items.size(), item);
    }
    
}
