package game.game_logic.entity;

import game.game_logic.input.KeyHandler;
import game.ui.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * A character that is controllable by the player.
 */
public class Player extends Entity {

    private final GamePanel panel;
    private final KeyHandler keyH;

    /**
     * Constructor.
     * 
     * @param panel GamePanel do display the player in.
     * @param keyH KeyHandler to listen to player inpots to control the player.
     */
    public Player(GamePanel panel, KeyHandler keyH) {

        this.panel = panel;
        this.keyH = keyH;
        x = panel.screenWidth / 2 - panel.tileSize / 2;
        y = panel.screenHeight / 2 - panel.tileSize / 2;
        direction = "down";
        speed = 4;
        this.hitbox = new Rectangle(this.x,this.y,16,16);

        LoadPlayerImage();
    }

    

    private void LoadPlayerImage() {

        up1 = imgHelper("/sprites/player/player_W_walk_1.png");
        up2 = imgHelper("/sprites/player/player_W_walk_2.png");
        up3 = imgHelper("/sprites/player/player_W_walk_3.png");
        up4 = imgHelper("/sprites/player/player_W_walk_2.png");

        down1 = imgHelper("/sprites/player/player_S_walk_1.png");
        down2 = imgHelper("/sprites/player/player_S_walk_2.png");
        down3 = imgHelper("/sprites/player/player_S_walk_3.png");
        down4 = imgHelper("/sprites/player/player_S_walk_2.png");

        left1 = imgHelper("/sprites/player/player_A_walk_1.png");
        left2 = imgHelper("/sprites/player/player_A_walk_2.png");
        left3 = imgHelper("/sprites/player/player_A_walk_3.png");
        left4 = imgHelper("/sprites/player/player_A_walk_4.png");

        right1 = imgHelper("/sprites/player/player_D_walk_1.png");
        right2 = imgHelper("/sprites/player/player_D_walk_2.png");
        right3 = imgHelper("/sprites/player/player_D_walk_3.png");
        right4 = imgHelper("/sprites/player/player_D_walk_4.png");
    
    }

    /**
     * KeyHandler listens to which key is being pressed, player is moved in the corresponding
     * direction. Spritecounter is incremented to change the sprite as needed when walking to
     * create animation.
     */
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

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            spriteCounter++;

            if (spriteCounter > 6) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        this.hitbox = new Rectangle(this.x, this.y, 16, 16);
    }

    /**
     * Matches walking direction and current spriteNumber to the saved sprite png to create 
     * animation.
     */
    @Override
    public void draw(Graphics2D g2) {
        
        BufferedImage image = null;

        switch(direction) {
            
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up4;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down4;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left4;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right4;
                }
                break;
            }

        g2.drawImage(image, x, y, panel.tileSize, panel.tileSize, null);
    }
}