import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int dest = flight[1];
                int price = flight[2];
                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }
                temp[dest] = Math.min(temp[dest], prices[from] + price);
            }
            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // Expected: 7
    }
}
