package game.ui;

import javax.swing.JFrame;

/**
 * The JFrame window the game runs inside of.
 */
public class GameWindow extends JFrame {
    /**
     * Constructor.
     * @param panel the GamePanel that runs inside this window
     */
    public GameWindow(GamePanel panel) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        
    }

}
