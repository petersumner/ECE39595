package game;

import src.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public int key;
    private Dungeon dungeon;
    private Player player;
    
    public KeyInput(Dungeon _dungeon){
        this.dungeon = _dungeon;
        for(int i=0; i<dungeon.creatures.size(); i++){
            if(dungeon.creatures.get(i).getClass() == Player.class){
                player = (Player) dungeon.creatures.get(i);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e){
        key = e.getKeyCode();
        System.out.println(key);  
        if(key == KeyEvent.VK_J){
            player.setPosY(player.posY + 1);
        }            
    }

    @Override
    public void keyReleased(KeyEvent e){
        key = 0;
    }
}
