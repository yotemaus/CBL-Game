package game.main;

import game.game_logic.collision.CollisionManager;
import game.game_logic.entity.Enemy;
import game.game_logic.entity.EnemyManager;
import game.game_logic.entity.Entity;
import game.game_logic.entity.Player;
import game.game_logic.entity.Projectile;
import game.game_logic.entity.ProjectileManager;
import game.game_logic.input.KeyHandler;
import game.game_logic.map.MapManager;
import game.ui.GamePanel;
import game.ui.Hud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains an array of every entiry to so each can be sequentially update once per frame.
 */
public class GameState {

    private final Player player;
    private final GamePanel panel;
    private final List<Entity> entities = new ArrayList<>();
    private final CollisionManager collisionManager;
    private final MapManager mapManager;
    private final ProjectileManager projectileManager;
    private final EnemyManager enemyManager;
    private final KeyHandler keyH;
    private final Hud hud;
    List<Entity> removedEntities = new ArrayList<Entity>();
    private final int attackCdFrames = 30;
    private int cooldownCounter = 0;
    private boolean paused = false;

    /**
     * Constructor.
     * @param panel GamePanel to perform updates in
     * @param keyH KeyHandler to pass to player
     */
    public GameState(GamePanel panel, KeyHandler keyH) {
        this.panel = panel;
        this.player = new Player(panel, keyH);
        this.keyH = keyH;
        entities.add(player);
        this.collisionManager = new CollisionManager();
        this.projectileManager = new ProjectileManager(keyH, player);
        this.enemyManager = new EnemyManager(panel, player);
        this.mapManager = new MapManager(player, panel, panel.tileM, enemyManager);
        this.hud = new Hud(panel);
    }

    /**
     * Update every entity in the array.
     */
    public void update() {

        if (keyH.escPressed) {
            return;
        }

        for (Entity e : entities) {
            e.update();
            if (!(e.alive)) {
                removedEntities.add(e);
            }
        }

        for (Entity e : enemyManager.enemiesLoaded) {
            e.update();
            if (!e.alive) {
                if (e instanceof Enemy) {
                    player.score++;
                }
                removedEntities.add(e);
            }
        }

        if (!player.isShooting) {
            Projectile newProjectile = projectileManager.newProjectile(player.playerType);
            if (newProjectile != null) {
                entities.add(newProjectile);
                player.isShooting = true;
                cooldownCounter = attackCdFrames;
            }
        }
        if (cooldownCounter > 0) {
            cooldownCounter--;
        } else if (cooldownCounter == 0 ) {
            player.isShooting = false;
        }

        List<Entity> collidables = new ArrayList<>(entities);
        collidables.addAll(enemyManager.enemiesLoaded);
        collisionManager.checkCollisions(collidables);

        entities.removeAll(removedEntities);
        enemyManager.enemiesLoaded.removeIf(e -> removedEntities.contains(e) || !e.alive);
        removedEntities.clear();

        mapManager.updateMap();
        hud.update(player.playerType, player.health);
    }

    /**
     * Draw every entity in the list.
     * @param g2 Graphics2D object.
     */
    public void render(Graphics2D g2) {

        for (Entity e : entities) {
            e.draw(g2);
        }
        for (Entity e : enemyManager.enemiesLoaded) {
            e.draw(g2);
        }
        hud.draw(g2); 
        
        if (keyH.escPressed) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 100));
            g2.drawString("PAUSED", 180,  panel.screenHeight / 2);
            g2.setFont(new Font("Arial", Font.PLAIN, 20));
            g2.drawString("Press ESC to resume.", 280,  panel.screenHeight / 2 + 30);
            //g2.drawString("Health: " + player.health, 20, 60);
        }
    }
}    