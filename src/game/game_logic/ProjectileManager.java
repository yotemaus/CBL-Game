package game.game_logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.game_logic.entity.*;
import game.game_logic.input.*;

public class ProjectileManager {
    private KeyHandler keyH;
    private Player player;
    private BufferedImage rockImg;
    private BufferedImage paperImg;
    private BufferedImage scissorImg;


    public ProjectileManager(KeyHandler kh , Player pl) {
        this.keyH = kh;
        this.player = pl;
        loadProjectileImg();
    }

    private void loadProjectileImg() {
        try {
            rockImg = ImageIO.read(getClass().getResourceAsStream("/sprites/projectiles/rock.png"));
            scissorImg = ImageIO.read(getClass().getResourceAsStream("/sprites/projectiles/scissors.png"));
            paperImg = ImageIO.read(getClass().getResourceAsStream("/sprites/projectiles/paper.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Projectile newProjectile(type Ptype) {
        
        if (keyH.uppressed) {

            return new Projectile(player.x , player.y , "up" , Ptype, 
            rockImg, scissorImg, paperImg);
        }
        if (keyH.downpressed) {

            return new Projectile(player.x , player.y , "down" , Ptype,
            rockImg, scissorImg, paperImg);
        }
        if (keyH.leftpressed) {

            return new Projectile(player.x , player.y , "left" , Ptype, 
            rockImg, scissorImg, paperImg);
        }
        if (keyH.rightpressed) {

            return new Projectile(player.x , player.y , "right" , Ptype, 
            rockImg, scissorImg, paperImg);
        } else {
            return null;
        }
    }
}