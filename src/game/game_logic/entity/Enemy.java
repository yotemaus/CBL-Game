package game.game_logic.entity;

import game.game_logic.type;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.lang.Math;


public class Enemy extends Entity {

    private Player player;
    public int health;
    public type enemType;
    public int onMap; //the map thie enemy is bound to
    private int[] destination;

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
        this.health = health;
        this.enemType = type;
        this.alive = true;
        this.x = px;
        this.y = py;
        this.player = player;
        this.speed = 2;
        this.hitbox = new Rectangle(px, py, 16, 16);
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawRect(x, y, 16, 16);
        
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
