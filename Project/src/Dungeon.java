package src;

public class Dungeon {    

    public String name;
    public int width;
    public int gameHeight;

    public Dungeon(String _name, int _width, int _gameHeight){
        name = _name;
        width = _width;
        gameHeight = _gameHeight;

        System.out.println("Dungeon: \n   name: " + name + "\n   width: " + width + "\n   gameHeight: " + gameHeight);
    }

    public void addRoom(Room room){
        System.out.println("Room: \n   room: " + room.name);
    }

    public void addCreature(Creature creature){
        if (creature instanceof Monster){
            Monster monster = (Monster)creature;
            System.out.println("Monster: \n   name: " + monster.name + "\n   room: " + monster.room + "\n   serial: " + monster.serial);
        } else if (creature instanceof Player){
            Player player = (Player)creature;
            System.out.println("Player: \n   name: Player\n   room: " + player.room + "\n   serial: " + player.serial);
        }
    }

    public void addPassage(Passage passage){
        System.out.println("Passage: ");
    }

    public void addItem(Item item){
        System.out.println("Item: ");
    }
    
}
