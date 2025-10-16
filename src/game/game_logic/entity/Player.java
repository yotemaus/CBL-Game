package src.game.game_logic.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
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
        getPlayerImage();
    }

    private void setDefaultValues() {

        x = panel.screenWidth / 2 - panel.tileSize / 2;
        y = panel.screenHeight / 2 - panel.tileSize / 2;

        speed = 4;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/resources/sprites/player.jpg"));
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    private BufferedImage imgHelper(String filePath) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void getPlayerImage() {

        up1 = imgHelper("resources/sprites/player_D_walk_1.png");
        up2 = imgHelper("resources/sprites/player_D_walk_2.png");
        up3 = imgHelper("resources/sprites/player_D_walk_3.png");
        up4 = imgHelper("resources/sprites/player_D_walk_4.png");
        down1 = imgHelper("resources/sprites/player_S_walk_1.png");
        down2 = imgHelper("resources/sprites/player_S_walk_2.png");
        down3 = imgHelper("resources/sprites/player_S_walk_3.png");
        down4 = imgHelper("resources/sprites/player_S_walk_4.png");
        left1 = imgHelper("resources/sprites/player_A_walk_1.png");
        left2 = imgHelper("resources/sprites/player_A_walk_2.png");
        left3 = imgHelper("resources/sprites/player_A_walk_3.png");
        left4 = imgHelper("resources/sprites/player_A_walk_4.png");
        right1 = imgHelper("resources/sprites/player_D_walk_4.png");
        right2 = imgHelper("resources/sprites/player_D_walk_1.png");
        right3 = imgHelper("resources/sprites/player_D_walk_2.png");
        right4 = imgHelper("resources/sprites/player_D_walk_3.png");
    }

    @Override
    public void update() {
        if (keyH.upPressed) {
            y -= speed;
            direction = "up";
        } else if (keyH.downPressed) {
            y += speed;
            direction = "down";
        } else if (keyH.leftPressed) {
            x -= speed;
            direction = "left";
        } else if (keyH.rightPressed) {
            x += speed;
            direction = "right";
        }

    }

    @Override
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image up1;
                }
        }

    }
}

