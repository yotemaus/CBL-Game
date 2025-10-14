package src.game.ui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    
    public GameWindow(GamePanel panel) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Game");
        this.setResizable(false);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
