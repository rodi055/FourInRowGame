import javax.swing.*;

public class GameInfo {
    private static final int rows = 6;
    private static final int cols = 7;
    private static int[][] matrix = new int[6][7];

    public static boolean isColumnFull(int col) {
        if (matrix[0][col] != 0) { //if there is a token in the upper row
            return true;
        }
        return false;
    }

    public static void resetGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static boolean checkWinningOrDraw() {
        int winner = getWinner();
        switch (winner) {
            case -1:
                return endGameWithMessage("Game ends with draw...");
            case 1:
                return endGameWithMessage("Blue player wins...");
            case 2:
                return endGameWithMessage("Red player wins...");
            default:
                return false;
        }
    }

    private static boolean endGameWithMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
        resetGrid();
        return true;
    }

    public static int getWinner() {
        int[][] directions = {{1, 0}, {1, -1}, {1, 1}, {0, 1}};
        for (int[] d : directions) {
            Integer p = getWinnerIfThereIs4InRow(d);
            if (p != null) {
                return p;
            }
        }
        if (noWinnerYet()) {
            return 0; // no winner yet
        }
        return -1; // draw
    }

    private static boolean noWinnerYet() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Integer getWinnerIfThereIs4InRow(int[] d) {
        int di = d[0];
        int dj = d[1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int lastI = i + 3 * di;
                int lastJ = j + 3 * dj;
                if (0 <= lastI && lastI < rows && 0 <= lastJ && lastJ < cols) {
                    int p = matrix[i][j];
                    if (p != 0
                            && p == matrix[i + di][j + dj]
                            && p == matrix[i + 2 * di][j + 2 * dj]
                            && p == matrix[lastI][lastJ]) {
                        return p;
                    }
                }
            }
        }
        return null;
    }

    public static void play(int finalJ, boolean[] playerOne) {
        int i;
        for (i = 5; i >= 0; i--) {
            if (matrix[i][finalJ] == 0) {
                if (playerOne[0]) {
                    matrix[i][finalJ] = 1;
                } else {
                    matrix[i][finalJ] = 2;
                }
                playerOne[0] = !playerOne[0];
                break;
            }
        }
    }

    public static boolean isPlayer1(int i, int j) {
        if (matrix[i][j] == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPlayer2(int i, int j) {
        if (matrix[i][j] == 2) {
            return true;
        }
        return false;
    }
}
