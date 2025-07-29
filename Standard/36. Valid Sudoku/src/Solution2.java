import java.util.HashSet;

class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        if (!isValidRow(board) || !isValidCol(board)) {
            return false;
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (i % 3 == 0 && j % 3 == 0 && !isValidSub(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board) {
        for (char[] row : board) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (char num : row) {
                if (num == '.') {
                    continue;
                }

                if (hashSet.contains((int) num)) {
                    return false;
                } else {
                    hashSet.add((int) num);
                }
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                int num = board[j][i];
                if (num == '.') {
                    continue;
                }

                if (hashSet.contains((int) num)) {
                    return false;
                } else {
                    hashSet.add((int) num);
                }
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
