package game.game_logic;
import game.game_logic.entity.*;
import game.game_logic.input.*;

public class ProjectileManager {
    private KeyHandler keyH;
    private Player player;
    private String direction;


    public ProjectileManager(KeyHandler kh , Player pl) {
        this.keyH = kh;
        this.player = pl;
    }

    public Projectile newProjectile(type Ptype) {
        
        if (keyH.uppressed) {

            return new Projectile(player.x , player.y , "up" , Ptype);
        }
        if (keyH.downpressed) {

            return new Projectile(player.x , player.y , "down" , Ptype);
        }
        if (keyH.leftpressed) {

            return new Projectile(player.x , player.y , "left" , Ptype);
        }
        if (keyH.rightpressed) {

            return new Projectile(player.x , player.y , "right" , Ptype);
        } else {
            return null;
        }
        
        
    }

}