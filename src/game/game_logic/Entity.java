package src.game.game_logic;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;
public class Entity {
    public int x;
    public int y;
    public int speedx;
    public int speedy;
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
    void update() {
        x += speedx;
        y += speedy;
    }
    void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }

}
