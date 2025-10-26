package game.game_logic.map;

import game.game_logic.entity.EnemyManager;
import game.game_logic.entity.Player;
import game.game_logic.tile.TileManager;
import game.ui.GamePanel;
import java.util.Map;

/**
 * Cheks players position to see if it is out of bounds, then loads new map.
 */
public class MapManager {
    
    Player player;
    GamePanel panel;
    public int currentMapId;
    public TileManager tileM;
    EnemyManager enemyM;

    private static final Map<Integer, String> MAP_ID = Map.of(
        0, "/maps/-1_1.txt",
        1, "/maps/0_1.txt",
        2, "/maps/1_1.txt",
        3, "/maps/-1_0.txt",
        4, "/maps/0_0.txt",
        5, "/maps/1_0.txt",
        6, "/maps/-1_-1.txt",
        7, "/maps/0_-1.txt",
        8, "/maps/1_-1.txt"
    );
    private static final Integer[][] MAP_CONNECTIONS = {
        // Order: {up, down, left, right - null for no connection}
        {null, 3, null, 1},
        {null, 4, 0, 2},
        {null, 5, 1, null},
        {0, 6, null, 4},
        {1, 7, 3, 5},
        {2, 8, 4, null},
        {3, null, null, 7},
        {4, null, 6, 8},
        {5, null, 7, null}
    };
    
    /**
     * Constructor for the map manager class instantiates the player panel tile and enemy manager.
     * @param player player class so the player position can be used to adjust map
     * @param panel panel class for the size to determine the bounds for the player
     * @param tileM tile manager to load the tiles for each map
     * @param enemyM loads the enemies of the current map into the enemy manager
     */
    public MapManager(Player player, GamePanel panel, TileManager tileM, EnemyManager enemyM) {
        this.player = player;
        this.panel = panel; 
        this.currentMapId = 4;
        this.tileM = tileM;
        this.enemyM = enemyM;
    }

    /**
     * adds a map to cleared maps if all the enemies are dead.
     */
    public void addClearedMap() {
        if (!enemyM.clearMaps.contains(currentMapId) 
            && enemyM.enemiesLoaded.isEmpty()) {
            enemyM.clearMaps.add(currentMapId);
        }
    }

    private String checkExitDirection() {

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

    private Integer switchMap() {
    
        boolean playerOffScreen = player.x >= panel.screenWidth 
            || player.x + panel.tileSize <= 0
            || player.y + panel.tileSize <= 0 
            || player.y >= panel.screenHeight;

        int newMapId = 0;

        if (playerOffScreen) {
            switch (checkExitDirection()) {
                case ("RIGHT"):
                    newMapId = MAP_CONNECTIONS[currentMapId][3];
                    player.x = player.x - panel.screenWidth;
                    break;
                case ("LEFT"):
                    newMapId = MAP_CONNECTIONS[currentMapId][2];
                    player.x = player.x + panel.screenWidth;
                    break;
                case ("UP"):
                    newMapId = MAP_CONNECTIONS[currentMapId][0];
                    player.y = player.y + panel.screenHeight;
                    break;
                case ("DOWN"):
                    newMapId = MAP_CONNECTIONS[currentMapId][1];
                    player.y = player.y - panel.screenHeight;
                    break;
                default: {
                    break;
                }
            }
            return newMapId;
        }
        return currentMapId;
    }

    /**
     * updates the map if the player moves out of bounds.
     */
    public void updateMap() {

        int newMapId = switchMap();

        if (currentMapId != newMapId) {
            tileM.loadMap(MAP_ID.get(newMapId));
            enemyM.loadEnemiesOnMap(newMapId);
            enemyM.resetClearMaps();
            currentMapId = newMapId;
        }
    }
} 