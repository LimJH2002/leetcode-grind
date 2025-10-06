import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int currentLevel = Math.max(grid[0][0], grid[n-1][n-1]);

        while (true) {
            if (canReach(grid, currentLevel)) {
                return currentLevel;
            }
            currentLevel++;
        }
    }

    private boolean canReach(int[][] grid, int level) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int row = pos[0], col = pos[1];

            if (row == n-1 && col == n-1) {
                return true;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol] &&
                        grid[newRow][newCol] <= level) {

                    visited[newRow][newCol] = true;
                    stack.push(new int[]{newRow, newCol});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid = {
                {10, 12, 4, 6},
                {9, 11, 3, 5},
                {1, 7, 13, 8},
                {2, 0, 15, 14}
        };
        System.out.println(sol.swimInWater(grid));
    }
}