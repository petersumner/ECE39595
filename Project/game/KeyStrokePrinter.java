package game;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class KeyStrokePrinter implements InputObserver, Runnable {
    
    private static Queue<Character> inputQueue = null;
    private ObjectDisplayGrid displayGrid;

    public KeyStrokePrinter(ObjectDisplayGrid grid){
        inputQueue = new ConcurrentLinkedQueue<>();
        displayGrid = grid;
    }

    @Override
    public void observerUpdate(char ch){
        inputQueue.add(ch);
    }

    private void rest(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean processInput(){
        char ch;
        boolean processing = true;
        while(processing){
            if(inputQueue.peek() == null){
                processing = false;
            } else {
                ch = inputQueue.poll();
                if(ch == 'X'){
                    System.out.println("got an X, ending input checking");
                    return false;
                } else {
                    System.out.println("character " + ch + " entered on keyboard");
                }
            }
        }
        return true;
    }

    @Override
    public void run(){
        displayGrid.registerInputObserver(this);
        boolean working = true;
        while(working){
            rest();
            working = (processInput());
        }
    }

}
