import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GamePanel extends JPanel {
    private static final int rows = 6;
    private static final int cols = 7;
    private JButton[] buttons = new JButton[7];
    private GameGrid gameGrid;

    GamePanel(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
        final boolean[] player = {true};
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, cols));
        for (int j = 0; j <= rows; j++) {
            createButton(player, panel, j);
        }
        add(panel);
        createClearButton();
    }

    private void createClearButton() {
        JButton btn = new JButton(("clear"));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGrid();
                gameGrid.repaint();
                JOptionPane.showMessageDialog(null, "Starting new game...");
            }
        });
        add(btn, BorderLayout.PAGE_END);
    }

    private void createButton(boolean[] player, JPanel panel, int j) {
        JButton button = new JButton(String.valueOf(j + 1));
        final int finalJ = j;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.play(finalJ, player);
                gameGrid.repaint();
                if (Game.checkWinningOrDraw()) {
                    resetGrid();
                } else {
                    enableOrDisableButton(button, finalJ);
                }
            }
        });
        buttons[j] = button;
        panel.add(button);
    }

    private void enableOrDisableButton(JButton button, int col) {
        if (Game.isColumnFull(col)) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    private void resetGrid() {
        Game.resetGrid();
        for (int j = 0; j < cols; j++) {
            buttons[j].setEnabled(true);
        }
    }
}
