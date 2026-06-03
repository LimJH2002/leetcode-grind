class Solution {
    int[] distinctWays;

    public int climbStairs(int n) {
        distinctWays = new int[n + 1];
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        if (distinctWays[n] != 0) {
            return distinctWays[n];
        } else {
            int ways = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
            distinctWays[n] = ways;
            return ways;
        }
    }

}