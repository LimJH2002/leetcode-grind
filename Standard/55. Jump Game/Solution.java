class Solution {
  public boolean canJump(int[] nums) {
    int maxPosition = 0;

    for (int i = 0; i < nums.length; i++) {
      if (maxPosition < i) {
        return false;
      }

      maxPosition = Math.max(maxPosition, i + nums[i]);
    }

    return true;
  }
}