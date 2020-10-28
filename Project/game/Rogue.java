package game;

import src.*;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Rogue implements Runnable {

    public static final int FRAMESPERSECOND = 60;
    public static final int TIMEPERLOOP = 1000000000 / FRAMESPERSECOND;
    private static ObjectDisplayGrid displayGrid = null;
    private Thread keyStrokePrinter;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    public static Dungeon dungeon;
    public static DungeonXMLHandler handler;
    public char ch;

    public Rogue(int width, int height) {
        displayGrid = new ObjectDisplayGrid(width, height);
    }

    @Override
    public void run() {
        displayGrid.fireUp();
        for(int i=0; i<dungeon.rooms.size(); i++){
            for(int j=0; j<dungeon.rooms.get(i).width+1; j++){
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+j, dungeon.rooms.get(i).posY-1);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+j, dungeon.rooms.get(i).posY+dungeon.rooms.get(i).height);
            }
            for(int j=1; j<dungeon.rooms.get(i).height+1; j++){
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX, dungeon.rooms.get(i).posY+j-1);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+dungeon.rooms.get(i).width, dungeon.rooms.get(i).posY+j-1);
            }
        }
        for(int i=0; i<dungeon.creatures.size(); i++){
            if(dungeon.creatures.get(i).getClass() == Player.class){
                displayGrid.addObjectToDisplay(new Char('@'), dungeon.creatures.get(i).posX, dungeon.creatures.get(i).posY);
            }
            else{
                ch = dungeon.creatures.get(i).type;
                displayGrid.addObjectToDisplay(new Char(ch), dungeon.creatures.get(i).posX, dungeon.creatures.get(i).posY);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }    
    }

    public static void main(String[] args) throws Exception {
        String fileName = "src/xmlFiles/dungeon.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            handler = new DungeonXMLHandler();
            saxParser.parse(new File(fileName), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
        dungeon = handler.dungeon;
        Rogue rogue = new Rogue(WIDTH, HEIGHT);
        Thread rogueThread = new Thread(rogue);
        rogueThread.start();

        rogue.keyStrokePrinter = new Thread(new KeyStrokePrinter(displayGrid));
        rogue.keyStrokePrinter.start();

        rogueThread.join();
        rogue.keyStrokePrinter.join();
    }
}