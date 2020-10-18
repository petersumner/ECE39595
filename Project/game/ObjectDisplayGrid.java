package game;

import asciiPanel.AsciiPanel;
import javax.swing.*;

public class ObjectDisplayGrid extends JFrame implements KeyListener, InputSubject {
    
    private static int height;
    private static int width;
    private static AsciiPanel terminal;

    public ObjectDisplayGrid(int _width,  int _height){
        width = _width;
        height = _height;

        terminal = new AsciiPanel(width, height);

    }

    @Override
    public void registerInputObserver(InputObserver observer){
        InputObservers.add(observer);
    }
}
