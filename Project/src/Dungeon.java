package src;

import java.util.ArrayList;

public class Dungeon {    

    public String name;
    public int width;
    public int gameHeight;
    ArrayList<Room> rooms;
    ArrayList<Creature> creatures;
    ArrayList<Passage> passages;
    ArrayList<Item> items;

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
        width = _width;
        gameHeight = _gameHeight;

        System.out.println("Dungeon: \n   name: " + name + "\n   width: " + width + "\n   gameHeight: " + gameHeight);
    }

    public void addRoom(Room room){
    }

    public void addCreature(Creature creature){
    }

    public void addPassage(Passage passage){
    }

    public void addItem(Item item){
    }
    
}
