class Solution {
  public int jump(int[] nums) {
    int currMax = 0;
    int nextMax = 0;
    int hops = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      nextMax = Math.max(nextMax, i + nums[i]);

      if (i >= currMax) {
        currMax = nextMax;
        hops++;
      }
    }

    return hops;
  }
}