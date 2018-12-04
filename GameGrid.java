import javax.swing.*;
import java.awt.*;

class GameGrid extends JPanel {
    private static final int rows = Game.rows;
    private static final int cols = Game.cols;

    public GameGrid() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int componentWidth = getSize().width;
        int componentHeight = getSize().height;
        int cellHeight = componentHeight / rows;
        int cellWidth = componentWidth / cols;

        drawGrid(g, componentWidth, componentHeight, cellHeight, cellWidth);
        drowTokens(g, cellHeight, cellWidth);
    }

    private void drawGrid(Graphics g, int width, int height, int cellHeight, int cellWidth) {
        for (int i = 0; i < rows; i++) {
            g.drawLine(0, i * cellHeight, width, i * cellHeight);
        }
        for (int i = 0; i < cols; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, height);
        }
    }

    private void drowTokens(Graphics g, int cellHeight, int cellWidth) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                drawBlueOrRed(g, cellHeight, cellWidth, i, j);
            }
        }
    }

    private void drawBlueOrRed(Graphics g, int cellHeight, int cellWidth, int i, int j) {
        if (Game.isFirstPlayer(i, j)) {
            g.setColor(Color.BLUE);
            g.fillOval(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
        } else if (Game.isSecondPlayer(i, j)) {
            g.setColor(Color.RED);
            g.fillOval(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
        }
    }
}
