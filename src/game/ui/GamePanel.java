package src.game.ui;

import java.awt.*;
import javax.swing.JPanel;
import src.game.game_logic.input.KeyHandler;
import src.game.main.GameState;

public class GamePanel extends JPanel {
    
    //Screen Dimensions

    final int initialTileSize = 16;
    final int scale = 2;

    public final int tileSize = initialTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    private final KeyHandler keyH = new KeyHandler();
    private final GameState gameState = new GameState(this, keyH);

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
        gameState.render(g2);
    }

    public void requestRepaint() {
        repaint();
    }
}
