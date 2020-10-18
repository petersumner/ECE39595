package game;

import asciiPanel.AsciiPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {
    
    private static int height;
    private static int width;
    private static AsciiPanel terminal;
    private List<InputObserver> inputObservers = null;

    public ObjectDisplayGrid(int _width,  int _height){
        width = _width;
        height = _height;

        terminal = new AsciiPanel(width, height);

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
    }
}
