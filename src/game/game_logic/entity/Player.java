package src.game.game_logic.entity;

import java.awt.*;
import src.game.game_logic.input.KeyHandler;
import src.game.ui.GamePanel;


public class Player extends Entity {

    private final GamePanel panel;
    private final KeyHandler keyH;

    public Player(GamePanel panel, KeyHandler keyH) {
        this.panel = panel;
        this.keyH = keyH;
        setDefaultValues();
    }

    private void setDefaultValues() {
        x = panel.screenWidth / 2 - panel.tileSize / 2;
        y = panel.screenHeight / 2 - panel.tileSize / 2;
        speed = 4;
    }

    @Override
    public void update() {
        if (keyH.upPressed) {
            y -= speed;
        } else if (keyH.downPressed) {
            y += speed;
        } else if (keyH.leftPressed) {
            x -= speed;
        } else if (keyH.rightPressed) {
            x += speed;
        }

    }

    @Override
    public void draw(Graphics2D g2) {

        System.out.println("Player.draw at " + x + "," + y + " size=" + panel.tileSize);

        g2.setColor(Color.white);

        g2.fillRect(x, y, panel.tileSize, panel.tileSize);

    }
}

