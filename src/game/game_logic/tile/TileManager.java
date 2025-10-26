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

        tile = new Tile[28];
        mapTileNum = new int[panel.maxScreenRow][panel.maxScreenCol];

        getTileImage();
        loadMap("/maps/0_0.txt");
    }

    /**
     * Stores tile images in an array for later use.
     */
    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/Grass_Middle.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_left.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_right.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_top.png"));
                
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_bottom.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_BL_corner.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_BR_corner.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_TL_corner.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_TR_corner.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_up_left.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_up_right.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_down_left.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_down_right.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_texture_1.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_texture_2.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_texture_3.png"));

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/path/Path_Tile_center.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile0.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile1.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile2.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile3.png"));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile4.png"));
            tile[21].collision = true;
                
            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile5.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_tile7.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_corner0.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_corner1.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_corner2.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream(
                "/tiles/water/water_corner3.png"));
            tile[27].collision = true;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the text file with the map template where numbers represent array indexes.
     * 
     */
    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;
            int col = 0;

            while (col < panel.maxScreenCol && row < panel.maxScreenRow) {
                
                String line = br.readLine();
                String[] numbers = line.split(" ");
                //Parse row of map into integers
                while (col < panel.maxScreenCol) {
                    
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

    private int tileIndexAtPixel(int px, int py) {
        if (px < 0 || py < 0) {
            return -1;
        }
        int col = px / panel.tileSize;
        int row = py / panel.tileSize;
        if (row < 0 || col < 0 || row >= panel.maxScreenRow || col >= panel.maxScreenCol) { 
            return -1;
        }
        return mapTileNum[row][col];
    }

    public boolean isBlockedRect(int x, int y, int w, int h) {
        int[][] corners = {
            {x, y},
            {x + w - 1, y},
            {x, y + h - 1},
            {x + w - 1, y + h - 1}
        };

        for (int[] c : corners) {
            int idx = tileIndexAtPixel(c[0], c[1]);
            if (idx < 0 || idx >= tile.length) {
                return false;
            }
            if (tile[idx].collision) {
                return true;   
            }
        }
        return false;    
    }
}
