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
    //private Thread keyStrokePrinter;
    public static Dungeon dungeon;
    public static DungeonXMLHandler handler;

    public Rogue(int width, int height) {
        displayGrid = new ObjectDisplayGrid(width, height);
    }

    @Override
    public void run() {
        displayGrid.fireUp();

        // Display Walls
        for(int i=0; i<dungeon.rooms.size(); i++){
            for(int j=0; j<dungeon.rooms.get(i).width; j++){
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+j, dungeon.rooms.get(i).posY);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+j, dungeon.rooms.get(i).posY+dungeon.rooms.get(i).height-1);
            }
            for(int j=1; j<dungeon.rooms.get(i).height-1; j++){
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX, dungeon.rooms.get(i).posY+j);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX+dungeon.rooms.get(i).width-1, dungeon.rooms.get(i).posY+j);
                for(int k=1; k<dungeon.rooms.get(i).width-1; k++){
                    displayGrid.addObjectToDisplay(new Char('.'), dungeon.rooms.get(i).posX+k, dungeon.rooms.get(i).posY+j);
                }
            }
        }

        // Display Creatures
        for(int i=0; i<dungeon.creatures.size(); i++){
            int room = dungeon.creatures.get(i).room-1;
            int x = dungeon.rooms.get(room).posX + dungeon.creatures.get(i).posX;
            int y = dungeon.rooms.get(room).posY + dungeon.creatures.get(i).posY;
            if(dungeon.creatures.get(i).getClass() == Player.class){
                displayGrid.addObjectToDisplay(new Char('@'), x, y);
            }
            else{
                displayGrid.addObjectToDisplay(new Char(dungeon.creatures.get(i).type), x, y);
            }
        }    

        // Display Items
    }

    public static void main(String[] args) throws Exception {
        String fileName = "src/xmlFiles/death.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            handler = new DungeonXMLHandler();
            saxParser.parse(new File(fileName), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
        dungeon = handler.dungeon;
        Rogue rogue = new Rogue(dungeon.width, dungeon.gameHeight);
        Thread rogueThread = new Thread(rogue);
        rogueThread.start();

        //rogue.keyStrokePrinter = new Thread(new KeyStrokePrinter(displayGrid));
        //rogue.keyStrokePrinter.start();

        rogueThread.join();
        //rogue.keyStrokePrinter.join();
    }
}