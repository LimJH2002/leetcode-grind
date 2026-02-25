import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;

        for (int[] ints : grid) {
            map.put(Arrays.toString(ints), map.getOrDefault(Arrays.toString(ints), 0) + 1);
        }

        int[] currentArray =  new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                currentArray[j] = grid[j][i];
            }

            if (map.containsKey(Arrays.toString(currentArray))) {
                res += map.get(Arrays.toString(currentArray));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalPairs(new int[][]{{2, 1}, {3, 32}}));
    }
}