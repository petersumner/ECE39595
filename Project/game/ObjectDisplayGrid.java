package game;

import src.*;

import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDisplayGrid extends JFrame implements KeyListener {

    private static final long serialVersionUID = -3705248120375555442L;
    private static final int DEBUG = 0;
    private static final String CLASSID = ".ObjectDisplayGrid";

    private static AsciiPanel terminal;
    private Char[][] objectGrid = null;

    private static int height;
    private static int width;
    private Dungeon dungeon;
    private char last = 0;
    private boolean showPack = false;
    private boolean endGame = false;

    public List<Item> pack = new ArrayList<Item>();

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
        super.setVisible(true);
        terminal.setVisible(true);
        super.addKeyListener(this);
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (DEBUG > 0) { System.out.println(CLASSID + ".keyTyped entered" + e.toString()); }
        KeyEvent keypress = (KeyEvent) e;
        char key = keypress.getKeyChar();
        for(int i=0; i<dungeon.creatures.size(); i++) {
            if(dungeon.creatures.get(i).getClass() == Player.class) {
                Player temp = (Player) dungeon.creatures.get(i);
                if(last == 0 && endGame == false) {
                    if(key == 'k' && checkWalkable(temp.posX, temp.posY-1)) { temp.setPosY(temp.posY-1); } 
                    else if(key == 'j' && checkWalkable(temp.posX, temp.posY+1)) { temp.setPosY(temp.posY+1); } 
                    else if(key == 'h' && checkWalkable(temp.posX-1, temp.posY)) { temp.setPosX(temp.posX-1); } 
                    else if(key == 'l' && checkWalkable(temp.posX+1, temp.posY)) { temp.setPosX(temp.posX+1); } 
                    else if(key == 'i') { showPack = !showPack; togglePack(); }
                    else if(key == 'c') {}
                    else if(key == 'd') { last = 'd'; }
                    else if(key == 'p') { addItem(temp.posX, temp.posY); }
                    else if(key == 'r') { last = 'r'; }
                    else if(key == 'w') { last = 'w'; }
                    else if(key == 't') {}
                    else if(key == '?') { System.out.println("h,l,k,j,i,?,H,c,d,p,R,T,w,E,0-9. H <cmd> for more info"); }
                    else if(key == 'H') { last = 'H'; }
                    else if(key == 'E') { last = 'E'; }
                } else if(last == 0) { 
                    if(key == 'H') { last = 'H'; }
                    else if(key == 'E') { last = 'E'; }
                } else if(last == 'H') {
                    if(key == 'k') { System.out.println("k: move up"); }
                    else if(key == 'j') { System.out.println("j: move down"); }
                    else if(key == 'h') { System.out.println("h: move left"); }
                    else if(key == 'l') { System.out.println("l: move right"); }
                    else if(key == 'i') { System.out.println("i: inventory -- show pack contents");}
                    else if(key == 'c') { System.out.println("c: take off/change armor"); }
                    else if(key == 'd') { System.out.println("d: drop <item number> item from pack"); }
                    else if(key == 'p') { System.out.println("p: pick up item under player and put in pack"); }
                    else if(key == 'r') { System.out.println("r: read scroll <item number> item from pack"); }
                    else if(key == 'w') { System.out.println("w: wear armor <item number> item from pack"); }
                    else if(key == 't') { System.out.println("t: take out weapon from pack"); }
                    last = 0;
                } else if (last == 'E') {
                    if(key == 'Y' || key == 'y') { System.exit(1); }
                    last = 0;
                } else if (last == 'w' && endGame == false) {
                    equipArmor(key);
                    last = 0;
                } else if (last == 'd' && endGame == false) {
                    if(pack.size() <= Character.getNumericValue(key)){
                        dropItem(temp.posX, temp.posY, Character.getNumericValue(key));
                    }
                    last = 0;
                } else if (last == 'r' && endGame == false) {
                    if(pack.size() <= key && pack.get(key).getClass() == Scroll.class){
                        
                    }
                    last = 0;
                }
            }
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
        y = y+2;
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
        char ch = objectGrid[x][y+2].getChar();
        if(ch == 'T' || ch == 'H' || ch == 'S') {
            for(int i=0; i<dungeon.creatures.size(); i++){
                if(x == dungeon.creatures.get(i).posX && y == dungeon.creatures.get(i).posY) {
                    Monster monster = (Monster) dungeon.creatures.get(i);
                    fight(monster, i);
                }
            }
        } else if(ch == '.' || ch == '#' || ch == '+' || ch == '?' || ch == ']' || ch == ')') { return true; }
        return false;
    }

    private void fight(Monster monster, int j) {
        for(int i=0; i<dungeon.creatures.size(); i++) {
            if(dungeon.creatures.get(i).getClass() == Player.class) {
                Player player = (Player) dungeon.creatures.get(i);
                System.out.println("FIGHT: "+monster.hp+" "+player.maxHit);
                monster.setHp(monster.hp - player.maxHit);
                displayString(monster.name+": -"+player.maxHit+"HP", 6, dungeon.gameHeight);
                if(monster.hp < 1) {
                    doActions(monster, "death");
                    return;
                }
                player.setHp(player.hp - monster.maxHit);
                if(player.hp < 1) {
                    player.setHp(0);
                    doActions(player, "death");
                }
                displayString("Player: -"+monster.maxHit+"HP", 22, dungeon.gameHeight);
            }
        }
    }

    private void doActions(Creature creature, String type) {
        for(int i=0; i<creature.creatureActions.size(); i++) {
            CreatureAction action = creature.creatureActions.get(i);
            if(action.type.equals(type)) {
                if(action.msg != null) { 
                    clearRow(dungeon.gameHeight);
                    displayString(action.msg, 6, dungeon.gameHeight); 
                }
                if(type.equals("death")) {
                    if(creature.getClass() == Player.class) {
                        endGame = true;
                    } else {
                        dungeon.creatures.remove(creature);
                    }
                } else if(type.equals("hit")) {

                }
            }
        }
    }

    private void togglePack() {
        clearRow(dungeon.gameHeight-2);
        if(showPack == true) {
            if(pack.size() == 0){
                displayString("pack is empty", 6, dungeon.gameHeight-2);
            } else {
                for(int i=0; i<pack.size(); i++) {
                    displayString(Integer.toString(i+1), 6+i*10, dungeon.gameHeight-2);
                }
            }
        }
    }

    private void equipArmor(int x) {
        if(pack.size() <= x && pack.get(x).getClass() == Armor.class){
            
        }
    }

    private void addItem(int x, int y){
        for(int i=0; i<dungeon.items.size(); i++){
            Item item = dungeon.items.get(i);
            if(item.posX == x && item.posY == y){
                pack.add(item);
                dungeon.items.remove(i);
            }
        }
    }

    private void dropItem(int x, int y, int i) {
        Item item = pack.get(i-1);
        item.posX = x;
        item.posY = y;
        dungeon.items.add(item);
        pack.remove(i-1);
    }

    public void displayString(String msg, int x, int y){
        for(int i=0; i<msg.length(); i++){
            addObjectToDisplay(new Char(msg.charAt(i)), x+i, y);
        }
    }

    private void clearRow(int y) {
        for(int i=6; i<width; i++) { addObjectToDisplay(new Char(' '), i, y); }
    }
}
