package game.game_logic;
import game.game_logic.entity.*;
import game.game_logic.input.*;
public class ProjectileManager {
    private KeyHandler keyH;
    private Player player;

    public ProjectileManager(KeyHandler kh , Player pl) {
        this.keyH = kh;
        this.player = pl;
    }
    public Projectile newProjectile() {
        if (keyH.uppressed) {
            keyH.uppressed = false;
            return new Projectile(this.player.x, this.player.y, "up");

        }
        if (keyH.downpressed) {
            keyH.downpressed = false;
            return new Projectile(this.player.x, this.player.y, "down");
        }
        if (keyH.leftpressed) {
            keyH.leftpressed = false;
            return new Projectile(this.player.x, this.player.y, "left");
        }
        if (keyH.rightpressed) {
            keyH.rightpressed = false;
            return new Projectile(this.player.x, this.player.y, "right");
        }
        return null;
    }

}