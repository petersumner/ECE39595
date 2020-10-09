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
        System.out.println("Room: \n   room: " + room.name + "\n   posX: " + room.posX + "\n   posY: " + room.posY + "\n   width: " + room.width + "\n   height: " + room.height);
    }

    public void addCreature(Creature creature){
        if (creature instanceof Monster){
            Monster monster = (Monster)creature;
            System.out.println("Monster: \n   name: " + monster.name + "\n   room: " + monster.room + "\n   serial: " + monster.serial + "\n   posX: " + "\n   posY: " + "\n   type: " + "\n   hp: " + "\n   maxHit: ");
        } else if (creature instanceof Player){
            System.out.println("Player: \n   name: " + "\n   room: " + "\n   serial: " + "\n   posX: " + "\n   posY: " + "\n   hp: " + "\n   maxHit: " + "\n   hpMoves: ");
        }
    }

    public void addPassage(Passage passage){
        System.out.println("Passage:\n");
    }

    public void addItem(Item item){
        System.out.println("Item:\n");
    }
    
}
