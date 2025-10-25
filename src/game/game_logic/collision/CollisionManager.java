package game.game_logic.collision;

import game.game_logic.entity.Entity;
import java.util.List;

/**
 * Detects if the player is colliding with a collidable tile or entity.
 */
public class CollisionManager {

    /**
     * Checks all entities to see if they are colliding with another entity.
     * @param entities array of all entities from GameState.
     */
    public void checkCollisions(List<Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            Entity e1 = entities.get(i);
            for (int j = i + 1; j < entities.size(); j++) {
                Entity e2 = entities.get(j);
                if (e1.collidesWith(e2)) {
                    e1.onCollision(e2);
                    e2.onCollision(e1);
                }
            }
        }

        
    }
}
