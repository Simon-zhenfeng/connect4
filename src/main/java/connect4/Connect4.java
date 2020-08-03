package connect4;

import java.util.Arrays;

/**
 * @author Simon
 * @date 2020/8/2 22:58
 */
public class Connect4 {
    public static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final String EMPTY = " ";
    private final String[][] board = new String[ROWS][COLUMNS];

    public Connect4() {
        for (String[] row : board) {
            Arrays.fill(row, EMPTY);
        }
    }

    public int getNumberOfDiscs() {
        int result = 0;
        for (String[] row : board) {
            for (String ele : row) {
                if (!ele.equals(EMPTY)) {
                    result++;
                }
            }
        }
        return result;
    }

    public int putDiscInColumn(int column) {
        if (column < 0 || column >= COLUMNS) {
            throw new RuntimeException("Outside board");
        }
        int level = 0;
        for (String[] row : board) {
            if (row[column].equals(EMPTY)) {
                row[column] = "X";
                return level;
            }
            level++;
        }
        throw new RuntimeException("No more room");
    }
}
