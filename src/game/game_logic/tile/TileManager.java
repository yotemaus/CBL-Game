package src.game.game_logic.tile;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import src.game.ui.GamePanel;

public class TileManager {

    GamePanel panel;
    Tile[] tile;

    public TileManager(GamePanel panel) {

        this.panel = panel;

        tile = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/Grass_Middle.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/Path_Tile_left.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/tiles/Path_Tile_right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, panel.tileSize, panel.tileSize, null);
    }
    
}
