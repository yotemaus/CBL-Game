package game.game_logic;

import game.game_logic.entity.Entity;
import java.util.List;
public class CollisionManager {
    public void checkCollisions(List<Entity> entities) {
        for (int i = 0;i < entities.size(); i++ ) {
            Entity e1 = entities.get(i);
            for (int j = i+1; j<entities.size(); j++) {
                Entity e2 = entities.get(j);
                if (e1.CollidesWith(e2)) {
                    e1.OnCollision(e2);
                    e2.OnCollision(e1);
                }
            }
        }
    }
}
