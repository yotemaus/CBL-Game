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
import java.util.Random;
import java.util.Set;

/**
 * Spawns enemies on pre-determined locations on each map.
 * Manages which enemies are loaded at which time.
 */
public class EnemyManager {

    private GamePanel gp;
    private Player player;
    public List<Integer> clearMaps = new ArrayList<>();
    public List<Entity> enemiesLoaded = new ArrayList<>();
    private Random random = new Random();
    private type[] types = {type.rock, type.paper, type.scissors};

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
        enemiesLoaded.clear();
        if (!clearMaps.contains(mapId)) {

            int[][] spawnPositions = parseSpawnMap(ID_SPAWNS.get(mapId));

            int x = 0;
            int y = 0;

            for (int row = 0; row < spawnPositions.length; row++) {
                x = 0;
                for (int col = 0; col < spawnPositions[row].length; col++) {
                    if (spawnPositions[row][col] != 0) {
                        enemiesLoaded.add(new Enemy(x, y, player, types[random.nextInt(3)], 3));
                    }
                    x += gp.tileSize;
                }
                y += gp.tileSize;
            }
        }
    }

    public void resetClearMaps() {
        Set<Integer> cleared = new java.util.HashSet<>(clearMaps);
        if (cleared.containsAll(java.util.List.of(0, 1, 2, 3, 4, 5, 6, 7, 8))) {
            clearMaps.clear();
            Player.score++;
            Enemy.hpMultiplier++;
        }
    }
}
