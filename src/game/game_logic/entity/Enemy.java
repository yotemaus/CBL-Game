package game.game_logic.entity;

import game.game_logic.type;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.Math;


public class Enemy extends Entity {

    private Player player;
    public int health;
    public type enemType;
    public int onMap; //the map thie enemy is bound toaaaa
    private int[] destination;
    private BufferedImage rockEnemy = imgHelper("/sprites/projectiles/rock.png");
    private BufferedImage paperEnemy = imgHelper("/sprites/projectiles/paper.png");
    private BufferedImage scissorEnemy = imgHelper("/sprites/projectiles/scissors.png");
    public static int hpMultiplier = 1;

    @Override
    public void update() {
            this.destination = new int[] {player.x, player.y};
        if (Math.floorDiv(x, 3) > Math.floorDiv(destination[0], 3)) {
            x -= speed;
        } else {
            x += speed;
        }
        if (Math.floorDiv(y, 3) < Math.floorDiv(destination[1], 3)) {
            y += speed;
        } else {
            y -= speed;
        }
        if (health == 0) {
            this.alive = false;
        }
        this.hitbox = new Rectangle(this.x, this.y, 16, 16);
    }   

    public Enemy(int px, int py, Player player, type type, int health) {
        this.health = health * hpMultiplier;
        this.enemType = type;
        this.alive = true;
        this.x = px;
        this.y = py;
        this.player = player;
        this.speed = 1;
        this.hitbox = new Rectangle(px, py, 16, 16);
    }

    @Override
    public void draw(Graphics2D g) {
        switch (this.enemType) {
            case rock:
                g.drawImage(rockEnemy,  x, y,48,48,null);
                break;
            case paper:
                g.drawImage(paperEnemy,  x, y,48,48,null);
                break;
            case scissors:
                g.drawImage(scissorEnemy,  x, y,48,48,null);
                break;
        
            default:
                break;
        }
        
    }

    @Override
    public void onCollision(Entity e) {
        if (e instanceof Projectile) {
            Projectile proj = (Projectile) e;
            if (weakto.get(this.enemType) == proj.projectiletype) {
                this.health--;
            }
        }
        if (e instanceof Player) {
            this.alive = false;
        }
    }
}
