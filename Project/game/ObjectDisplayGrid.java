package game;

import src.*;

import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {

    private static final long serialVersionUID = -3705248120375555442L;
    private static final int DEBUG = 0;
    private static final String CLASSID = ".ObjectDisplayGrid";

    private static AsciiPanel terminal;
    private Char[][] objectGrid = null;

    private List<InputObserver> inputObservers = null;

    private static int height;
    private static int width;
    private Dungeon dungeon;
    private boolean help = false;
    private boolean exit = false;

    public ObjectDisplayGrid(int _width, int _height, Dungeon _dungeon) {
        width = _width;
        height = _height;
        dungeon = _dungeon;

        terminal = new AsciiPanel(width, height);

        objectGrid = new Char[width][height];

        initializeDisplay();

        super.add(terminal);
        super.setSize(width * 9, height * 16);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // super.repaint();
        // terminal.repaint( );
        super.setVisible(true);
        terminal.setVisible(true);
        super.addKeyListener(this);
        inputObservers = new ArrayList<>();
        super.repaint();
    }

    @Override
    public void registerInputObserver(InputObserver observer) {
        if (DEBUG > 0) { System.out.println(CLASSID + ".registerInputObserver " + observer.toString()); }
        inputObservers.add(observer);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (DEBUG > 0) { System.out.println(CLASSID + ".keyTyped entered" + e.toString()); }
        KeyEvent keypress = (KeyEvent) e;
        char key = keypress.getKeyChar();
        notifyInputObservers(keypress.getKeyChar());
        for(int i=0; i<dungeon.creatures.size(); i++) {
            if(dungeon.creatures.get(i).getClass() == Player.class) {
                if(help == false && exit == false) {
                    Player temp = (Player) dungeon.creatures.get(i);
                    if(key == 'j' && checkWalkable(temp.posX, temp.posY-1)) { temp.setPosY(temp.posY-1); } 
                    else if(key == 'm' && checkWalkable(temp.posX, temp.posY+1)) { temp.setPosY(temp.posY+1); } 
                    else if(key == 'n' && checkWalkable(temp.posX-1, temp.posY)) { temp.setPosX(temp.posX-1); } 
                    else if(key == ',' && checkWalkable(temp.posX+1, temp.posY)) { temp.setPosX(temp.posX+1); } 
                    else if(key == 'i') {}
                    else if(key == 'c') {}
                    else if(key == 'd') {}
                    else if(key == 'p') {}
                    else if(key == 'r') {}
                    else if(key == 'p') {}
                    else if(key == 'w') {}
                    else if(key == 't') {}
                    else if(key == '?') { System.out.println("h,l,k,j,i,?,H,c,d,p,R,T,w,E,0-9. H <cmd> for more info"); }
                    else if(key == 'H') { help = true; }
                    else if(key == 'E') {exit = true;}
                } else if(help == true) {
                    if(key == 'j') { System.out.println("j: move up"); }
                    else if(key == 'm') { System.out.println("m: move down"); }
                    else if(key == 'n') { System.out.println("n: move left"); }
                    else if(key == ',') { System.out.println(",: move right"); }
                    else if(key == 'i') { System.out.println("i: inventory -- show pack contents");}
                    else if(key == 'c') { System.out.println("c: take off/change armor"); }
                    else if(key == 'd') { System.out.println("d: drop <item number> item from pack"); }
                    else if(key == 'p') { System.out.println("p: pick up item under player and put in pack"); }
                    else if(key == 'r') { System.out.println("r: read scroll <item number> item from pack"); }
                    else if(key == 'w') { System.out.println("w: wear armor <item number> item from pack"); }
                    else if(key == 't') { System.out.println("t: take out weapon from pack"); }
                    help = false;
                } else {
                    if(key == 'Y' || key == 'y') { System.exit(1); }
                    exit = false;
                }
            }
        }
    }

    private void notifyInputObservers(char ch) {
        for (InputObserver observer : inputObservers) {
            observer.observerUpdate(ch);
            if (DEBUG > 0) { System.out.println(CLASSID + ".notifyInputObserver " + ch); }
        }
    }

    // we have to override, but we don't use this
    @Override
    public void keyPressed(KeyEvent e) {}

    // we have to override, but we don't use this
    @Override
    public void keyReleased(KeyEvent e) {}

    public final void initializeDisplay() {
        Char ch = new Char(' ');
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                addObjectToDisplay(ch, i, j);
            }
        }
        terminal.repaint();
    }

    public void fireUp() {
        if (terminal.requestFocusInWindow()) { System.out.println(CLASSID + ".ObjectDisplayGrid(...) requestFocusInWindow Succeeded"); } 
        else { System.out.println(CLASSID + ".ObjectDisplayGrid(...) requestFocusInWindow FAILED"); }
    }

    public void addObjectToDisplay(Char ch, int x, int y) {
        if ((0 <= x) && (x < objectGrid.length)) {
            if ((0 <= y) && (y < objectGrid[0].length)) {
                objectGrid[x][y] = ch;
                writeToTerminal(x, y);
            }
        }
    }

    private void writeToTerminal(int x, int y) {
        char ch = objectGrid[x][y].getChar();
        terminal.write(ch, x, y);
        terminal.repaint();
    }

    private boolean checkWalkable(int x, int y){
        char ch = objectGrid[x][y].getChar();
        if(ch == '.' || ch == '#' || ch == '+') { return true; }
        return false;
    }
}
