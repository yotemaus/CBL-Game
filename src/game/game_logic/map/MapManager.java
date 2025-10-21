package game.game_logic.map;

import game.game_logic.entity.Player;
import game.ui.GamePanel;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import game.game_logic.tile.TileManager;

/**
 * Cheks players position to see if it is out of bounds, then loads new map.
 */
public class MapManager {
    
    Player player;
    GamePanel panel;
    int currentX;
    int currentY;
    TileManager tileM;

    private String[][] world;

    public MapManager(Player player, GamePanel panel, TileManager tileM) {
        this.player = player;
        this.panel = panel; 
        this.currentX = 0;
        this.currentY = 0;
        this.tileM = tileM;
    }

    private String exitDirection() {

        String exitDirection = ""; 
        int playerRight = player.x + panel.tileSize;
        int playerBottom = player.y + panel.tileSize;

        if (player.x >= panel.screenWidth) {
            exitDirection = "RIGHT";
        } else if (playerRight <= 0) {
            exitDirection = "LEFT";
        } else if (playerBottom <= 0) {
            exitDirection = "UP";
        } else if (player.y >= panel.screenHeight) {
            exitDirection = "DOWN";
        }
        
        return exitDirection;
    }

    private String switchMap() {
    
        boolean playerOffScreen = player.x >= panel.screenWidth 
            || player.x + panel.tileSize <= 0
            || player.y + panel.tileSize <= 0 
            || player.y >= panel.screenHeight;

        int newX = 0;
        int newY = 0;

        if (playerOffScreen) {
            switch (exitDirection()) {
                case ("RIGHT"):
                    newX = currentX + 1;
                    player.x = player.x - panel.screenWidth;
                    break;
                case ("LEFT"):
                    newX = currentX - 1;
                    player.x = player.x + panel.screenWidth;
                    break;
                case ("UP"):
                    newY = currentY + 1;
                    player.y = player.y + panel.screenHeight;
                    break;
                case ("DOWN"):
                    newY = currentY - 1;
                    player.y = player.y - panel.screenHeight;
                    break;
                default: { };
            }
            currentX = newX;
            currentY = newY;
            return "/maps/" + newX + "_" + newY + ".txt";
        }
        return "/maps/" + currentX + "_" + currentY + ".txt";
    }

    public void updateMap() {

        String currentPath = "/maps/" + currentX + "_" + currentY + ".txt";
        String newPath = switchMap();

        if (!(currentPath.equals(newPath))) {
            System.out.println(newPath);
            tileM.loadMap(newPath);
        }
    }
} 