package game.game_logic.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.lang.Math;

public class Enemy extends Entity {
    private Player player;
    public int health;
    public boolean alive;
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
            alive = false;
        }
        this.hitbox = new Rectangle(this.x,this.y,16,16);

    }   
    private int[] destination;

    public Enemy(int px, int py, Player player) {
        this.x = px;
        this.y = py;
        this.player = player;
        this.speed = 2;
        this.hitbox=new Rectangle(px,py,16,16);
    }


    @Override
    public void draw(Graphics2D g) {
        g.drawRect(x, y, 16, 16);
        
    }
}
