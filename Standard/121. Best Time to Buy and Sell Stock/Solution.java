class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int lowestBuy = Integer.MAX_VALUE;

    for (int price : prices) {
      lowestBuy = Math.min(price, lowestBuy);
      maxProfit = Math.max(maxProfit, price - lowestBuy);
    }

    return maxProfit;
  }
}