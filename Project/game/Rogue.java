package game;

import src.*;

import java.awt.Canvas;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class Rogue extends Canvas implements Runnable {

    private static final long serialVersionUID = 3297052250187212136L;

    public static final int FRAMESPERSECOND = 60;
    public static final int TIMEPERLOOP = 1000000000 / FRAMESPERSECOND;
    private static ObjectDisplayGrid displayGrid = null;
    private boolean running = false;
    private Thread thread;
    private static Dungeon dungeon;
    private static DungeonXMLHandler handler;

    public Rogue(int width, int height) {
        displayGrid = new ObjectDisplayGrid(width, height);
        this.addKeyListener(new KeyInput(dungeon));
        this.start();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double delta = 0;
        long timer = System.currentTimeMillis();
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / TIMEPERLOOP;
            lastTime = now;
            while(delta >= 1) {
                //tick();
                delta--;
            }
            if(running)
                display();

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
            }
        }
        stop();
    }

    public void display() {

        displayGrid.fireUp();

        // Display Walls
        for (int i = 0; i < dungeon.rooms.size(); i++) {
            for (int j = 0; j < dungeon.rooms.get(i).width; j++) {
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX + j, dungeon.rooms.get(i).posY);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX + j, dungeon.rooms.get(i).posY + dungeon.rooms.get(i).height - 1);
            }
            for (int j = 1; j < dungeon.rooms.get(i).height - 1; j++) {
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX, dungeon.rooms.get(i).posY + j);
                displayGrid.addObjectToDisplay(new Char('X'), dungeon.rooms.get(i).posX + dungeon.rooms.get(i).width - 1, dungeon.rooms.get(i).posY + j);
                for (int k = 1; k < dungeon.rooms.get(i).width - 1; k++) {
                    displayGrid.addObjectToDisplay(new Char('.'), dungeon.rooms.get(i).posX + k, dungeon.rooms.get(i).posY + j);
                }
            }
        }

        // Display Creatures
        for (int i = 0; i < dungeon.creatures.size(); i++) {
            int room = dungeon.creatures.get(i).room - 1;
            int x = dungeon.rooms.get(room).posX + dungeon.creatures.get(i).posX;
            int y = dungeon.rooms.get(room).posY + dungeon.creatures.get(i).posY;
            if (dungeon.creatures.get(i).getClass() == Player.class) { displayGrid.addObjectToDisplay(new Char('@'), x, y); } 
            else { displayGrid.addObjectToDisplay(new Char(dungeon.creatures.get(i).type), x, y); }
        }

        // Display Items
        for (int i = 0; i < dungeon.items.size(); i++) {
            int room = dungeon.items.get(i).room - 1;
            int x = dungeon.rooms.get(room).posX + dungeon.items.get(i).posX;
            int y = dungeon.rooms.get(room).posY + dungeon.items.get(i).posY;
            if (dungeon.items.get(i).getClass() == Scroll.class) { displayGrid.addObjectToDisplay(new Char('?'), x, y); } 
            else if (dungeon.items.get(i).getClass() == Armor.class) { displayGrid.addObjectToDisplay(new Char(']'), x, y); } 
            else if (dungeon.items.get(i).getClass() == Sword.class) { displayGrid.addObjectToDisplay(new Char(')'), x, y); }
        }

        // Display Passages
        for (int i = 0; i < dungeon.passages.size(); i++) {
            Passage passage = dungeon.passages.get(i);
            int x = passage.xArr[0];
            int y = passage.yArr[0];
            int j;
            displayGrid.addObjectToDisplay(new Char('+'), x, y);
            for (j = 0; j < passage.idx; j++) {
                if (x == passage.xArr[j + 1]) {
                    int k = 1;
                    if (k < passage.yArr[j + 1] - y) {
                        while (k <= passage.yArr[j + 1] - y) { displayGrid.addObjectToDisplay(new Char('#'), x, y + k++); }
                    } else {
                        while (k > passage.yArr[j + 1] - y) { displayGrid.addObjectToDisplay(new Char('#'), x, y - 1 + k--); }
                    }
                } else {
                    int k = 1;
                    while (k <= passage.xArr[j + 1] - x) { displayGrid.addObjectToDisplay(new Char('#'), x + k++, y); }
                }
                x = passage.xArr[j + 1];
                y = passage.yArr[j + 1];
            }
            displayGrid.addObjectToDisplay(new Char('+'), passage.xArr[j - 1], passage.yArr[j - 1]);
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "src/xmlFiles/testDrawing.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            handler = new DungeonXMLHandler();
            saxParser.parse(new File(fileName), handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace(System.out);
        }
        dungeon = handler.dungeon;
        new Rogue(dungeon.width, dungeon.gameHeight);
    }
}