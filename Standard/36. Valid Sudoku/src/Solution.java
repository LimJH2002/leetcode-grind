import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !(isValidRow(board[i], j) && isValidCol(board, i, j))) {
                    return false;
                }
                if (i % 3 == 0 && j % 3 == 0 && !isValidSub(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[] boardRow, int col) {
        for (int i = 0; i < boardRow.length; i++) {
            if (boardRow[i] == boardRow[col] && i != col) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }

            if (board[i][col] == board[row][col]) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSub(char[][] board, int row, int col) {
        int startingCol = (col / 3) * 3;
        int startingRow = (row / 3) * 3;
        int endingCol = startingCol + 2;
        int endingRow = startingRow + 2;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = startingRow; i <= endingRow; i++) {
            for (int j = startingCol; j <= endingCol; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (hashSet.contains((int) board[i][j])) {
                    return false;
                } else {
                    hashSet.add((int) board[i][j]);
                }
            }
        }
        return true;
    }
}