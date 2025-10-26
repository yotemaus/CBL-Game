package game.ui;

import game.game_logic.entity.Player;
import game.game_logic.type;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Hud {

    private GamePanel panel;
    private BufferedImage scissorImg;
    private BufferedImage rockImg;
    private BufferedImage paperImg;
    private BufferedImage squareImg;
    private BufferedImage heartImg;
    private int playerhealth;
    HashMap<type, int[]> typemap = new HashMap<>();
    int[] squarepos = new int[2];

    public Hud(GamePanel panel) {
        this.panel = panel;
        this.scissorImg = imgHelper("/sprites/projectiles/scissors.png");
        this.rockImg = imgHelper("/sprites/projectiles/rock.png");
        this.paperImg = imgHelper("/sprites/projectiles/paper.png");
        this.squareImg = imgHelper("/ui/square.png");
        this.heartImg = imgHelper("/ui/heart.png");
        typemap.put(type.rock, new int[] {panel.screenWidth - 100, 10});
        typemap.put(type.paper, new int[] {panel.screenWidth - 150, 10});
        typemap.put(type.scissors, new int[] {panel.screenWidth - 50, 10});
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

    public void drawPause(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 100));
        g2.drawString("PAUSED", 180,  panel.screenHeight / 2);
        g2.setFont(new Font("Arial", Font.PLAIN, 20))   ;
        g2.drawString("Press ESC to resume.", 280,  panel.screenHeight / 2 + 30);
    }

    public void update(type playerType, int playerhealth) {
        this.squarepos = typemap.get(playerType);
        this.playerhealth = playerhealth;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(squareImg, squarepos[0], squarepos[1], 48, 48, null);
        g2.drawImage(scissorImg,
              panel.screenWidth - 50, 10, 48, 48, null);
        g2.drawImage(rockImg,
              panel.screenWidth - 100, 10, 48, 48, null);
        g2.drawImage(paperImg,
              panel.screenWidth - 150, 10, 48, 48, null);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.drawString("Rounds Cleared: " + Player.score, 270, 40);
        for (int i = 1; i <= this.playerhealth; i++) {
            g2.drawImage(heartImg, i * 50, 10, 48, 48, null);
        }
    }
}
