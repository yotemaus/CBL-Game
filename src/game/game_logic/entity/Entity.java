package src.game.game_logic.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public abstract class Entity {

    public int x;
    public int y;
    public int speed;
    private BufferedImage image;

    public Entity() {}

    public Entity(int x , int y , String imagepath, int s) {

        this.x = x;
        this.y = y;

        try {
            this.image = ImageIO.read(getClass().getResource(imagepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {}
    
    public void draw(Graphics2D g2) {}

}
