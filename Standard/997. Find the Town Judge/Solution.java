class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println(s.findJudge(3, trust));
    }
}