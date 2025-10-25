package game.game_logic.entity;

import game.ui.GamePanel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import game.game_logic.type;

/**
 * Spawns enemies on pre-determined locations on each map.
 * Manages which enemies are loaded at which time.
 */
public class EnemyManager {

    private GamePanel gp;
    private Player player;
    private List<Integer> clearMaps = new ArrayList<>();
    public List<Enemy> enemiesLoaded = new ArrayList<>();

    private static final Map<Integer, String> ID_SPAWNS = Map.of(
        0, "/maps/spawn_positions/-1_1_spawns.txt",
        1, "/maps/spawn_positions/0_1_spawns.txt",
        2, "/maps/spawn_positions/1_1_spawns.txt",
        3, "/maps/spawn_positions/-1_0_spawns.txt",
        4, "/maps/spawn_positions/0_0_spawns.txt",
        5, "/maps/spawn_positions/1_0_spawns.txt",
        6, "/maps/spawn_positions/-1_-1_spawns.txt",
        7, "/maps/spawn_positions/0_-1_spawns.txt",
        8, "/maps/spawn_positions/1_-1_spawns.txt"
    );

    public EnemyManager(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
    }

    private int[][] parseSpawnMap(String path) {

        int[][] spawnPositions = new int[9][16];

        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            for (int row = 0; row < gp.maxScreenRow; row++) {

                String line = br.readLine();
                String[] numbers = line.split(" ");
                int col = 0;

                for (String letter : numbers) {
                    spawnPositions[row][col] = Integer.parseInt(letter);
                    col++;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spawnPositions;
    }

    public void loadEnemiesOnMap(int mapId) {
        if (!clearMaps.contains(mapId)) {

            int[][] spawnPositions = parseSpawnMap(ID_SPAWNS.get(mapId));
            enemiesLoaded.clear();

            int x = 0;
            int y = 0;

            for (int row = 0; row < spawnPositions.length; row++) {
                x = 0;
                for (int col = 0; col < spawnPositions[row].length; col++) {
                    if (spawnPositions[row][col] != 0) {
                        enemiesLoaded.add(new Enemy(x, y, player, type.rock));
                        System.out.println("Enemy spawned at" + x + y);
                    }
                    x += gp.tileSize;
                }
                y += gp.tileSize;
            }
        }
    }
}
