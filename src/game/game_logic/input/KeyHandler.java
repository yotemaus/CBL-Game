package game.game_logic.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Allows the game to monitor keyboard inpots for the player to interact with the game.
 */
public class KeyHandler implements KeyListener {

    public boolean WPressed;
    public boolean SPressed;
    public boolean APressed;
    public boolean DPressed;
    public boolean uppressed;
    public boolean downpressed; 
    public boolean rightpressed; 
    public boolean leftpressed; 
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            WPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            APressed = true;
        }
        if (code == KeyEvent.VK_S) {
            SPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            DPressed = true;
        }
        if (code == KeyEvent.VK_UP) {
            uppressed =true;
        }
        if (code == KeyEvent.VK_DOWN) {
            downpressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftpressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightpressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            WPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            APressed = false;
        }
        if (code == KeyEvent.VK_S) {
            SPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            DPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
}
