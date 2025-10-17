package game.main;

import game.game_logic.entity.Entity;
import game.game_logic.entity.Player;
import game.game_logic.input.KeyHandler;
import game.ui.GamePanel;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains an array of every entiry to so each can be sequentially update once per frame.
 */
public class GameState {

    private final Player player;
    private final List<Entity> entities = new ArrayList<>();

    /**
     * Constructor.
     * @param panel GamePanel to perform updates in
     * @param keyH KeyHandler to pass to player
     */
    public GameState(GamePanel panel, KeyHandler keyH) {
        this.player = new Player(panel, keyH);
        entities.add(player);
    }

    /**
     * Update every entity in the array.
     */
    public void update() {
        for (Entity e : entities) {
            e.update();
        }
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