package game.main;

import javax.swing.SwingUtilities;

import game.ui.GamePanel;
import game.ui.GameWindow;

//TODO: Mandatory javadoc comment
public class Main {
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GamePanel panel = new GamePanel();
            GameLoop loop = new GameLoop(panel::update, panel::requestRepaint, 60.0);
            GameWindow window = new GameWindow(panel, loop);
            
            window.setVisible(true);

            loop.startGameLoop();
        });
    }
}
