package game.game_logic.entity;

import game.game_logic.Type;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * 
 *  Projectile class which is a subclass of entity class and is shot by player.
 * 
 * 
 */
public class Projectile extends Entity {
    /*
     * 
     */
    public Type projectileType;
    BufferedImage rockImg;
    BufferedImage paperImg;
    BufferedImage scissorImg;

    /**
     * Constructor class for projectile.
     * @param px x coordinate for the projectile
     * @param py y coordinate for the projectile
     * @param pdirection the direction which the projectile has to move
     * @param type the type of projectile used
     * @param rockImg buffered image of the rock projectile
     * @param paperImg buffered image of the paper projectile
     * @param scissorImg  buffered image of the scissors projectile
     */
    public Projectile(int px, int py, String pdirection, Type type, BufferedImage rockImg, 
        BufferedImage paperImg, BufferedImage scissorImg) {
        this.projectileType = type;
        this.x = px;
        this.y = py;
        this.direction = pdirection;
        this.hitbox = new Rectangle(x + 8, y + 8, 32, 32); 
        this.speed = 12;
        this.alive = true;
        this.rockImg = rockImg;
        this.paperImg = paperImg;
        this.scissorImg = scissorImg;
    }

    @Override
    public void update() {
        switch (direction) {
            case "up":
                y -= speed;
                break;
            case "down":
                y += speed;
                break;
            case "right":
                x += speed;
                break;
            case "left":
                x -= speed;
                break;
            default:
                break;
        }
        this.hitbox = new Rectangle(x + 8, y + 8, 32, 32); 
        if (768 < this.x || this.x < 0 || 432 < this.y || this.y < 0) {
            this.alive = false;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        switch (projectileType) {
            case scissors:
                g.drawImage(scissorImg, x, y, 32, 32, null);
                break;
            case rock:
                g.drawImage(rockImg, x, y, 32, 32, null);
                break;
            case paper:
                g.drawImage(paperImg, x, y, 32, 32, null);
                break;
            default:
                break;
        }

    }

    @Override
    public void onCollision(Entity e) {
        if (e instanceof Enemy) {
            this.alive = false;
        }
    }
}
