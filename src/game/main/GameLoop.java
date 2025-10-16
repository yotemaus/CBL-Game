package game.main;

public class GameLoop implements Runnable {

    private final Runnable updater;
    private final Runnable renderer;
    private volatile boolean running = false;
    private Thread gameThread;

    private final double targetUps; //Updates per second

    public GameLoop(Runnable updater, Runnable renderer, double targetUps) {
        this.updater = updater;
        this.renderer = renderer;
        this.targetUps = targetUps;
    }

    public void startGameLoop() {

        if (!running) {
            running = true;
            gameThread = new Thread(this, "GameLoopThread");
            gameThread.start();
        }
    }

    @Override
    public void run() {
        final double nsPerUpdate = 1000000000.0 / targetUps; //nanoseconds per update
        long lastTime = System.nanoTime(); 
        double delta = 0.0; //difference between last update time and current time

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerUpdate;
            lastTime = now;

            while (delta >= 1.0) {
                updater.run(); //advance game state
                delta -= 1.0;
            }

            renderer.run();
        }
    }
}
