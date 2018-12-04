import javax.swing.*;
import java.awt.*;

public class FourInRowGame {
    public static void main(String[] args) {
        GameGrid gameGrid = new GameGrid();
        GamePanel gamePanel = new GamePanel(gameGrid);

        JFrame game = new JFrame();
        game.setSize(600, 600);
        game.add(gameGrid, BorderLayout.CENTER);
        game.add(gamePanel, BorderLayout.SOUTH);
        game.setVisible(true);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
