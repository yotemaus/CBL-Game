package src.game.game_logic.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            System.out.println("W pressed");
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            System.out.println("W released");
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    
}
