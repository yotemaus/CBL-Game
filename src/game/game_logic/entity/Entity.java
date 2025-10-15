package src.game.game_logic.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public abstract class Entity {

    public int x;
    public int y;
    public int speedX;
    public int speedY;
    private BufferedImage image;

    public Entity(int x , int y , String imagepath, int s) {

        this.x = x;
        this.y = y;

        try {
            this.image = ImageIO.read(getClass().getResource(imagepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void update() { }

    void draw(Graphics g) {}

}
