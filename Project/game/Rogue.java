package game;

public class Rogue implements Runnable {

    private static ObjectDisplayGrid displayGrid = null;
    private static final int WIDTH = 80;
    private static final int HEIGHT = 40;
    private Thread keyStrokePrinter;
    String filename = null;

    public Rogue(int width, int height){
        displayGrid = new ObjectDisplayGrid(width, height);
        filename = "src/xmlFiles/dungeon.xml";
    }

    @Override
    public void run() {
        displayGrid.fireUp();
        for(int step = 1; step < WIDTH/2; step *= 2){
            for(int i = 0; i < WIDTH; i += step) {
                for(int j = 0; j < HEIGHT; j += step) {
                    displayGrid.addObjectToDisplay(new Char('X'), i, j);
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            displayGrid.initializeDisplay();
        }
    }

    public static void main(String args[]) throws Exception {
        Rogue game = new Rogue(WIDTH, HEIGHT);
        Thread thread = new Thread(game);
        thread.start();
        game.keyStrokePrinter = new Thread(new KeyStrokePrinter(displayGrid));
        game.keyStrokePrinter.start();
        thread.join();
        game.keyStrokePrinter.join();
    }
    
}
