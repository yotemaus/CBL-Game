package game.ui;

import javax.swing.JFrame;
import game.main.GameLoop;

public class GameWindow extends JFrame {
    
    public GameWindow(GamePanel panel, GameLoop loop) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        
    }

}
