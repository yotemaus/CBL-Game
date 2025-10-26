package game.game_logic.entity;

import game.game_logic.Type;
import game.game_logic.input.KeyHandler;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Projectile manager creates new projectiles when needed and loads the images.
 */
public class ProjectileManager {
    private KeyHandler keyH;
    private Player player;
    private BufferedImage rockImg;
    private BufferedImage paperImg;
    private BufferedImage scissorImg;
    
    /**
     * Constructor for the class, loads instance variables and loads the images.
     * @param kh Keyhandler so the class knows which direction to create new projectiles
     * @param pl Player class so the coordinates where the projectile needs to be spawned 
     * 
     */
    public ProjectileManager(KeyHandler kh, Player pl) {
        this.keyH = kh;
        this.player = pl;
        loadProjectileImg();
    }

    private void loadProjectileImg() {
        try {
            rockImg = ImageIO.read(getClass().getResourceAsStream("/sprites/projectiles/rock.png"));
            scissorImg = ImageIO.read(getClass().getResourceAsStream(
                "/sprites/projectiles/scissors.png"));
            paperImg = ImageIO.read(getClass().getResourceAsStream(
                "/sprites/projectiles/paper.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new Projectile.
     * @param pType the type of projectile that needs to be created.
     * @return an object of the projectile class so it can be added to the entity list
     */
    public Projectile newProjectile(Type pType) {
        
        if (keyH.uppressed) {

            return new Projectile(player.x, player.y, "up", pType, 
            rockImg, paperImg, scissorImg);
        }
        if (keyH.downpressed) {

            return new Projectile(player.x, player.y, "down", pType,
            rockImg, paperImg, scissorImg);
        }
        if (keyH.leftpressed) {

            return new Projectile(player.x, player.y, "left", pType, 
            rockImg, paperImg, scissorImg);
        }
        if (keyH.rightpressed) {

            return new Projectile(player.x, player.y, "right", pType, 
            rockImg, paperImg, scissorImg);
        } else {
            return null;
        }
    }
}