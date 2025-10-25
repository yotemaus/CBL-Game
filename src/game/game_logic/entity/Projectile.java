package game.game_logic.entity;

import game.game_logic.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Projectile extends Entity {
    
    public type projectiletype;
    BufferedImage rockImg;
    BufferedImage paperImg;
    BufferedImage scissorImg;

    public Projectile(int px, int py, String pdirection, type type, BufferedImage rockImg, 
        BufferedImage paperImg, BufferedImage scissorImg) {
        this.projectiletype = type;
        this.x = px;
        this.y = py;
        this.direction = pdirection;
        this.hitbox = new Ellipse2D.Double(x + 8, y + 8, 32, 32); 
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
        this.hitbox = new Ellipse2D.Double(x + 8, y + 8, 32, 32); 
        if (768 < this.x || this.x < 0) {
            this.alive = false;
        }
        if (432 < this.y || this.y < 0) {
            this.alive = false;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        switch (projectiletype) {
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
