package game;

import src.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public int key;
    private Dungeon dungeon;
    
    public KeyInput(Dungeon dungeon){
        this.dungeon = dungeon;
    }

    public void keyPressed(KeyEvent e){
        key = e.getKeyCode();
        System.out.println(key);  
        for(int i = 0; i < dungeon.creatures.size(); i++){
            Creature temp = dungeon.creatures.get(i);

            if(temp.getClass() == Player.class){
                if (key == KeyEvent.VK_J) { temp.setPosY(temp.posY + 1); }

            }
        }
                  
    }

    public void keyReleased(KeyEvent e){
        key = 0;
    }
}
