package src;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DungeonXMLHandler extends DefaultHandler {
    
    private StringBuilder data = null;

    private Dungeon dungeon;

    private ArrayList<Room> rooms;
    private Room roomBeingParsed = null;

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

        } else if (qName.equalsIgnoreCase("Passage")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));

        } else if (qName.equalsIgnoreCase("Player")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Player player = new Player();
            dungeon.addCreature(player);

        } else if (qName.equalsIgnoreCase("Monster")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
            Monster monster = new Monster();
            dungeon.addCreature(monster);
            
        } else if (qName.equalsIgnoreCase("Armor")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));

        } else if (qName.equalsIgnoreCase("Sword")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));

        } else if (qName.equalsIgnoreCase("Scroll")) {
            String name = attributes.getValue("name");
            int room = Integer.parseInt(attributes.getValue("room"));
            int serial = Integer.parseInt(attributes.getValue("serial"));
        
        } else if (qName.equalsIgnoreCase("CreatureAction")) {
            String name = attributes.getValue("name");
        
        } else if (qName.equalsIgnoreCase("posX")) {
            bPosX = true;
        } else if (qName.equalsIgnoreCase("posY")) {
            bPosY = true;
        } else if (qName.equalsIgnoreCase("type")) {
            bType = true;
        } else if (qName.equalsIgnoreCase("visible")) {
            bVisible = true;
        } else if (qName.equalsIgnoreCase("hp")) {
            bHp = true;
        } else if (qName.equalsIgnoreCase("hpMoves")) {
            bHpMoves = true; 
        } else if (qName.equalsIgnoreCase("maxhit")) {
            bMaxHit = true;
        } else if (qName.equalsIgnoreCase("actionmessage")) {
            bActionMessage = true;
        } else if (qName.equalsIgnoreCase("width")) {
            bWidth = true;
        } else if (qName.equalsIgnoreCase("height")) {
            bHeight = true;
        } else {
            System.out.println("Unknown qname: " + qName);
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
    }

}
