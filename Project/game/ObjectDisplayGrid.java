package game;

import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {

    private static final long serialVersionUID = 1L;
    private static int height;
    private static int width;
    private static AsciiPanel terminal;
    private List<InputObserver> inputObservers = null;
    private static final String CLASSID = ".ObjectDisplayGrid";
    private Char[][] objectGrid = null;

    public ObjectDisplayGrid(int _width,  int _height){
        width = _width;
        height = _height;

        terminal = new AsciiPanel(width, height);
        objectGrid = new Char[width][height];
        initializeDisplay();

        super.add(terminal);
        super.setSize(width*9, height*16);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        terminal.setVisible(true);
        super.addKeyListener(this);
        inputObservers = new ArrayList<>();
        super.repaint();
    }

    @Override
    public void registerInputObserver(InputObserver observer){
        inputObservers.add(observer);
    }

    @Override
    public void keyTyped(KeyEvent e){
        KeyEvent keypress = (KeyEvent) e;
        notifyInputObservers(keypress.getKeyChar());
    }

    private void notifyInputObservers(char ch) {
        for(InputObserver observer : inputObservers){
            observer.observerUpdate(ch);
        }
    }

    @Override
    public void keyPressed(KeyEvent even){}

    @Override
    public void keyReleased(KeyEvent e){}

    public final void initializeDisplay(){
        Char ch = new Char('.');
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                addObjectToDisplay(ch, i, j);
            }
        }
        terminal.repaint();
    }

    public void fireUp(){
        if(terminal.requestFocusInWindow()){
            System.out.println(CLASSID + ".ObjectDisplayGrid(...) requestFocusInWindow Succeeded");
        } else {
            System.out.println(CLASSID + ".ObjectDisplayGric(...) requestFocusInWindow FAILED");
        }
    }

    public void addObjectToDisplay(Char ch, int x, int y){
        if((0 <= x) && (x < objectGrid.length)) {
            if((0 <= y) && (y < objectGrid[0].length)) {
                objectGrid[x][y] = ch;
                writeToTerminal(x, y);
            }
        }
    }

    private void writeToTerminal(int x, int y){
        char ch = objectGrid[x][y].getChar();
        terminal.write(ch, x, y);
        terminal.repaint();
    }
}
