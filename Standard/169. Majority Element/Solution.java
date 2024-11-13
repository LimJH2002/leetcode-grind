class Solution {
  public int majorityElement(int[] nums) {
    int num = nums[0];
    int currentCount = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != num) {
        if (currentCount > 0) {
          currentCount--;
        } else {
          num = nums[i];
          currentCount = 1;
        }
      } else {
        currentCount++;
      }
    }

    return num;
  }
}