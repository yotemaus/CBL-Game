package src.game.main;

public class GameLoop implements Runnable {

    private volatile boolean running = false;
    private Thread gameThread;

    public void startGameLoop() {

        if (!running) {
            running = true;
            gameThread = new Thread(this, "GameLoopThread");
            gameThread.start();
        }
    }

    @Override
    public void run() {
        
        while (running) {
            
        }
    }
    
}
