package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public int key;
    
    public KeyInput(){

    }

    @Override
    public void keyPressed(KeyEvent e){
        key = e.getKeyCode();
        if(key == KeyEvent.VK_J){
            System.out.println('j');
        }
              
    }

    @Override
    public void keyReleased(KeyEvent e){
        key = 0;
    }
}
