package src.game.main;

import src.game.ui.GamePanel;
import src.game.ui.GameWindow;

//TODO: Mandatory javadoc comment
public class Main {
    
    public static void main(String[] args) {

        GamePanel panel = new GamePanel();
        new GameWindow(panel);
        //Game Loop
        GameLoop loop = new GameLoop();
        loop.startGameLoop();
    }

}
