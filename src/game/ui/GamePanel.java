package src.game.ui;

import java.awt.*;
import javax.swing.JPanel;
import src.game.game_logic.input.KeyHandler;

public class GamePanel extends JPanel {
    
    //Screen Dimensions

    final int initialTileSize = 16;
    final int scale = 2;

    public final int tileSize = initialTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //Placeholder
        this.setDoubleBuffered(true);
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {

    }

}
