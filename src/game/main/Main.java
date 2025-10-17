package game.main;

import game.ui.GamePanel;
import game.ui.GameWindow;
import javax.swing.SwingUtilities;

/**
 * Main class.
 */
public class Main {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GamePanel panel = new GamePanel();
            GameLoop loop = new GameLoop(panel::update, panel::requestRepaint, 60.0);
            GameWindow window = new GameWindow(panel);
            
            window.setVisible(true);

            loop.startGameLoop();
        });
    }
}
