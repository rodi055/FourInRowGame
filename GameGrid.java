import javax.swing.*;
import java.awt.*;

class GameGrid extends JPanel {
    private static final int rows = 6;
    private static final int cols = 7;

    public GameGrid() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getSize().width;
        int height = getSize().height;

        int rowHt = height / rows;
        for (int i = 0; i < rows; i++) {
            g.drawLine(0, i * rowHt, width, i * rowHt);
        }

        int rowWid = width / (cols);
        for (int i = 0; i < cols; i++) {
            g.drawLine(i * rowWid, 0, i * rowWid, height);
        }

        drowTokens(g, rows, cols, rowHt, rowWid);
    }

    private void drowTokens(Graphics g, int rows, int cols, int rowHt, int rowWid) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                drawBlueOrRed(g, rowHt, rowWid, i, j);
            }
        }
    }

    private void drawBlueOrRed(Graphics g, int rowHt, int rowWid, int i, int j) {
        if (GameInfo.isPlayer1(i, j)) {
            g.setColor(Color.BLUE);
            g.fillOval(j * rowWid, i * rowHt, rowWid, rowHt);
        } else if (GameInfo.isPlayer2(i, j)) {
            g.setColor(Color.RED);
            g.fillOval(j * rowWid, i * rowHt, rowWid, rowHt);
        }
    }
}
