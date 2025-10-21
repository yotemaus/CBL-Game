package game.main;

import game.game_logic.ProjectileManager;
import game.game_logic.collision.CollisionManager;
import game.game_logic.entity.Enemy;
import game.game_logic.entity.Entity;
import game.game_logic.entity.Player;
import game.game_logic.entity.Projectile;
import game.game_logic.input.KeyHandler;
import game.ui.GamePanel;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Contains an array of every entiry to so each can be sequentially update once per frame.
 */
public class GameState {

    private final Player player;
    private final List<Entity> entities = new ArrayList<>();
    private final CollisionManager collisionManager;
    private final ProjectileManager projectileManager;
    List<Entity> removedEntities = new ArrayList<Entity>();

    /**
     * Constructor.
     * @param panel GamePanel to perform updates in
     * @param keyH KeyHandler to pass to player
     */
    public GameState(GamePanel panel, KeyHandler keyH) {
        this.player = new Player(panel, keyH);
        entities.add(player);
        entities.add(new Enemy(0, 0, player));
        this.collisionManager = new CollisionManager();

        this.projectileManager = new ProjectileManager(keyH, this.player);
    }

    /**
     * Update every entity in the array.
     */
    public void update() {
        collisionManager.checkCollisions(entities);
        for (Entity e : entities) {
            e.update();
            if (!(e.alive)) {
                removedEntities.add(e);
            }
        }
        Projectile newProjectile = projectileManager.newProjectile();
        if (newProjectile != null) {
            entities.add(newProjectile);
        }
        entities.removeAll(removedEntities);
        removedEntities.clear();

    }

    /**
     * Draw every entity in the list.
     * @param g2 Graphics2D object.
     */
    public void render(Graphics2D g2) {
        for (Entity e : entities) {
            e.draw(g2);
        }  
    }
}