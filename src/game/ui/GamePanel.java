package game.ui;

import game.game_logic.input.KeyHandler;
import game.game_logic.tile.TileManager;
import game.main.GameState;
import java.awt.*;
import javax.swing.JPanel;

/**
 * The JPanel objects the game is rendered inside of.
 * A coordinate plane with 16x16 tiles.
 */
public class GamePanel extends JPanel {
    
    //Screen Dimensions

    final int initialTileSize = 16;
    final int scale = 3;

    public final int tileSize = initialTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 9;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    public final TileManager tileM = new TileManager(this);
    private final KeyHandler keyH = new KeyHandler();
    private final GameState gameState = new GameState(this, keyH);

    /**
     * Constructor.
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //Placeholder
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void update() {
        gameState.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        gameState.render(g2);
    }

    public void requestRepaint() {
        repaint(); 
    }
}
