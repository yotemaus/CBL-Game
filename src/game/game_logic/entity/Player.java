package src.game.game_logic.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import src.game.game_logic.input.KeyHandler;
import src.game.ui.GamePanel;


public class Player extends Entity {

    private final GamePanel panel;
    private final KeyHandler keyH;
    private BufferedImage image;

    public Player(GamePanel panel, KeyHandler keyH) {
        this.panel = panel;
        this.keyH = keyH;
        setDefaultValues();
    }

    private void setDefaultValues() {
        x = panel.screenWidth / 2 - panel.tileSize / 2;
        y = panel.screenHeight / 2 - panel.tileSize / 2;
        speed = 4;
        System.out.println(getClass().getResourceAsStream("/src/resources/sprites/player.jpg"));

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/player.jpg"));
        } catch (IOException e) {
            System.out.println("file not found");
        }
    
        
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
        /**System.out.println("Player.draw at " + x + "," + y + " size=" + panel.tileSize);*/
        g2.drawImage(image, null, x, y);



    }
}

