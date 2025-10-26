package game.ui;

import game.game_logic.Type;
import game.game_logic.entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * Hud class for displaying health and weapon selection.
 */
public class Hud {

    private GamePanel panel;
    private BufferedImage scissorImg;
    private BufferedImage rockImg;
    private BufferedImage paperImg;
    private BufferedImage squareImg;
    private BufferedImage heartImg;
    private int playerhealth;
    HashMap<Type, int[]> typemap = new HashMap<>();
    int[] squarepos = new int[2];

    /**
     * COnstructor for the class instantiates the instance variable and loads the images.
     * @param panel parameter panel so the screeen width and height can be used.
     */
    public Hud(GamePanel panel) {
        this.panel = panel;
        this.scissorImg = imgHelper("/sprites/projectiles/scissors.png");
        this.rockImg = imgHelper("/sprites/projectiles/rock.png");
        this.paperImg = imgHelper("/sprites/projectiles/paper.png");
        this.squareImg = imgHelper("/ui/square.png");
        this.heartImg = imgHelper("/ui/heart.png");
        typemap.put(Type.rock, new int[] {panel.screenWidth - 100, 10});
        typemap.put(Type.paper, new int[] {panel.screenWidth - 150, 10});
        typemap.put(Type.scissors, new int[] {panel.screenWidth - 50, 10});
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

    /**
     *  Draws the game when its paused.
     * @param g2 graphics which has to be drawn on
     */
    public void drawPause(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 100));
        g2.drawString("PAUSED", 180,  panel.screenHeight / 2);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString("Press ESC to resume.", 280,  panel.screenHeight / 2 + 30);
    }

    /**
     *  Draws the game over screen.
     * 
     * @param g2 graphics which has to be drawn on
     */
    public void drawGameOver(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 100));
        g2.drawString("YOU DIED", 150,  panel.screenHeight / 2);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString("Press R to restart.", 310,  panel.screenHeight / 2 + 30);
    }

    /**
     * updates the hud.
     * @param playerType the player type so the selected weapon is displayed
     * @param playerhealth the player health so theh health is displayed
     */
    public void update(Type playerType, int playerhealth) {
        this.squarepos = typemap.get(playerType);
        this.playerhealth = playerhealth;
    }

    /**
     *  draws the hud on the gamepanel.
     * @param g2 the graphics where the hud is drawn on
     */
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
        g2.drawString("Rounds Cleared: " + Player.score, 260, 40);
        for (int i = 1; i <= this.playerhealth; i++) {
            g2.drawImage(heartImg, i * 50, 10, 48, 48, null);
        }
    }
}
