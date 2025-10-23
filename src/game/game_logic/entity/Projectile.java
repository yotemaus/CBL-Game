package game.game_logic.entity;

import game.game_logic.*;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.crypto.ExemptionMechanism;


public class Projectile extends Entity{

    String direction;
    public type projectiletype;

    public Projectile(int px, int py, String pdirection, type type) {
        this.projectiletype = type;
        this.x = px;
        this.y = py;
        this.direction = pdirection;
        this.hitbox = new Ellipse2D.Double(x + 8, y + 8, 16, 16); 
        this.speed = 12;
        this.alive = true;
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
        this.hitbox = new Ellipse2D.Double(x + 8, y + 8, 16, 16); 
        if (768<this.x || this.x<0) {
            this.alive =false;
        }
        if (432<this.y || this.y<0)  {
            this.alive = false;
        }
    }
    @Override
    public void draw(Graphics2D g) {
        g.drawOval(x, y, 16, 16);
    }
    @Override
    public void onCollision(Entity e) {
        if (e instanceof Enemy) {
            Enemy enemy = (Enemy) e;
            if (weakto.get(enemy.enemType) == this.projectiletype) {
                this.alive = false;
            }

            
        }
    }

}
