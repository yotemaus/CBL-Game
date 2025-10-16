package game.game_logic.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public abstract class Entity {

    public int x;
    public int y;
    public int speed;

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

    public Entity(int x , int y , String imagepath, int s) {

        this.x = x;
        this.y = y;

        try {
            this.front = ImageIO.read(getClass().getResource(imagepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {}
    
    public void draw(Graphics2D g2) {}

}
