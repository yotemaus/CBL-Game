package game.game_logic.tile;

import java.awt.image.BufferedImage;

/**
 * An abstract class for background tiles. May or may not be collidable.
 */
public class Tile {
    public BufferedImage image;
    public boolean collision = false;
    
}