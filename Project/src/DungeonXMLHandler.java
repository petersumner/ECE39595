package src;

//import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DungeonXMLHandler extends DefaultHandler {
    
    private StringBuilder data = null;

    public Dungeon dungeon;

    private boolean bPosX = false;
    private boolean bPosY = false;
    private boolean bType = false;
    private boolean bHp = false;
    private boolean bHpMoves = false;
    private boolean bMaxHit = false;
    private boolean bActionMessage = false;
    private boolean bVisible = false;
    private boolean bWidth = false;
    private boolean bHeight = false;
    private boolean bActionIntValue = false;
    private boolean bItemIntValue = false;
    private boolean bActionCharValue = false;

    private Displayable objectBeingParsed = null;
    private Action actionBeingParsed = null;
    private Creature creatureBeingParsed = null;
    private Item itemBeingParsed = null;

    public Dungeon getDungeon() {
        return dungeon;
    }

    public DungeonXMLHandler(){}

    @Override
    public void startElement(String uri,  String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Dungeon")) {
            String name = attributes.getValue("name");
            int width = Integer.parseInt(attributes.getValue("width"));
            int gameHeight = Integer.parseInt(attributes.getValue("gameHeight"));
            dungeon = new Dungeon(name, width, gameHeight);

        } else if (qName.equalsIgnoreCase("Rooms")) {

        } else if (qName.equalsIgnoreCase("Room")) {
            String id = attributes.getValue("room");
            Room room = new Room(id);
            dungeon.addRoom(room);
            objectBeingParsed = room;

        } else if (qName.equalsIgnoreCase("Passages")) {
            
        } else if (qName.equalsIgnoreCase("Passage")) {
            int room1 = Integer.parseInt(attributes.getValue("room1"));
            int room2 = Integer.parseInt(attributes.getValue("room2"));
            Passage passage = new Passage();
            passage.setId(room1, room2);
            dungeon.addPassage(passage);
            objectBeingParsed = passage;

        } else if (qName.equalsIgnoreCase("Player")) {
            int roomNum = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Player player = new Player();
            player.setRoom(roomNum);
            player.serial = serial;
            dungeon.addCreature(player);
            creatureBeingParsed = player;
            objectBeingParsed = player;

        } else if (qName.equalsIgnoreCase("Monster")) {
            String name = attributes.getValue("name");
            int roomNum = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Monster monster = new Monster();
            monster.setName(name);
            monster.setId(roomNum, serial);
            dungeon.addCreature(monster);
            creatureBeingParsed = monster;
            objectBeingParsed = monster;
            
        } else if (qName.equalsIgnoreCase("Armor")) {
            String name = attributes.getValue("name");
            int roomNum = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Armor armor = new Armor(name);
            armor.setId(roomNum, serial);
            objectBeingParsed = armor;
            itemBeingParsed = armor;
            if(creatureBeingParsed.getClass() == Player.class) {
                Player player = (Player) creatureBeingParsed;
                player.setArmor(armor);
            } else {
                dungeon.addItem(armor);
            }

        } else if (qName.equalsIgnoreCase("Sword")) {
            String name = attributes.getValue("name");
            int roomNum = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Sword sword = new Sword(name);
            sword.setId(roomNum, serial);
            objectBeingParsed = sword;
            itemBeingParsed = sword;
            if(creatureBeingParsed.getClass() == Player.class) {
                Player player = (Player) creatureBeingParsed;
                player.setWeapon(sword);
            } else {
                dungeon.addItem(sword);
            }

        } else if (qName.equalsIgnoreCase("Scroll")) {
            String name = attributes.getValue("name");
            int roomNum = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Scroll scroll = new Scroll(name);
            scroll.setId(roomNum, serial);
            dungeon.addItem(scroll);
            objectBeingParsed = scroll;
            itemBeingParsed = scroll;
        
        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            CreatureAction action = new CreatureAction((Creature)creatureBeingParsed);
            action.setName(name);
            action.setType(type);
            creatureBeingParsed.addCreatureAction(action);
            //if(type.equals("death")) { creatureBeingParsed.setDeathAction(action); }
            actionBeingParsed = action;
        
        } else if (qName.equalsIgnoreCase("ItemAction")) {
            String name = attributes.getValue("name");
            String type = attributes.getValue("type");
            ItemAction action = new ItemAction((Item)objectBeingParsed);
            action.setName(name);
            action.setType(type);
            itemBeingParsed.setAction(action);
            actionBeingParsed = action;
        } 
        else if (qName.equalsIgnoreCase("posX")) { bPosX = true; } 
        else if (qName.equalsIgnoreCase("posY")) { bPosY = true; } 
        else if (qName.equalsIgnoreCase("type")) { bType = true; } 
        else if (qName.equalsIgnoreCase("visible")) { bVisible = true; }
        else if (qName.equalsIgnoreCase("hp")) { bHp = true; } 
        else if (qName.equalsIgnoreCase("hpMoves")) { bHpMoves = true; } 
        else if (qName.equalsIgnoreCase("maxhit")) { bMaxHit = true; } 
        else if (qName.equalsIgnoreCase("actionMessage")) { bActionMessage = true; } 
        else if (qName.equalsIgnoreCase("width")) { bWidth = true; } 
        else if (qName.equalsIgnoreCase("height")) { bHeight = true; } 
        else if (qName.equalsIgnoreCase("actionIntValue")) { bActionIntValue = true; } 
        else if (qName.equalsIgnoreCase("itemIntValue")) { bItemIntValue = true; } 
        else if (qName.equalsIgnoreCase("actionCharValue")) { bActionCharValue = true; } 
        else { System.out.println("Unknown qname: " + qName); }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Displayable object = objectBeingParsed;
        Action action = actionBeingParsed;
        if (bPosX) {
            object.setPosX(Integer.parseInt(data.toString()));
            bPosX = false;
        } else if (bPosY) {
            object.setPosY(Integer.parseInt(data.toString()));
            bPosY = false;
        } else if (bType) {
            object.setType(data.charAt(0));
            bType = false;
        } else if (bVisible) {
            bVisible = false;
        } else if (bHp) {
            object.setHp(Integer.parseInt(data.toString()));
            bHp = false;
        } else if (bHpMoves) {
            object.setHpMove(Integer.parseInt(data.toString()));
            bHpMoves = false;
        } else if (bMaxHit) {
            object.setMaxHit(Integer.parseInt(data.toString()));
            bMaxHit = false;
        } else if (bActionMessage) {
            action.setMessage(data.toString());
            bActionMessage = false;
        } else if (bWidth) {
            object.setWidth(Integer.parseInt(data.toString()));
            bWidth = false;
        } else if (bHeight) {
            object.setHeight(Integer.parseInt(data.toString()));
            bHeight = false;
        } else if (bActionIntValue) {
            action.setIntValue(Integer.parseInt(data.toString()));
            bActionIntValue = false;
        } else if (bItemIntValue) {
            object = (Item) object;
            object.setIntValue(Integer.parseInt(data.toString()));
            bItemIntValue = false;
        } else if (bActionCharValue) {
            action.setCharValue(data.charAt(0));
            bActionCharValue = false;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }
}
