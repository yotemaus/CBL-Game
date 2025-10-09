package src.game.ui;

import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    //Screen Dimensions

    final int initialTileSize = 16;
    final int scale = 2;

    final int tileSize = initialTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    final int screenWidth = maxScreenCol * tileSize;
    final int screenHeight = maxScreenRow * tileSize;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); //Placeholder
        this.setDoubleBuffered(true);
    }

}
