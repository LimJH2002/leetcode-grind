class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = prices.clone();

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        result[prices.length - 1] = prices[prices.length - 1];

        return result;
    }

    static void main() {
        Solution sol = new Solution();
        sol.finalPrices(new int[] {8,4,6,2,3});
    }
}