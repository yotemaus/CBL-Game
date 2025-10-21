package game.game_logic.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * An abstract class that acts as a template for the player, enemies and interactable objects.
 * Each interactable objects has a position x, y, and is repeatedly updated by the GameState
 * and GameLoop.
 */
public abstract class Entity {

    public int x;
    public int y;
    public int speed;
    public Shape hitbox = new Rectangle(x,y,16,16);
    public boolean alive = true;
    public BufferedImage front;
    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage up3;
    public BufferedImage up4;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage down3;
    public BufferedImage down4;
    public BufferedImage left1;
    public BufferedImage left2;
    public BufferedImage left3;
    public BufferedImage left4;
    public BufferedImage right1;
    public BufferedImage right2;
    public BufferedImage right3;
    public BufferedImage right4;

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Entity() {}

    //TODO; Find out whether this is necessary, as this is an abstract class 

    /* constructor unneeded */

    public void update() {}
    
    public void draw(Graphics2D g2) {}

    public boolean collidesWith(Entity e) {
        return this.hitbox.getBounds2D().intersects(e.hitbox.getBounds2D());
    }

    public void onCollision(Entity e) {

    }

    /**
     * Helpern function for getting the enemy sprite.
     * @param filePath path to the image file.
     * @return buffered image of enemy sprite.
     */
    public BufferedImage imgHelper(String filePath) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
