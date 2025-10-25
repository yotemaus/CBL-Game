package game.ui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;


import game.game_logic.type;


import javax.imageio.ImageIO;

public class Hud {
    private GamePanel panel;
    private BufferedImage scissorImg;
    private BufferedImage rockImg;
    private BufferedImage paperImg;
    private BufferedImage squareImg;
    HashMap<type,int[]> typemap = new HashMap<>();
    int[] squarepos = new int[2];
    public Hud(GamePanel panel) {
        this.panel = panel;
        this.scissorImg = imgHelper("/sprites/projectiles/scissors.png");
        this.rockImg = imgHelper("/sprites/projectiles/rock.png");
        this.paperImg = imgHelper("/sprites/projectiles/paper.png");
        this.squareImg = imgHelper("/ui/square.png");
        typemap.put(type.rock, new int[] {panel.screenWidth - 100, 10});
        typemap.put(type.paper, new int[] {panel.screenWidth - 50, 10});
        typemap.put(type.scissors, new int[] {panel.screenWidth - 150, 10});
    }

    /**
     * Helpern function for getting the enemy sprite.
     * @param filePath path to the image file.
     * @return buffered image of enemy sprite.
     */
    public BufferedImage imgHelper(String filePath) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void update(type playerType) {
        this.squarepos = typemap.get(playerType);
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(squareImg, squarepos[0],squarepos[1],48,48,null);
        g2.drawImage(scissorImg,
              panel.screenWidth-50, 10, 48,48, null);
        g2.drawImage(rockImg,
              panel.screenWidth-100, 10, 48,48, null);
        g2.drawImage(paperImg,
              panel.screenWidth-150, 10, 48,48, null);
    }
}
