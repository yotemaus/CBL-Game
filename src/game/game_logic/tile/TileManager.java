package game.game_logic.tile;

import game.ui.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 * Creates an array of tile sprites to assemble the background of each screen using a text file.
 */
public class TileManager {

    GamePanel panel;
    Tile[] tile;
    int[][] mapTileNum;

    /**
     * Constructor.
     * @param panel the GamePanel where the tiles need to be drawn.
     */
    public TileManager(GamePanel panel) {

        this.panel = panel;

        tile = new Tile[10];
        mapTileNum = new int[panel.maxScreenRow][panel.maxScreenCol];

        getTileImage();
        loadMap();
    }

    /**
     * Stores tile images in an array for later use.
     */
    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(
                "/Tiles/Grass_Middle.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(
                "/Tiles/Path_Tile_left.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream(
                "/Tiles/Path_Tile_right.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream(
                "/Tiles/Path_Tile_right.png"));  
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the text file with the map template where numbers represent array indexes.
     * 
     */
    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            int col = 0;

            while(col < panel.maxScreenCol && row < panel.maxScreenRow) {
                
                String line = br.readLine();
                //Parse row of map into integers
                while(col < panel.maxScreenCol) {
                    
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[row][col] = num;
                    col++;
                }
                if (col == panel.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Draws each tile on the gamepanel.
     * @param g2 Graphics2D object.
     */
    public void draw(Graphics2D g2) {
        
        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        while (row < panel.maxScreenRow && col < panel.maxScreenCol) {

            int tileNum = mapTileNum[row][col];
            g2.drawImage(tile[tileNum].image, x, y, panel.tileSize, panel.tileSize, null);
            col++;
            x += panel.tileSize;

            if (col == panel.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += panel.tileSize;
            }

        }
    }
    
}
