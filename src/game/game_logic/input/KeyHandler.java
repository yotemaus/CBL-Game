package game.game_logic.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import game.main.GameLoop;

/**
 * Allows the game to monitor keyboard inpots for the player to interact with the game.
 */
public class KeyHandler implements KeyListener {

    public boolean wPressed;
    public boolean sPressed;
    public boolean aPressed;
    public boolean dPressed;
    public boolean uppressed;
    public boolean downpressed; 
    public boolean rightpressed; 
    public boolean leftpressed; 
    public boolean spacepressed;
    public boolean spacetapped;
    public boolean escPressed;
    public boolean rPressed;
    
    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            sPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            dPressed = true;
        }
        if (code == KeyEvent.VK_UP) {
            uppressed = true;
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
        if (code == KeyEvent.VK_SPACE) {
            spacepressed = true;
        }
        if (code == KeyEvent.VK_ESCAPE) {
            escPressed = !escPressed; 
        }
        if (code == KeyEvent.VK_R) {
            rPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            wPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            aPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            sPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            dPressed = false;
        }
        if (code == KeyEvent.VK_UP) {
            uppressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downpressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftpressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightpressed = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            if (spacepressed) {
                spacetapped = true;
            }
            spacepressed = false;
        }
        if (code == KeyEvent.VK_R) {
            rPressed = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
