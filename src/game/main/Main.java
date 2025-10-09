package src.game.main;

import src.game.ui.GamePanel;
import src.game.ui.GameWindow;

/**
/**
 * 
 * `Creates the window frame and runs the game loop
 * 
 */
public class Main {
    
    public static void main(String[] args) {

        GameWindow window = new GameWindow();
        GamePanel panel = new GamePanel();
        window.add(panel);
        window.pack();
        //Game Loop
    }

}
