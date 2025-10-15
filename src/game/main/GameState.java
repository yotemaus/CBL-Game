package src.game.main;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import src.game.game_logic.entity.Entity;
import src.game.game_logic.entity.Player;
import src.game.game_logic.input.KeyHandler;
import src.game.ui.GamePanel;

public class GameState {

    private final Player player;
    private final List<Entity> entities = new ArrayList<>();

    public GameState(GamePanel panel, KeyHandler keyH) {
        this.player = new Player(panel, keyH);
        entities.add(player);
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public void render(Graphics2D g2) {
        for (Entity e : entities) {
            e.draw(g2);
        }  
    }
}